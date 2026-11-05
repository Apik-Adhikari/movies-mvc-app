package com.apik.movies.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.validation.constraints.*; // Import validation annotations

@Document(collection = "movies")
public class Movie {
    
    @Id
    private String id;

    @NotBlank(message = "Movie title cannot be blank!")
    @Size(min = 2, max = 150, message = "Title must be between 2 and 150 characters.")
    private String title;

    @NotBlank(message = "Director name cannot be blank!")
    @Size(min = 2, max = 100, message = "Director name must be between 2 and 100 characters.")
    private String director;

    @NotNull(message = "Release year is required!")
    @Min(value = 1888, message = "Release year must be 1888 or later (first motion picture ever made).")
    @Max(value = 2030, message = "Release year cannot be in the distant future.")
    private Integer releaseYear;

    @NotBlank(message = "Genre is required!")
    private String genre;

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public Integer getReleaseYear() { return releaseYear; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}