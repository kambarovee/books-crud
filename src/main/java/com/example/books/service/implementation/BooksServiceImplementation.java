package com.example.books.service.implementation;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import com.example.books.service.*;
import com.example.books.dto.BooksDTO;
import com.example.books.dto.BooksSearchDTO;
import com.example.books.mapper.BooksMapper;
import com.example.books.repository.BooksRepository;
import com.example.books.document.Books;
@Service
@Lazy
@Transactional
@AllArgsConstructor
public class BooksServiceImplementation implements BooksService {
	@Autowired
	private BooksRepository repository;
	@Autowired
	private final BooksMapper mapper;
	
	@Override
	
	@Transactional(readOnly = true)
	public List<BooksDTO> getAll(){
		return mapper.toDto(repository.findAll());
	}
	
	@Override
	public BooksDTO create(BooksDTO dto) {
		if (dto == null) {
			throw new RuntimeException("Please provide data with required info to create Book");
		}
		if (dto.getId() != null && dto.getId().trim().length() > 0) {
			throw new RuntimeException("You can't create new Book, because it already exists");
		}
		duplicateCheck(dto);
		final Books doc = mapper.toDocument(dto);
		return mapper.toDto(repository.save(doc));
	}
	
	private void duplicateCheck(final BooksDTO doc) {

		final Optional<Books> optCountry = repository.findByIdIsNotAndBookName(doc.getId(), doc.getBookName());
		if (optCountry.isPresent()) {
			throw new RuntimeException("There is already that book");
		}

	}
	
	@Override
	public BooksDTO update(BooksDTO dto) {
		if (dto == null) {
			throw new RuntimeException("Please provide valid data to update Book");

		}
		if (dto.getId() == null || !ObjectId.isValid(dto.getId())) {
			throw new RuntimeException("Please provide valid data to update Book");

		}
		if (!repository.existsById(dto.getId())) {
			throw new RuntimeException("Book not found");
		}
		duplicateCheck(dto);

		final Books doc = mapper.toDocument(dto);

		return mapper.toDto(repository.save(doc));
	}

	@Override
	public void delete(String id) {
		if (id == null || !ObjectId.isValid(id)) {
			throw new RuntimeException("Please, provide valid Book to delete ");
		}
		if (!repository.existsById(id)) {
			throw new RuntimeException("Book not found");
		}
		repository.deleteById(id);
	}

	@Override
	public Optional<BooksDTO> get(String id) {
		if (id == null || !ObjectId.isValid(id)) {
			throw new RuntimeException("Please, provide valid Book");
		}
		return repository.findById(id).map(mapper::toDto);
	}

	@Override
	public List<BooksDTO> getBySearch(BooksSearchDTO dto) {
		if (dto == null) {
			throw new RuntimeException("Please, provide valid 'search data'");

		}
		return mapper.toDto(repository.findByNameOrBookName(dto.getAuthorName(), dto.getBookName()));
	}


}
