package com.yehor.movieland.dao;

import com.yehor.movieland.entity.Movie;

public interface MovieDao {
    Iterable<Movie> findAll();
    Iterable<Movie> findAllSortByRating();
    Iterable<Movie> findAllSortByPrice(String priceSortingOrder);
    Iterable<Movie> getThreeRandomMovies();
    Iterable<Movie> getMoviesByGenre(int genreId);
    Iterable<Movie> getMoviesByGenreSortByRating(int genreId);
    Iterable<Movie> getMoviesByGenreSortByPrice(int genreId, String priceSortingOrder);
}
