package com.example.DemoGraphQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.DemoGraphQL.model.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Long> {
}
