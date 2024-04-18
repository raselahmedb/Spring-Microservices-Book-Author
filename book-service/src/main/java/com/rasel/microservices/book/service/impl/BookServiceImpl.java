package com.rasel.microservices.book.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rasel.microservices.book.dto.Author;
import com.rasel.microservices.book.dto.BookResponse;
import com.rasel.microservices.book.model.Book;
import com.rasel.microservices.book.repository.BookRepository;
import com.rasel.microservices.book.service.BookService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final RestTemplate restTemplate;
	
	public ResponseEntity<?> addBook(Book book) {
		try {
			return ResponseEntity.ok(bookRepository.save(book));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}
	
	public ResponseEntity<?> fetchBookById(Long bookId) {
		Optional<Book> book = bookRepository.findById(bookId);
		
		if(book.isPresent()) {
			Author author = restTemplate.getForObject("http://AUTHOR-SERVICE/author/" + book.get().getAuthorId(), Author.class);
			
			BookResponse bookResponse = new BookResponse(
					book.get().getId(),
					book.get().getIsbn(),
					book.get().getTitle(),
					book.get().getYear(), 
					author);
			return ResponseEntity.ok(bookResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No student found!");
		}
	}
	
	public ResponseEntity<?> fetchBooks() {
		List<Book> books = bookRepository.findAll();
		if (!books.isEmpty()) {
			return ResponseEntity.ok(books);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Students");
		}
	}
}
