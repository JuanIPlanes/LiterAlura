package com.aluraChallenge.LiterAlura.service;

public interface IConverter {
    <T> T jsonStringToModel(String json, Class<T> clase);
}
