package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.GenreDao;
import com.yehor.movieland.dao.jdbc.mapper.AllGenresRowMapper;
import com.yehor.movieland.entity.Genre;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JdbcGenreDao implements GenreDao {

    private static final String FIND_ALL_GENRES_QUERY = "SELECT id, name FROM genre";

    private final JdbcTemplate jdbcTemplate;
    private final AllGenresRowMapper allGenresRowMapper;

    @Override
    public Iterable<Genre> findAll() {
        return jdbcTemplate.query(FIND_ALL_GENRES_QUERY, allGenresRowMapper);
    }
}
