package com.rasel.microservices.author.service;

import java.util.List;

import com.rasel.microservices.author.model.Author;

public interface AuthorService {
	
	Author addAuthor(Author author);
	
	List<Author> fetchAuthors();
	
	Author fetchAuthorById(Long authorId);

}
