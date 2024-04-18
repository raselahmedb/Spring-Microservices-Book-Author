package com.rasel.microservices.author.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rasel.microservices.author.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
