package com.example.books.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.books.document.Books;
import com.example.books.dto.BooksDTO;

@Mapper(componentModel = "spring")
public interface BooksMapper {

	Books toDocument(BooksDTO dto);
	BooksDTO toDto(Books document);
	List<Books> toDocument(List<BooksDTO> dtoList);
	List<BooksDTO> toDto(List<Books> documentList);
	
}
