package com.training.demo.controller;

import com.training.demo.model.Movie;
import com.training.demo.service.MovieService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
@AllArgsConstructor
public class MovieController {
    
    private final MovieService movieService;

    @GetMapping("/{name}")
    public Movie getMovie(@PathVariable String name){
        return movieService.getMovie(name);
    }
    @GetMapping()
    public List<Movie> getMovies() {
        return movieService.fetchAllMovies();
    }

    @PostMapping()
    public Movie saveMovie(@RequestBody Movie movieRequest) {
        return movieService.saveMovie(movieRequest);
    }


    @PutMapping()
    public Movie updateMovie(@RequestBody Movie movie) {
        return movieService.updateMovie(movie);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteMovie(@PathVariable String name) {
        movieService.deleteByName(name);
        return ResponseEntity.ok("Todo deleted successfully!.");
    }
}
