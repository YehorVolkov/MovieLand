package com.yehor.movieland.web.controller;

import com.yehor.movieland.entity.Genre;
import com.yehor.movieland.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("genre")
@AllArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public Iterable<Genre> findAll() {
        return genreService.findAll();
    }

}
