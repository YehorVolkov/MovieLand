package com.yehor.movieland.service;

import com.yehor.movieland.entity.Genre;

public interface GenreService {
    Iterable<Genre> findAll();
}
