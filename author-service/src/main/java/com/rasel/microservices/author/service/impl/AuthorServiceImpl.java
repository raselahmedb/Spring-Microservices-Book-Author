package com.rasel.microservices.author.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rasel.microservices.author.model.Author;
import com.rasel.microservices.author.repository.AuthorRepository;
import com.rasel.microservices.author.service.AuthorService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
	
	private final AuthorRepository authorRepository;
	
	public Author addAuthor(Author author) {
		return authorRepository.save(author);
	}
	
	public List<Author> fetchAuthors() {
		return authorRepository.findAll();
	}
	
	public Author fetchAuthorById(Long authorId) {
		return authorRepository.findById(authorId).orElseGet(null);
	}

}
