package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    // TODO SHOULD WE VALIDATE PARAMETERS IN THIS LAYER?
    /// TODO IF WE GET RID OF VALIDATION IN THIS LAYER - WE CAN REUSE SOME METHODS!

    private final MovieDao movieDao;

    @Override
    public Iterable<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Iterable<Movie> findAllSortByRating(String ratingSortingOrder) {
        if (ratingSortingOrder == null || !ratingSortingOrder.equals("desc")) {
            // todo do something, maybe will need to invert condition
            return null;
        }
        return movieDao.findAllSortByRating();
    }

    @Override
    public Iterable<Movie> findAllSortByPrice(String priceSortingOrder) {
        if (priceSortingOrder == null ||
                (!priceSortingOrder.equals("desc") && !priceSortingOrder.equals("asc"))) {
            // todo do something, maybe will need to invert condition
            return null;
        }
        return movieDao.findAllSortByPrice(priceSortingOrder);
    }

    @Override
    public Iterable<Movie> getThreeRandomMovies() {
        return movieDao.getThreeRandomMovies();
    }

    @Override
    public Iterable<Movie> getMoviesByGenre(int genreId) {
        return movieDao.getMoviesByGenre(genreId);
    }

    @Override
    public Iterable<Movie> getMoviesByGenreSortByRating(int genreId, String ratingSortingOrder) {
        if (ratingSortingOrder == null || !ratingSortingOrder.equals("desc")) {
            // todo do something, maybe will need to invert condition
            return null;
        }
        return movieDao.getMoviesByGenreSortByRating(genreId);
    }

    @Override
    public Iterable<Movie> getMoviesByGenreSortByPrice(int genreId, String priceSortingOrder) {
        if (priceSortingOrder == null ||
                (!priceSortingOrder.equals("desc") && !priceSortingOrder.equals("asc"))) {
            // todo do something, maybe will need to invert condition
            return null;
        }
        return movieDao.getMoviesByGenreSortByPrice(genreId, priceSortingOrder);
    }
}
