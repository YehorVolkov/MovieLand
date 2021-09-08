package com.yehor.movieland.web.controller;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public Iterable<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping(params = {"rating"})
    public Iterable<Movie> findAllSortByRating(@RequestParam(name = "rating") String ratingSortingOrder) {
        return movieService.findAllSortByRating(ratingSortingOrder);
    }

    @GetMapping(params = {"price"})
    public Iterable<Movie> findAllSortByPrice(@RequestParam(name = "price") String priceSortingOrder) {
        return movieService.findAllSortByPrice(priceSortingOrder);
    }

    @GetMapping("random")
    public Iterable<Movie> getThreeRandomMovies() {
        return movieService.getThreeRandomMovies();
    }

    @GetMapping("genre/{genreId}")
    public Iterable<Movie> getMoviesByGenre(@PathVariable int genreId) {
        return movieService.getMoviesByGenre(genreId);
    }

    @GetMapping(value = "genre/{genreId}", params = {"rating"})
    public Iterable<Movie> getMoviesByGenreSortByRating(@PathVariable int genreId, @RequestParam(name = "rating") String ratingSortingOrder) {
        return movieService.getMoviesByGenreSortByRating(genreId, ratingSortingOrder);
    }

    @GetMapping(value = "genre/{genreId}", params = {"price"})
    public Iterable<Movie> getMoviesByGenreSortByPrice(@PathVariable int genreId, @RequestParam(name = "price") String priceSortingOrder) {
        return movieService.getMoviesByGenreSortByPrice(genreId, priceSortingOrder);
    }
}
