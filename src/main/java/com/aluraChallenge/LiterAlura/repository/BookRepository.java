package com.aluraChallenge.LiterAlura.repository;

import com.aluraChallenge.LiterAlura.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {
    List<Book> listBooks();
}
