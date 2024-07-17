package com.aluraChallenge.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData (
    @JsonProperty("id") int apiId,
    @JsonAlias("title") String title,
    @JsonAlias("authors") List<AuthorData> authors,
    @JsonAlias("languages") List<String> languages,
    @JsonProperty("download_count") int downloadCount
){
}
