package com.example.DemoGraphQL.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.DemoGraphQL.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	List<Book> findByAuthorId(Long id);

	Book findByAuthorIdAndId(Long id, Long id2);
}
