package com.rasel.microservices.author.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rasel.microservices.author.model.Author;
import com.rasel.microservices.author.service.AuthorService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorController {

	private final AuthorService authorService;
	
	@PostMapping
	public Author createAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	@GetMapping
	public List<Author> getAuthors() {
		return authorService.fetchAuthors();
	}
	
	@GetMapping("/{authorId}")
	public Author getAuthorById(@PathVariable Long authorId) {
		return authorService.fetchAuthorById(authorId);
	}
	
}
