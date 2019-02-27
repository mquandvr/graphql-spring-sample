package com.example.DemoGraphQL.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "book_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "book_title", nullable = false)
	private String title;

	@Column(name = "book_isbn", nullable = false)
	private String isbn;

	@Column(name = "book_pageCount", nullable = false)
	private int pageCount;

	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false, updatable = false)
	private Author author;

	public Book(String title, String isbn, int pageCount, Author author) {
		this.title = title;
		this.isbn = isbn;
		this.pageCount = pageCount;
		this.author = author;
	}
}
