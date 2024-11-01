package com.yunussemree.movies.movie;

import java.util.List;

public interface IMovieService {
    public List<Movie> allMovies();

    Movie getMovieById(String imdbId);
}
