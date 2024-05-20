FROM azul/zulu-openjdk-alpine:21
ENV DATASOURCE_URL DATASOURCE_URL
ENV DATASOURCE_USERNAME DATASOURCE_USERNAME
ENV DATASOURCE_PASSWORD DATASOURCE_PASSWORD
ENV AWS_ACCESS_KEY AWS_ACCESS_KEY
ENV AWS_SECRET_KEY AWS_SECRET_KEY
ENV AWS_REGION AWS_REGION
ENV AWS_ENDPOINT AWS_ENDPOINT
EXPOSE 8084
COPY target/*.jar entrega-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/entrega-0.0.1-SNAPSHOT.jar"]




