package com.rasel.microservices.book.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rasel.microservices.book.model.Book;
import com.rasel.microservices.book.service.BookService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("*")
@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
   
    private final BookService bookService;
    
    @GetMapping("/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        return bookService.fetchBookById(bookId);
    }
    
    @GetMapping
    public ResponseEntity<?> getBooks(){
        return bookService.fetchBooks();
    }
    
    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

}