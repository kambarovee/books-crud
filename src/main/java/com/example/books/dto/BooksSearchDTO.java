package com.example.books.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BooksSearchDTO implements Serializable {
	private String authorName;
	private String bookName;
}
