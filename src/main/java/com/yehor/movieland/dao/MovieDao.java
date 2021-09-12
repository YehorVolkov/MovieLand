package com.yehor.movieland.dao;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.util.MovieRequest;

public interface MovieDao {
    Iterable<Movie> findAll(MovieRequest movieRequest);
    Iterable<Movie> findThreeRandomMovies();
}
