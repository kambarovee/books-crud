package com.example.books.resource.implementation;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.books.dto.BooksDTO;
import com.example.books.dto.BooksSearchDTO;
import com.example.books.resource.BooksResource;
import com.example.books.service.BooksService;
import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor

public class BooksResourceImplementation implements BooksResource {
	@Autowired
	private final BooksService service;

	@Override
	public ResponseEntity<List<BooksDTO>> getAll() {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.getAll());
	}

	@Override
	public ResponseEntity<BooksDTO> create(@Valid BooksDTO dto) {
		// TODO Auto-generated method stub
		final BooksDTO Books = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(Books);
	}

	@Override
	public ResponseEntity<BooksDTO> update(@Valid BooksDTO dto) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.update(dto));
	}

	@Override
	public ResponseEntity<Void> delete(String id) {
		// TODO Auto-generated method stub
		service.delete(id);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<BooksDTO> get(String id) {
		// TODO Auto-generated method stub
		final BooksDTO booksDTO = service.get(id).orElseThrow(() -> new RuntimeException("Can't find Book"));
		return ResponseEntity.ok(booksDTO);
	}

	@Override
	public ResponseEntity<List<BooksDTO>> getBySearch(@Valid BooksSearchDTO dto) {
		// TODO Auto-generated method stub
		return ResponseEntity.ok(service.getBySearch(dto));
	}
}
