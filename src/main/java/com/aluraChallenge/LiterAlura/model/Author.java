package com.aluraChallenge.LiterAlura.model;

public class Author {
    private Integer birthYear; // Can be null
    private Integer deathYear; // Can be null
    private String name;

    @Override
    public String toString() {
        return "Author{" +
                "birthYear=" + birthYear +
                ", deathYear=" + deathYear +
                ", name='" + name + '\'' +
                '}';
    }

    public Author(Integer birthYear, Integer deathYear, String name) {
        this.birthYear = birthYear;
        this.deathYear = deathYear;
        this.name = name;
    }

    public Author(AuthorData author) {
        this.birthYear = author.birthYear();
        this.deathYear = author.deathYear();
        this.name = author.name();
    }

    static public Author fromAuthorData(AuthorData data) {
        return new Author(data.birthYear(), data.deathYear(), data.name());
    }
    
    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Constructors, getters, and setters
}
