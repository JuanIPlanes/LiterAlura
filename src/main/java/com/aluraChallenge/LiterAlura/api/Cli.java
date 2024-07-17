package com.aluraChallenge.LiterAlura.api;

import com.aluraChallenge.LiterAlura.model.*;
import com.aluraChallenge.LiterAlura.repository.AuthorRepository;
import com.aluraChallenge.LiterAlura.repository.BookRepository;
import com.aluraChallenge.LiterAlura.service.ConsumeAPI;
import com.aluraChallenge.LiterAlura.service.Converter;
import com.aluraChallenge.LiterAlura.service.IConverter;

import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;

public class Cli {
    private final Scanner teclado = new Scanner(System.in);
    private final ConsumeAPI consumeApi = new ConsumeAPI();
    private final String URL_BASE = "https://gutendex.com/";
    private final IConverter converter = new Converter();

    private BookRepository booksRepo;
    private AuthorRepository authorRepo;
    private List<Book> books = new ArrayList<Book>();

    public Cli(BookRepository booksRepository, AuthorRepository authorRepository) {
        this.authorRepo = authorRepository;
        this.booksRepo = booksRepository;
    }


    public void showMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar libros
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    firstRequest();
                    break;
                case 2:
                    System.out.println("Escribe la abreviación de los idiomas que deseas buscar:\n"+"""
                            {
                            'en': english,
                            'es': español,
                            'fr': french,
                            'ch': chinese
                            }""");
                    var lang = teclado.nextLine().split(",");
                    if(lang.length==0)
                        throw new InvalidParameterException("missing languages");
                    findByLanguage(lang);


                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void firstRequest() {
        var json = consumeApi.getData(URL_BASE+"books/");
        GetBooksData data = converter.jsonStringToModel(json, GetBooksData.class);
        data.results().forEach(book->{
            books.add(Book.fromBookData(book));
        });
    }

    private void findByLanguage(List<String> languages) {
        var json = consumeApi.getData(URL_BASE+"books/?languages="+languages.stream().map(Enum::name).collect(Collectors.joining()));
        GetBooksData data = converter.jsonStringToModel(json, GetBooksData.class);
        data.results().forEach(book->{
            books.add(Book.fromBookData(book));
        });
    books.forEach(book -> System.out.printf(book.toString()));
    }
}
