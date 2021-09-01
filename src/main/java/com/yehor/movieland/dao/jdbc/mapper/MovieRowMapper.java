package com.yehor.movieland.dao.jdbc.mapper;

import com.yehor.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// TODO maybe we can do better than this mapper?
public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        Movie movie = new Movie();
        movie.setId(resultSet.getInt("id"));
        movie.setName_russian(resultSet.getString("name_russian"));
        movie.setName_native(resultSet.getString("name_native"));
        movie.setYear_of_release(resultSet.getDate("year_of_release"));
        movie.setDescription(resultSet.getString("description"));
        movie.setRating(resultSet.getInt("rating"));
        movie.setPrice(resultSet.getInt("price"));
        movie.setPicture_path(resultSet.getString("picture_path"));
        movie.setVotes(resultSet.getInt("votes"));
        return movie;
    }
}
