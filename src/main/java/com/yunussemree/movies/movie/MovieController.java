package com.yunussemree.movies.movie;

import com.yunussemree.movies.core.utilities.exceptions.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.api.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/movies")
public class MovieController {
    IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<ApiResponse> getMovieById(@PathVariable String imdbId) {
        try {
            Movie movie = movieService.getMovieById(imdbId);
            return ResponseEntity.ok(new ApiResponse("Success when get movie by id request", movie));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(409).body(new ApiResponse("Resource not found when get movie by id request", null));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse("Internal server error", null));
        }

    }



}
