package com.example.DemoGraphQL.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;

public class AuthorResolver implements GraphQLResolver<Author> {
    private AuthorRepository authorRepository;
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
}
