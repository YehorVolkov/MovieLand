package com.yehor.movieland.dao.mapper;

import com.yehor.movieland.dao.jdbc.mapper.AllGenresRowMapper;
import com.yehor.movieland.entity.Genre;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AllGenresRowMapperTest {

    @InjectMocks
    AllGenresRowMapper rowMapper;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAllGenresRowMapper() throws SQLException {
        int expectedId = 11;
        String expectedName = "приключение";

        ResultSet resultSet = mock(ResultSet.class);

        when(resultSet.getInt("id")).thenReturn(expectedId);
        when(resultSet.getString("name")).thenReturn(expectedName);

        Genre genre = rowMapper.mapRow(resultSet, 0);
        assertEquals(genre.getId(), expectedId);
        assertEquals(genre.getName(), expectedName);
    }
}
