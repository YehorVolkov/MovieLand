package com.yehor.movieland.web.controller;

import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.MovieService;
import com.yehor.movieland.util.MovieRequest;
import com.yehor.movieland.util.SortingDirection;
import com.yehor.movieland.util.SortingField;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("movie")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping(value = "", produces = "application/json")
    public Iterable<Movie> findAll(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
        MovieRequest movieRequest = createAndFillMovieRequest(allRequestParams);
        return movieService.findAll(movieRequest);
    }

    @GetMapping(value = "random", produces = "application/json")
    public Iterable<Movie> findThreeRandomMovies() {
        return movieService.findThreeRandomMovies();
    }

    @GetMapping(value = "genre/{genreId}", produces = "application/json")
    public Iterable<Movie> findMoviesByGenre(@PathVariable int genreId, @RequestParam Map<String,String> allRequestParams, ModelMap model) {
        // todo what's wrong with genreId being int? we get bad request if we don't pass integer
        MovieRequest movieRequest = createAndFillMovieRequest(allRequestParams);
        movieRequest.setGenreId(genreId);
        return movieService.findAll(movieRequest);
    }

    private MovieRequest createAndFillMovieRequest(Map<String,String> allRequestParams) {
        if (allRequestParams.size() > 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid number of parameters");
        }
        MovieRequest movieRequest = new MovieRequest();

        Set<Map.Entry<String, String>> requestParamsEntrySet = allRequestParams.entrySet();
        if (!requestParamsEntrySet.isEmpty()) {
            Map.Entry<String, String> sortingRequestParams = requestParamsEntrySet.iterator().next();

            String sortingField = sortingRequestParams.getKey();
            if (enumContains(SortingField.class, sortingField)) {
                movieRequest.setSortingField(sortingField);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid parameter name");
            }

            String sortingDirection = sortingRequestParams.getValue();
            if (enumContains(SortingDirection.class, sortingDirection)) {
                movieRequest.setSortingDirection(sortingDirection);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid parameter value");
            }

            if (movieRequest.getSortingField() == SortingField.RATING && movieRequest.getSortingDirection() == SortingDirection.ASC) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unacceptable parameter value");
            }
        }
        return movieRequest;
    }

    private <E extends Enum<E>> boolean enumContains(Class<E> currentEnum, String value) {
        if (value != null) {
            for (Enum<E> enumVal: currentEnum.getEnumConstants()) {
                if (enumVal.name().equals(value.toUpperCase())) {
                    return true;
                }
            }
        }
        return false;
    }
}
