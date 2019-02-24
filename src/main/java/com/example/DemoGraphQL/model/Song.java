package com.example.DemoGraphQL.model;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @Column(name="song_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="song_title", nullable = false)
    private String title;

    @Column(name="song_duration", nullable = false)
    private String duration;
    
    @Column(name="song_genre", nullable = false)
    private String genre;
    
    @ManyToOne
    @JoinColumn(name = "artist_id",
            nullable = false, updatable = false)
    private Artist artist;

    public Song() {
    }

    public Song(Long id) {
        this.id = id;
    }

    public Song(String title, String duration, String genre, Artist artist) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song author = (Song) o;

        return id.equals(author.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
