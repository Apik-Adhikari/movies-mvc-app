package com.apik.movies.controller;

import com.apik.movies.model.Movie;
import com.apik.movies.repository.MovieRepository;
import com.apik.movies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieRestController {

    @Autowired
    private MovieRepository movieRepository;

    // 1. READ ALL: सबै मुभीहरूको लिस्ट JSON मा देखाउने (GET)
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // 2. READ BY ID: ID बाट एउटा मात्र मुभी खोज्ने (GET)
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
    }

    // 3. CREATE: नयाँ मुभी JSON मार्फत पठाएर सेभ गर्ने (POST)
    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    // 4. UPDATE: भएको मुभीको डाटा अपडेट गर्ने (PUT)
    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable String id, @RequestBody Movie updatedMovie) {
        // पहिले त्यो मुभी डाटाबेसमा छ कि छैन चेक गर्ने, छैन भने Exception फ्याँक्छ
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        // नयाँ डाटाले पुराना डाटालाई रिप्लेस गर्ने
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setDirector(updatedMovie.getDirector());
        // यदि अरू फिल्डहरू छन् भने यहाँ थप्न सकिन्छ (जस्तै: existingMovie.setReleaseYear(...))

        // अपडेटेड मुभी सेभ गर्ने
        return movieRepository.save(existingMovie);
    }

    // 5. DELETE: ID को आधारमा मुभी डिलिट गर्ने (DELETE)
    @DeleteMapping("/{id}")
    public String deleteMovie(@PathVariable String id) {
        // पहिले मुभी छ कि छैन चेक गर्ने
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        // डाटाबेgbबाट हटाउने
        movieRepository.delete(movie);
        return "Movie deleted successfully with id: " + id;
    }
}