package com.aluraChallenge.LiterAlura.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Book {
    private int id;
    private String title;
    private List<Author> authors;
    @Enumerated(EnumType.STRING)
    private List<Language> languages;
    private int downloadCount;
    private int apiId;

    public Book(int id, String title, List<Author> authors, List<Language> languages, int downloadCount, int apiId) {
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.languages = languages;
        this.downloadCount = downloadCount;
        this.apiId = apiId;
    }

    @Override
    public String toString() {
        return "\n\nBook{" +
                "\nid=" + id +
                ",\n title='" + title + '\'' +
                ",\n authors=" + authors.stream().map(Author::toString).collect(Collectors.joining()) +
                ",\n languages=" + languages.stream().map(Enum::name).collect(Collectors.joining()) +
                ",\n downloadCount=" + downloadCount +
                ",\n apiId=" + apiId +
                '}';
    }

    public Book(BookData book) {
        this.apiId = book.apiId();
        this.title = book.title();
        this.authors = book.authors().stream().map(Author::fromAuthorData).collect(Collectors.toList());
        this.languages = book.languages().stream().map(Language::fromString).collect(Collectors.toList());
        this.downloadCount = book.downloadCount();
        this.apiId = book.apiId();
    }


    static public Book fromBookData(BookData data){
        return new Book(
                data.apiId(),
                data.title(),
                data.authors().stream().map(Author::fromAuthorData).collect(Collectors.toList()),
                data.languages().stream().map(Language::fromString).collect(Collectors.toList()),
                data.downloadCount(),
                data.apiId()
        );
    }
}
