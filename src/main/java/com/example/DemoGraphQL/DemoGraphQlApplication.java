package com.example.DemoGraphQL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.DemoGraphQL.exception.GraphQLErrorAdapter;
import com.example.DemoGraphQL.repository.ArtistRepository;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.SongRepository;
import com.example.DemoGraphQL.resolver.AuthorResolver;
import com.example.DemoGraphQL.resolver.BookResolver;
import com.example.DemoGraphQL.resolver.Mutation;
import com.example.DemoGraphQL.resolver.Query;

import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;

@SpringBootApplication
public class DemoGraphQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGraphQlApplication.class, args);
	}

	@Bean
	public GraphQLErrorHandler errorHandler() {
		return new GraphQLErrorHandler() {
			@Override
			public List<GraphQLError> processErrors(List<GraphQLError> errors) {
				List<GraphQLError> clientErrors = errors.stream()
						.filter(this::isClientError)
						.collect(Collectors.toList());

				List<GraphQLError> serverErrors = errors.stream()
						.filter(e -> !isClientError(e))
						.map(GraphQLErrorAdapter::new)
						.collect(Collectors.toList());

				List<GraphQLError> e = new ArrayList<>();
				e.addAll(clientErrors);
				e.addAll(serverErrors);
				return e;
			}

			protected boolean isClientError(GraphQLError error) {
				return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
			}
		};
	}

	@Bean
	public BookResolver authorResolver(AuthorRepository authorRepository) {
		return new BookResolver(authorRepository);
	}
	
	@Bean
	public AuthorResolver bookResolver(BookRepository bookRepository) {
		return new AuthorResolver(bookRepository);
	}

	@Bean
	public Query query(AuthorRepository authorRepository,
						BookRepository bookRepository,
						SongRepository songRepository,
						ArtistRepository artistRepository) {
		return new Query(authorRepository, bookRepository, songRepository, artistRepository);
	}

	@Bean
	public Mutation mutation(AuthorRepository authorRepository,
								BookRepository bookRepository,
								SongRepository songRepository,
								ArtistRepository artistRepository) {
		return new Mutation(authorRepository, bookRepository, songRepository, artistRepository);
	}

//	@Bean
//	public CommandLineRunner demo(AuthorRepository authorRepository,
//									BookRepository bookRepository,
//									SongRepository songRepository,
//									ArtistRepository artistRepository
//								) {
//		return (args) -> {
//			Author author = new Author("Herbert", "Schildt");
//			authorRepository.save(author);
//
//			bookRepository.save(new Book("Java: A Beginner's Guide, Sixth Edition", "0071809252", 728, author));
//			
//			
//			Artist artist = new Artist("Nguyen Van A", "VietNam");
//			artistRepository.save(artist);
//			
//			List<Song> songs = new ArrayList<>();
//			Song song1 = new Song("Abc", "5min", "Male", artist);
//			Song song2 = new Song("Xyz", "3min", "Female", artist);
//			Song song3 = new Song("123", "1min", "Male", artist);
//			Song song4 = new Song("Muon ruou to tinh", "3min", "Male", artist);
//			songRepository.save(song1);
//			songRepository.save(song2);
//			songRepository.save(song3);
//			songRepository.save(song4);
//			
//			songs.add(song1);
//			songs.add(song2);
//			songs.add(song3);
//			songs.add(song4);
//		};
//	}
}
