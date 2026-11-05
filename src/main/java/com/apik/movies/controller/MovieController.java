package com.apik.movies.controller;

import com.apik.movies.model.Movie;
import com.apik.movies.repository.MovieRepository;
import jakarta.validation.Valid; // Required for @Valid
import com.apik.movies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; // Required for BindingResult
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // 1. View all movies (Read)
    @GetMapping
    public String viewAllMovies(Model model) {
        model.addAttribute("movies", movieRepository.findAll());
        return "movies"; // /WEB-INF/movies.jsp देखाउने
    }

    // 2. Show Add Movie Form
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie"; // /WEB-INF/add-movie.jsp देखाउने
    }

    // 3. Save New Movie (Create) - ADDED @Valid and BindingResult
    @PostMapping("/add")
    public String saveMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
        
        // If validation fails, stop and return back to the add form
        if (bindingResult.hasErrors()) {
            return "add-movie"; 
        }

        System.out.println("--- RECEIVED MOVIE FROM FORM ---");
        System.out.println("Title: " + movie.getTitle());
        System.out.println("Director: " + movie.getDirector());
        System.out.println("Release Year: " + movie.getReleaseYear());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("--------------------------------");
        
        movieRepository.save(movie);
        return "redirect:/movies";
    }

    // 4. Show Edit Form (Update)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        
        // यदि ID भेटिएन भने, .orElseThrow() ले हाम्रो Custom Exception फ्याँक्छ!
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        
        model.addAttribute("movie", movie);
        return "edit-movie";
    }

    // 5. Update Movie Data (Update) - ADDED @Valid and BindingResult
    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable String id, @Valid @ModelAttribute("movie") Movie movieDetails, BindingResult bindingResult, Model model) {
        
        // If validation fails, stop and return back to the edit form
        if (bindingResult.hasErrors()) {
            return "edit-movie"; 
        }

        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movie.setTitle(movieDetails.getTitle());
            movie.setDirector(movieDetails.getDirector());
            movie.setReleaseYear(movieDetails.getReleaseYear());
            movie.setGenre(movieDetails.getGenre());
            movieRepository.save(movie);
        }
        return "redirect:/movies";
    }

    // 6. Delete Movie (Delete)
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable String id) {
        movieRepository.deleteById(id);
        return "redirect:/movies";
    }
}