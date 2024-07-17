package com.aluraChallenge.LiterAlura;

import com.aluraChallenge.LiterAlura.api.Cli;
import com.aluraChallenge.LiterAlura.repository.AuthorRepository;
import com.aluraChallenge.LiterAlura.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private BookRepository booksRepository;
	private AuthorRepository authorRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	Cli cli = new Cli(booksRepository, authorRepository);
	cli.showMenu();
	}
}
