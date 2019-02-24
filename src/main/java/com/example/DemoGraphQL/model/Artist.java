package com.example.DemoGraphQL.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Artist {
	@Id
	@Column(name = "artist_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "artist_name", nullable = false)
	private String name;

	@Column(name = "artist_country", nullable = false)
	private String country;

	public Artist() {
	}
	
	public Artist(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Artist author = (Artist) o;

		return id.equals(author.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Artist{" + "id=" + id + ", name='" + name + '\'' + ", country='" + country + '\'' + ""
				+ '\'' + '}';
	}
}
