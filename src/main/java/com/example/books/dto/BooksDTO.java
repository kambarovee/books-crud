package com.example.books.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BooksDTO implements Serializable{
	private String id;
	@NotBlank
	private String authorName;
	
	private String bookName;

}
