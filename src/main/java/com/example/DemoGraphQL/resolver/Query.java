package com.example.DemoGraphQL.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Artist;
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
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private ArtistRepository artistRepository;

	public Query(AuthorRepository authorRepository, BookRepository bookRepository, SongRepository songRepository,
			ArtistRepository artistRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.songRepository = songRepository;
		this.artistRepository = artistRepository;
	}

	public Iterable<Book> findAllBooks() {
		return bookRepository.findAll();
	}
	
	public Iterable<Song> findAllSongs() {
		return songRepository.findAll();
	}
	
	public Iterable<Artist> findAllArtists() {
		return artistRepository.findAll();
	}
	
	public Iterable<Song> filterSongsByGenre(String genre) {
		return songRepository.findByGenre(genre);
	}

	public Iterable<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	public long countBooks() {
		return bookRepository.count();
	}

	public long countAuthors() {
		return authorRepository.count();
	}
}
