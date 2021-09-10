package com.yehor.movieland.service;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.util.MovieRequest;

public interface MovieService {
    Iterable<Movie> findAll(MovieRequest movieRequest);
    Iterable<Movie> findThreeRandomMovies();
    Iterable<Movie> findMoviesByGenre(int genreId, MovieRequest movieRequest);
}
