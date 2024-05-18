package com.entrega.util;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.Arrays;
import java.util.List;

public class StringListConverter implements DynamoDBTypeConverter<String, List<String>> {
    @Override
    public String convert(List<String> objects) {
        return String.join(",", objects);
    }

    @Override
    public List<String> unconvert(String s) {
        return Arrays.asList(s.split(","));
    }
}
