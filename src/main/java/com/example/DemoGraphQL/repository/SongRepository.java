package com.example.DemoGraphQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.DemoGraphQL.model.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

	Iterable<Song> findByGenre(String genre);
}
