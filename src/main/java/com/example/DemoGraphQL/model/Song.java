package com.example.DemoGraphQL.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Song implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "song_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "song_title", nullable = false)
	private String title;

	@Column(name = "song_duration", nullable = false)
	private String duration;

	@Column(name = "song_genre", nullable = false)
	private String genre;

	@ManyToOne
	@JoinColumn(name = "artist_id", nullable = false, updatable = false)
	private Artist artist;

}
