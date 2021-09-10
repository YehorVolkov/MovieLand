package com.yehor.movieland.web.controller;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import com.yehor.movieland.util.MovieRequest;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/")
    public Iterable<Movie> findAll() {
        return movieService.findAll(new MovieRequest());
    }

    @GetMapping(params = {"rating"})
    public Iterable<Movie> findAllSortByRating(@RequestParam(name = "rating") String sortingDirection) {
        // todo sortingDirection nullcheck moved to MovieRequest. Is it ok???
        return movieService.findAll(new MovieRequest("rating", sortingDirection));
    }

    @GetMapping(params = {"price"})
    public Iterable<Movie> findAllSortByPrice(@RequestParam(name = "price") String sortingDirection) {
        return movieService.findAll(new MovieRequest("price", sortingDirection));
    }

    @GetMapping("random")
    public Iterable<Movie> findThreeRandomMovies() {
        return movieService.findThreeRandomMovies();
    }

    @GetMapping("genre/{genreId}")
    public Iterable<Movie> findMoviesByGenre(@PathVariable int genreId) {
        return movieService.findMoviesByGenre(genreId, new MovieRequest());
    }

    @GetMapping(value = "genre/{genreId}", params = {"rating"})
    // todo what's wrong with genreId being int? we get bad request if we don't pass integer
    public Iterable<Movie> findMoviesByGenreSortByRating(@PathVariable int genreId, @RequestParam(name = "rating") String sortingDirection) {
        return movieService.findMoviesByGenre(genreId, new MovieRequest("rating", sortingDirection));
    }

    @GetMapping(value = "genre/{genreId}", params = {"price"})
    public Iterable<Movie> findMoviesByGenreSortByPrice(@PathVariable int genreId, @RequestParam(name = "price") String sortingDirection) {
        return movieService.findMoviesByGenre(genreId, new MovieRequest("price", sortingDirection));
    }
}
