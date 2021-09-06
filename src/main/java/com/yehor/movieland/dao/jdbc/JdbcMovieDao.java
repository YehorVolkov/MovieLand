package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.dao.jdbc.mapper.AllMoviesRowMapper;
import com.yehor.movieland.entity.Movie;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JdbcMovieDao implements MovieDao {

    private static final String FIND_ALL_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie";
    private static final String GET_THREE_RANDOM_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie ORDER BY RAND() LIMIT 3";

    private final JdbcTemplate jdbcTemplate;
    private final AllMoviesRowMapper allMoviesRowMapper;

    @Override
    public Iterable<Movie> findAll() {
        return jdbcTemplate.query(FIND_ALL_MOVIES_QUERY, allMoviesRowMapper);
    }

    @Override
    public Iterable<Movie> getThreeRandomMovies() {
        return jdbcTemplate.query(GET_THREE_RANDOM_MOVIES_QUERY, allMoviesRowMapper);
    }
}
