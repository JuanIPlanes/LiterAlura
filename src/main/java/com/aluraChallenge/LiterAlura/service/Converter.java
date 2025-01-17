package com.aluraChallenge.LiterAlura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Converter implements IConverter {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public <T> T jsonStringToModel(String json, Class<T> clase) {
        try {
            return objectMapper.readValue(json,clase);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
