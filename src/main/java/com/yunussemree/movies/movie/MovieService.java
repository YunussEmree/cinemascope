package com.yunussemree.movies.movie;

import com.yunussemree.movies.core.utilities.exceptions.ResourceNotFoundException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService{
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> allMovies() {
        List<Movie> movies = movieRepository.findAll();
        if (movies.isEmpty()) {
            throw new ResourceNotFoundException("Movie is not found when allMovies request");
        }
        return movies;
    }

    @Override
    public Movie getMovieById(String imdbId) {
        return movieRepository.findByImdbId(imdbId).orElseThrow(() -> new ResourceNotFoundException("Movie is not found when getMovieById request"));
    }
}
