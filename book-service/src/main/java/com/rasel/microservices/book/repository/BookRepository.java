package com.rasel.microservices.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rasel.microservices.book.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
