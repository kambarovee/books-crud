package com.example.books.service;

import java.util.List;
import java.util.Optional;

import com.example.books.dto.BooksDTO;
import com.example.books.dto.BooksSearchDTO;

public interface BooksService {
	List<BooksDTO> getAll();
	
	BooksDTO create(BooksDTO dto);
	BooksDTO update(BooksDTO dto);

	void delete(String id);

	Optional<BooksDTO> get(String id);

	List<BooksDTO> getBySearch(BooksSearchDTO dto);
}
