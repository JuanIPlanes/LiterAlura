package com.aluraChallenge.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(
        @JsonProperty("birth_year") int birthYear,
        @JsonProperty("death_year") int deathYear,
        @JsonAlias("name") String name
) {
}
