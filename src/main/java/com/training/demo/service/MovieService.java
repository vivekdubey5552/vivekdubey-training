package com.training.demo.service;

import com.training.demo.model.Movie;
import com.training.demo.repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private MongoTemplate mongoTemplate;
    private final MovieRepository movieRepository;

    public Movie getMovie(String name) {
    return movieRepository.findByMovieName(name);
    }

    public List<Movie> fetchAllMovies() {
       return movieRepository.findAll();
    }

    public Movie saveMovie(Movie movie) {
       return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie) {
        var response = movieRepository.findByMovieName(movie.getName());
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(response.getName()));
        Update update = new Update()
                .set("rating",movie.getRating())
                .set("releasedOn", movie.getReleasedOn());
        return mongoTemplate.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true), Movie.class, "movieshow");
    }

    public void deleteByName(String name) {
        Movie movie = movieRepository.findByMovieName(name);
        movieRepository.deleteById(movie.getId());
    }
}
