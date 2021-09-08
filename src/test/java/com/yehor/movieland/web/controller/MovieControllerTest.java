package com.yehor.movieland.web.controller;

import com.yehor.movieland.dao.MovieDao;
import com.yehor.movieland.entity.Movie;
import com.yehor.movieland.service.impl.MovieServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class MovieControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private MovieServiceImpl movieServiceMock;

    @Mock
    private MovieDao movieDaoMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MovieController(movieServiceMock)).build();
    }

    @Test
    public void testMovieControllerFindAll() throws Exception {
        Movie movie1 = Movie.builder()
                .id(12)
                .nameRussian("Титаник")
                .nameNative("Titanic")
                .yearOfRelease(LocalDate.of(1997, 1, 1))
                .rating(7.0)
                .price(150.0)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg")
                .build();

        Movie movie2 = Movie.builder()
                .id(3)
                .nameRussian("Форрест Гамп")
                .nameNative("Forrest Gump")
                .yearOfRelease(LocalDate.of(1994, 1, 1))
                .rating(8.6)
                .price(200.6)
                .picturePath("https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg")
                .build();

        when(movieServiceMock.findAll()).thenReturn(List.of(movie1, movie2));

        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(12)))
                .andExpect(jsonPath("$[0].nameRussian", is("Титаник")))
                .andExpect(jsonPath("$[0].nameNative", is("Titanic")))
                .andExpect(jsonPath("$[0].yearOfRelease.year", is(1997)))
                .andExpect(jsonPath("$[0].rating", is(7.0)))
                .andExpect(jsonPath("$[0].price", is(150.0)))
                .andExpect(jsonPath("$[0].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1._SY209_CR0,0,140,209_.jpg")))

                .andExpect(jsonPath("$[1].id", is(3)))
                .andExpect(jsonPath("$[1].nameRussian", is("Форрест Гамп")))
                .andExpect(jsonPath("$[1].nameNative", is("Forrest Gump")))
                .andExpect(jsonPath("$[1].yearOfRelease.year", is(1994)))
                .andExpect(jsonPath("$[1].rating", is(8.6)))
                .andExpect(jsonPath("$[1].price", is(200.6)))
                .andExpect(jsonPath("$[1].picturePath", is("https://images-na.ssl-images-amazon.com/images/M/MV5BNWIwODRlZTUtY2U3ZS00Yzg1LWJhNzYtMmZiYmEyNmU1NjMzXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1._SY209_CR2,0,140,209_.jpg")));
    }

    @Test
    public void testGetThreeRandomMovies() throws Exception {
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )));
    }

    @Test
    public void testGetMoviesByGenre() throws Exception {
        mockMvc.perform(get("/movie/genre/5"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )));
    }
}
