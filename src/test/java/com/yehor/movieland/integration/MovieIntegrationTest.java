package com.yehor.movieland.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations={"classpath:/spring/root-context.xml"})
@WebAppConfiguration
public class MovieIntegrationTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testRequestReturnsNonEmptyJson() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    public void testGetThreeRandomMoviesReturnsThreeItems() throws Exception {
        mockMvc.perform(get("/movie/random"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(new MediaType(
                        MediaType.APPLICATION_JSON.getType(),
                        MediaType.APPLICATION_JSON.getSubtype()
                )))
                .andExpect(jsonPath("$", hasSize(3)));
    }

/*    @Test
    public void givenWac_whenServletContext_thenItProvidesGreetController() {
        ServletContext servletContext = webApplicationContext.getServletContext();

        assertNotNull(servletContext);
        assertTrue(servletContext instanceof MockServletContext);
        assertNotNull(webApplicationContext.getBean(MovieController.class));
    }*/
}
