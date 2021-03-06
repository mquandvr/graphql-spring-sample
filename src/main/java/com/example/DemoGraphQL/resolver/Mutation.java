package com.example.DemoGraphQL.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.BookNotFoundException;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Song;
import com.example.DemoGraphQL.repository.ArtistRepository;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.SongRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Mutation implements GraphQLMutationResolver {
	
	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
    private AuthorRepository authorRepository;
	
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private ArtistRepository artistRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository,
    		SongRepository songRepository, ArtistRepository artistRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }
    
    public Song newSong(Song songInput) {
    	songRepository.save(songInput);
    	
    	return songInput;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }
    
    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
