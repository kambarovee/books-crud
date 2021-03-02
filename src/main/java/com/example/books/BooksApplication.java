package com.example.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.books.repository.BooksRepository;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories(basePackageClasses = BooksRepository.class )
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}
