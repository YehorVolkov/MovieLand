package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.yehor.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JdbcMovieDao implements MovieDao {

    private static final String FIND_ALL_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie";
    private static final String GET_THREE_RANDOM_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie ORDER BY RAND() LIMIT 3";
    private static final String GET_MOVIES_MY_GENRE = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie INNER JOIN movie_genre ON movie_genre.movie_id = movie.id WHERE movie_genre.genre_id = ?";

    private final JdbcTemplate jdbcTemplate;
    private final MovieRowMapper movieRowMapper;

    @Override
    public Iterable<Movie> findAll() {
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY, movieRowMapper);
    }

    @Override
    public Iterable<Movie> findAllSortByRating() {
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY + " ORDER BY rating desc", movieRowMapper);
    }

    @Override
    public Iterable<Movie> findAllSortByPrice(String priceSortingOrder) {
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY + " ORDER BY price " + priceSortingOrder, movieRowMapper);
    }

    @Override
    public Iterable<Movie> getThreeRandomMovies() {
        return jdbcTemplate.query(GET_THREE_RANDOM_MOVIES_QUERY, movieRowMapper);
    }

    @Override
    public Iterable<Movie> getMoviesByGenre(int genreId) {
        return jdbcTemplate.query(GET_MOVIES_MY_GENRE, movieRowMapper, genreId);
    }

    @Override
    public Iterable<Movie> getMoviesByGenreSortByRating(int genreId) {
        return jdbcTemplate.query(GET_MOVIES_MY_GENRE + " ORDER BY rating desc", movieRowMapper, genreId);
    }

    @Override
    public Iterable<Movie> getMoviesByGenreSortByPrice(int genreId, String priceSortingOrder) {
        return jdbcTemplate.query(GET_MOVIES_MY_GENRE + " ORDER BY rating " + priceSortingOrder, movieRowMapper, genreId);
    }
}
