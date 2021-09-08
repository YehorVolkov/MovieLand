package com.yehor.movieland.dao.mapper;

import com.yehor.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.yehor.movieland.entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MovieRowMapperTest {

    @InjectMocks
    MovieRowMapper rowMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testMovieRowMapper() throws SQLException {
        int expectedId = 12;
        String expectedNameRussian = "Титаник";
        String expectedNameNative = "Titanic";
        LocalDate expectedYearOfRelease = LocalDate.of(1997, 1, 1);
        double expectedRating = 7.0;
        double expectedPrice = 150.0;
        String expectedPicturePath = "https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg";

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(expectedId);
        when(resultSet.getString("name_russian")).thenReturn(expectedNameRussian);
        when(resultSet.getString("name_native")).thenReturn(expectedNameNative);
        when(resultSet.getDate("year_of_release")).thenReturn(Date.valueOf(expectedYearOfRelease));
        when(resultSet.getDouble("rating")).thenReturn(expectedRating);
        when(resultSet.getDouble("price")).thenReturn(expectedPrice);
        when(resultSet.getString("picture_path")).thenReturn(expectedPicturePath);

        Movie movie = rowMapper.mapRow(resultSet, 0);
        assertEquals(movie.getId(), expectedId);
        assertEquals(movie.getNameRussian(), expectedNameRussian);
        assertEquals(movie.getNameNative(), expectedNameNative);
        assertEquals(movie.getYearOfRelease(), expectedYearOfRelease);
        assertEquals(movie.getRating(), expectedRating);
        assertEquals(movie.getPrice(), expectedPrice);
        assertEquals(movie.getPicturePath(), expectedPicturePath);
    }
}
