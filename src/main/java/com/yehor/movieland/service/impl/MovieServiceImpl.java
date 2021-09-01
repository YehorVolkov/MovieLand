package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDao movieDao;

    @Override
    public List<Movie> getAllMoviesJson() {
        return movieDao.getAllMovies();
    }
}
