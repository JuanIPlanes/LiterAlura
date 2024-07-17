package com.aluraChallenge.LiterAlura.model;

public enum Language {
    ENGLISH("en"),
    SPANISH("es"),
    FRANCE("fr"),
    CHINESE("ch");

    private String language;
    Language (String language){
        this.language = language;
    }

    public static Language fromString(String text) {
        for (Language Language : Language.values()) {
            if (Language.language.equalsIgnoreCase(text)) {
                return Language;
            }
        }
        throw new IllegalArgumentException("Ningun Lenguaje encontrado: " + text);
    }


}
