package com.example.books.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.books.dto.*;
@RequestMapping("/api")
public interface BooksResource {
	
	@GetMapping(value = "/books")
	public ResponseEntity<List<BooksDTO>> getAll();
	
	@PostMapping(value = "/books")
	public ResponseEntity<BooksDTO> create(@Valid @RequestBody BooksDTO dto);

	@PutMapping(value = "/books")
	public ResponseEntity<BooksDTO> update(@Valid @RequestBody BooksDTO dto);

	@DeleteMapping(value = "/books/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id);

	@GetMapping(value = "/books/{id}")
	public ResponseEntity<BooksDTO> get(@PathVariable("id") String id);

	@PostMapping(value = "/books/search")
	public ResponseEntity<List<BooksDTO>> getBySearch(@Valid @RequestBody BooksSearchDTO dto);

}
