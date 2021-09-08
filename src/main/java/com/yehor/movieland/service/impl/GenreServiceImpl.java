package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.GenreDao;
import com.yehor.movieland.entity.Genre;
import com.yehor.movieland.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreDao;

    @Override
    public Iterable<Genre> findAll() {
        return genreDao.findAll();
    }
}
