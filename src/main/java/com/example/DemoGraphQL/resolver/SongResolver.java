package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Song;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.SongRepository;

public class SongResolver implements GraphQLResolver<Song> {
    private AuthorRepository authorRepository;
    private SongRepository songRepository;

    public SongResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
	
}
