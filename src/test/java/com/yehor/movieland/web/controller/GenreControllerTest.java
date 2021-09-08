package com.yehor.movieland.web.controller;

import com.yehor.movieland.dao.GenreDao;
import com.yehor.movieland.entity.Genre;
import com.yehor.movieland.service.impl.GenreServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.hasSize;

public class GenreControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private GenreServiceImpl genreServiceMock;

    @Mock
    private GenreDao genreDaoMock;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new GenreController(genreServiceMock)).build();
    }

    @Test
    public void testGenreControllerFindAll() throws Exception {
        Genre genre1 = Genre.builder()
                .id(11)
                .name("приключение")
                .build();

        Genre genre2 = Genre.builder()
                .id(12)
                .name("аниме")
                .build();

        when(genreServiceMock.findAll()).thenReturn(List.of(genre1, genre2));

        mockMvc.perform(get("/genre"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(11)))
                .andExpect(jsonPath("$[0].name", is("приключение")))

                .andExpect(jsonPath("$[1].id", is(12)))
                .andExpect(jsonPath("$[1].name", is("аниме")));
    }
}
