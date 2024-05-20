package com.entrega.service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.entrega.model.dto.EntregaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SQSConsumerService {
    private final AmazonSQS amazonSQSClient;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${AWS_QUEUE_NAME}")
    private String queueName;
    private final String endpointUrl = "http://localhost:8080/api/v1/entrega";

    @Autowired
    public SQSConsumerService(AmazonSQS amazonSQSClient, RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.amazonSQSClient = amazonSQSClient;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    @Scheduled(fixedDelay = 5000) // It runs every 5 seconds.
    public void consumeMessages() {

        String queueUrl = amazonSQSClient.getQueueUrl(queueName).getQueueUrl();
        ReceiveMessageResult receiveMessageResult = amazonSQSClient.receiveMessage(queueUrl);

        if (!receiveMessageResult.getMessages().isEmpty()) {
            com.amazonaws.services.sqs.model.Message message = receiveMessageResult.getMessages().get(0);

            try {
                EntregaDTO entregaDTO = objectMapper.readValue(message.getBody(), EntregaDTO.class);
                String response = restTemplate.postForObject(endpointUrl, entregaDTO, String.class);
                amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
            } catch (Exception e) {
                e.printStackTrace();
            }
            amazonSQSClient.deleteMessage(queueUrl, message.getReceiptHandle());
        }


    }
}
