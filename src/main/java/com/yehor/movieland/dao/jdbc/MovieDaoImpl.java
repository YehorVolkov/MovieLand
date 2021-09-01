package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.yehor.movieland.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Movie> getAllMovies() {
        String sql = "Select * from movie";
        List<Movie> movieList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[]{}, new MovieRowMapper());
        for (Map row: rows) {
            Movie movie = new Movie();
        }
        return null;
    }
}
