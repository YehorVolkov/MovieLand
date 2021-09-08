package com.yehor.movieland.dao;

import com.yehor.movieland.entity.Movie;

public interface MovieDao {
    Iterable<Movie> findAll();
    Iterable<Movie> getThreeRandomMovies();
}
