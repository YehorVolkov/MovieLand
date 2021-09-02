package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.yehor.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieDaoImpl implements MovieDao {

    private static final String GET_ALL_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie";
    private static final String GET_THREE_RANDOM_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie ORDER BY RAND() LIMIT 3";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MovieRowMapper movieRowMapper;

    @Override
    public List<Movie> getAllMovies() {
        return jdbcTemplate.query(GET_ALL_MOVIES_QUERY, movieRowMapper);
    }

    @Override
    public List<Movie> getThreeRandomMovies() {
        return jdbcTemplate.query(GET_THREE_RANDOM_MOVIES_QUERY, movieRowMapper);
    }
}
