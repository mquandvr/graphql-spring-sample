package com.example.DemoGraphQL.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.example.DemoGraphQL.model.Song;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.SongRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SongResolver implements GraphQLResolver<Song> {
	
	@Autowired
    private AuthorRepository authorRepository;
	
	@Autowired
    private SongRepository songRepository;

    public SongResolver(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
	
}
