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
public class Artist implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "artist_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "artist_name", nullable = false)
	private String name;

	@Column(name = "artist_country", nullable = false)
	private String country;

	public Artist(String name, String country) {
		this.name = name;
		this.country = country;
	}

}
