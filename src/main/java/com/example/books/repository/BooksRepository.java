package com.example.books.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.books.document.Books;

public interface BooksRepository extends MongoRepository<Books, String> {
	Optional<Books> findByIdIsNotAndAuthorName(String id, String authorName);
	
	List<Books> findByNameOrBookName(String authorName, String bookName);
}
