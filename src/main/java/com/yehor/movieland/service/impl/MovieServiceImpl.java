package com.yehor.movieland.service.impl;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import com.yehor.movieland.util.MovieRequest;
import com.yehor.movieland.util.SortingDirection;
import com.yehor.movieland.util.SortingField;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieDao movieDao;

    @Override
    public Iterable<Movie> findAll(MovieRequest movieRequest) {
        SortingField currSortingField = movieRequest.getSortingField();
        SortingDirection currSortingDirection = movieRequest.getSortingDirection();
        if (currSortingField == SortingField.NONE) {
            return movieDao.findAll();
        } else {
            if (!(currSortingField == SortingField.RATING && currSortingDirection == SortingDirection.ASC)) {
                return movieDao.findAllWithSorting(currSortingField.toString(),
                        movieRequest.getSortingDirection().toString());
            }
        }
        return null; // TODO !
    }

    @Override
    public Iterable<Movie> findThreeRandomMovies() {
        return movieDao.findThreeRandomMovies();
    }

    @Override
    public Iterable<Movie> findMoviesByGenre(int genreId, MovieRequest movieRequest) {
        SortingField currSortingField = movieRequest.getSortingField();
        SortingDirection currSortingDirection = movieRequest.getSortingDirection();
        if (currSortingField == SortingField.NONE) {
            return movieDao.findMoviesByGenre(genreId);
        } else {
            if (!(currSortingField == SortingField.RATING && currSortingDirection == SortingDirection.ASC)) {
                return movieDao.findMoviesByGenreWithSorting(genreId,
                        currSortingField.toString(),
                        movieRequest.getSortingDirection().toString());
            }
        }
        return null; // TODO !
    }
}
