package com.yehor.movieland.dao;

import com.yehor.movieland.entity.Movie;

public interface MovieDao {
    Iterable<Movie> findAll();
    Iterable<Movie> findAllWithSorting(String sortingField, String sortingDirection);
    Iterable<Movie> findThreeRandomMovies();
    Iterable<Movie> findMoviesByGenre(int genreId);
    Iterable<Movie> findMoviesByGenreWithSorting(int genreId, String sortingField, String sortingDirection);
}
