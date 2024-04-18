package com.rasel.microservices.book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {
	
	private Long id;
	private String isbn;
	private String title;
	private Integer year;
	private Author author;

}