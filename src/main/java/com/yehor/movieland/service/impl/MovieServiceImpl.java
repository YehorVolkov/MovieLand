package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import com.yehor.movieland.util.MovieRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Override
    public Iterable<Movie> findAll(MovieRequest movieRequest) {
        return movieDao.findAll(movieRequest);
    }

    @Override
    public Iterable<Movie> findThreeRandomMovies() {
        return movieDao.findThreeRandomMovies();
    }
}
