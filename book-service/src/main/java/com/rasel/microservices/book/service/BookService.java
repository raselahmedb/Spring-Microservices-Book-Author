package com.rasel.microservices.book.service;

import org.springframework.http.ResponseEntity;

import com.rasel.microservices.book.model.Book;

public interface BookService {

	ResponseEntity<?> addBook(Book book);
	
	ResponseEntity<?> fetchBookById(Long bookId);
	
	public ResponseEntity<?> fetchBooks();
	
}
