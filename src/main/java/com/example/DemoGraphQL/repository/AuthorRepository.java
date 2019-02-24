package com.example.DemoGraphQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
