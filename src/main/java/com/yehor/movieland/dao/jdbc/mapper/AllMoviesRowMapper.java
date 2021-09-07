package com.yehor.movieland.dao.jdbc.mapper;

import com.yehor.movieland.entity.Movie;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AllMoviesRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(ResultSet resultSet, int i) throws SQLException {
        return Movie.builder()
            .id(resultSet.getInt("id"))
            .nameRussian(resultSet.getString("name_russian"))
            .nameNative(resultSet.getString("name_native"))
            .yearOfRelease(resultSet.getDate("year_of_release").toLocalDate())
            .rating(resultSet.getDouble("rating"))
            .price(resultSet.getDouble("price"))
            .picturePath(resultSet.getString("picture_path"))
            .build();
    }
}
