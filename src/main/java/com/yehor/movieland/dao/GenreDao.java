package com.yehor.movieland.dao;

import com.yehor.movieland.entity.Genre;

public interface GenreDao {
    Iterable<Genre> findAll();
}
