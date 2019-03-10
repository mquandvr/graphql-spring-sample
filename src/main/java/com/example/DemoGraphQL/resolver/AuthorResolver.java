package com.example.DemoGraphQL.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AuthorResolver implements GraphQLResolver<Author> {
	
	@Autowired
    private AuthorRepository authorRepository;
	
	@Autowired
    private BookRepository bookRepository;

    public AuthorResolver(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(Author author) {
        return bookRepository.findByAuthorId(author.getId());
    }
    
    public Book getBookById(Author author, Long id) {
    	return bookRepository.findByAuthorIdAndId(author.getId(), id);
//    	return null;
    }
    
    public float salary(Author author) {
    	return 0.30F;
    }
}
