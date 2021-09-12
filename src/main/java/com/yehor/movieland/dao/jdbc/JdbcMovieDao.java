package com.yehor.movieland.dao.jdbc;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.dao.jdbc.mapper.MovieRowMapper;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.util.MovieRequest;
import com.yehor.movieland.util.SortingDirection;
import com.yehor.movieland.util.SortingField;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class JdbcMovieDao implements MovieDao {

    private static final String FIND_ALL_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie";
    private static final String FIND_THREE_RANDOM_MOVIES_QUERY = "SELECT id, name_russian, name_native, year_of_release, rating, price, picture_path FROM movie ORDER BY RAND() LIMIT 3";
    private static final String FIND_BY_GENRE_ADDON = " INNER JOIN movie_genre ON movie_genre.movie_id = movie.id WHERE movie_genre.genre_id = ?";

    private final JdbcTemplate jdbcTemplate;
    private final MovieRowMapper movieRowMapper;

    @Override
    @SneakyThrows
    public Iterable<Movie> findAll(MovieRequest movieRequest) {
        // todo Do we need this check? We can do it in different layer but other layers might change one day
        if (movieRequest == null) {
            throw new SQLException("Wrong state, can't execute query.");
        }

        String currentQuery = FIND_ALL_MOVIES_QUERY;

        Optional<Integer> genreId = Optional.ofNullable(movieRequest.getGenreId());
        if (genreId.isPresent()) {
            currentQuery += FIND_BY_GENRE_ADDON;
            return jdbcTemplate.query(addSortingIfRequired(movieRequest), movieRowMapper, genreId);
        }
        return jdbcTemplate.query(addSortingIfRequired(movieRequest), movieRowMapper);
    }

    @Override
    public Iterable<Movie> findThreeRandomMovies() {
        return jdbcTemplate.query(FIND_THREE_RANDOM_MOVIES_QUERY, movieRowMapper);
    }

    private String addSortingIfRequired(MovieRequest movieRequest) {
        Optional<SortingField> sortingField = Optional.ofNullable(movieRequest.getSortingField());
        if (sortingField.isPresent()) {
            Optional<SortingDirection> sortingDirection = Optional.ofNullable(movieRequest.getSortingDirection());
            if (sortingDirection.isPresent()) {
                return " ORDER BY " + sortingField.get() + " " + sortingDirection.get();
            }
        }
        return "";
    }
}
