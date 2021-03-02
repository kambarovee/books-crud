package com.example.book.mapper;

import com.example.books.document.Books;
import com.example.books.dto.BooksDTO;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.example.books.mapper.BooksMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapperImplementation implements BooksMapper {

    @Override
    public Books toDocument(BooksDTO dto) {
        if (dto == null) {
            return null;
        }

        Books books = new Books();

        books.setId(dto.getId());
        books.setAuthorName(dto.getAuthorName());
        books.setBookName(dto.getBookName());

        return books;
    }

    @Override
    public BooksDTO toDto(Books document) {
        if (document == null) {
            return null;
        }

        BooksDTO booksDTO = new BooksDTO();

        booksDTO.setId(document.getId());
        booksDTO.setAuthorName(document.getAuthorName());
        booksDTO.setBookName(document.getBookName());

        return booksDTO;
    }

    @Override
    public List<Books> toDocument(List<BooksDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Books> list = new ArrayList<Books>(dtoList.size());
        for (BooksDTO bookDTO : dtoList) {
            list.add(toDocument(booksDTO));
        }

        return list;
    }

    @Override
    public List<BooksDTO> toDto(List<Books> documentList) {
        if (documentList == null) {
            return null;
        }

        List<BooksDTO> list = new ArrayList<BooksDTO>(documentList.size());
        for (Books books : documentList) {
            list.add(toDto(books));
        }

        return list;
    }
}
