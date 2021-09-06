package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Override
    public Iterable<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Iterable<Movie> getThreeRandomMoviesJson() {
        return movieDao.getThreeRandomMovies();
    }
}
