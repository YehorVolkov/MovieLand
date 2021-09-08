package com.yehor.movieland.web.controller;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public Iterable<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("random")
    public Iterable<Movie> getThreeRandomMoviesJson() {
        return movieService.getThreeRandomMoviesJson();
    }
}
