package com.yehor.movieland.service;

import com.yehor.movieland.entity.Movie;

public interface MovieService {
    Iterable<Movie> findAll();
    Iterable<Movie> findAllSortByRating(String ratingSortingOrder);
    Iterable<Movie> findAllSortByPrice(String priceSortingOrder);
    Iterable<Movie> getThreeRandomMovies();
    Iterable<Movie> getMoviesByGenre(int genreId);
    Iterable<Movie> getMoviesByGenreSortByRating(int genreId, String ratingSortingOrder);
    Iterable<Movie> getMoviesByGenreSortByPrice(int genreId, String priceSortingOrder);
}
