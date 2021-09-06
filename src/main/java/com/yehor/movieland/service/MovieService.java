package com.yehor.movieland.service;

import com.yehor.movieland.entity.Movie;

public interface MovieService {
    Iterable<Movie> findAll();
    Iterable<Movie> getThreeRandomMoviesJson();
}
