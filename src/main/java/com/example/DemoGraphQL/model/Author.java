package com.example.DemoGraphQL.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @Id
    @Column(name="author_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

	@Column(name = "author_first_name", nullable = false)
	private String firstName;

	@Column(name = "author_last_name", nullable = false)
	private String lastName;
	
	public Author(Long id) {
		this.id = id;
	}

}
