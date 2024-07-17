package com.aluraChallenge.LiterAlura.model;


import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.annotation.Nullable;

import java.util.List;

public record GetBooksData(
    @JsonAlias("count") int count,
    @Nullable @JsonAlias("next") String next,
    @JsonAlias("previous") int previous,
    @JsonAlias("results") List<BookData> results
    ) {
}
