package com.example.books.document;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("books")
@TypeAlias("Books")
public class Books implements Serializable {
	@JsonProperty("id")
	@MongoId(targetType = FieldType.OBJECT_ID)
	private String id;

	@NotBlank
	private String authorName;

	private String bookName;
	
}
