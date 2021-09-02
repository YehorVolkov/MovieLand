package com.yehor.movieland.service;

import com.yehor.movieland.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMoviesJson();
    List<Movie> getThreeRandomMoviesJson();
}
