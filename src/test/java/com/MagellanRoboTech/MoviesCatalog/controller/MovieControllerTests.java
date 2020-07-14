package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.exception.MovieRatingOutOfBoundsException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieDirectedFoundException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieDirectorFoundException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieFoundException;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import com.MagellanRoboTech.MoviesCatalog.service.MovieDirectorService;
import com.MagellanRoboTech.MoviesCatalog.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @MockBean
    private MovieDirectorService movieDirectorService;

    @Test
    public void getMoviesAboveGivenRating_givenAnInvalidRating_shouldReturnBadResponse() throws Exception {
        given(movieService.searchMoviesAboveGivenRating(100)).willThrow(new MovieRatingOutOfBoundsException());

        mockMvc.perform(get("/movies/searchByRating?aboveRating=100"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getMoviesAboveGivenRating_givenARatingOfANotPresentMovie_shouldReturnNotFoundResponse() throws Exception {
        given(movieService.searchMoviesAboveGivenRating(5)).willThrow(new NoMovieFoundException());

        mockMvc.perform(get("/movies/searchByRating?aboveRating=5"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getMoviesAboveGivenRating_givenARatingOfAPresentMovie_shouldReturnAMovieList() throws Exception {
        given(movieService.searchMoviesAboveGivenRating(1))
            .willReturn(Collections.singletonList(getSimpleMovie()));

        mockMvc.perform(get("/movies/searchByRating?aboveRating=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].title").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].overview").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].duration").value(300L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].rating").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getMoviesByMovieDirector_givenAValidMovieDirectorThatHasNotDirectedAMovieYet_shouldReturnANotFoundResponse() throws Exception {
        given(movieService.searchMoviesByMovieDirector(1L))
                .willThrow(new NoMovieDirectedFoundException());

        mockMvc.perform(get("/movies/searchByMovieDirector?movieDirectorId=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getMoviesByMovieDirector_givenANotValidMovieDirector_shouldReturnANotFoundResponse() throws Exception {
        given(movieService.searchMoviesByMovieDirector(1L))
                .willThrow(new NoMovieDirectorFoundException());

        mockMvc.perform(get("/movies/searchByMovieDirector?movieDirectorId=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getMoviesByMovieDirector_givenAnValidMovieDirectorThatHasDirectedAMovie_shouldReturnAMovieList() throws Exception {
        given(movieService.searchMoviesByMovieDirector(1L))
                .willReturn(Collections.singletonList(getSimpleMovie()));

        mockMvc.perform(get("/movies/searchByMovieDirector?movieDirectorId=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].title").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].overview").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].duration").value(300L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].rating").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getAllMovies_shouldReturnEmptyList() throws Exception {
        given(movieService.getAllMovies()).willReturn(Collections.EMPTY_LIST);

        mockMvc.perform(get("/movies/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getAllMovies_shouldReturnAListWithAMovie() throws Exception {
        given(movieService.getAllMovies()).willReturn(Collections.singletonList(getSimpleMovie()));

        mockMvc.perform(get("/movies/all"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isArray())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].title").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].overview").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].duration").value(300L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body[0].rating").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getMovie_shouldReturnAMovie() throws Exception {
        given(movieService.getMovie(1L))
                .willReturn(getSimpleMovie());

        mockMvc.perform(get("/movies?movieId=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.title").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.overview").value("Test"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.duration").value(300L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.rating").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Success"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("OK"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getMovie_shouldReturn404StatusCode() throws Exception {

        given(movieService.getMovie(1L)).willThrow(new NoMovieFoundException());

        mockMvc.perform(get("/movies?movieId=1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No movie found"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("NOT_FOUND"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isNotFound());
    }

    @Test
    public void saveMovie_givenWellFormattedInput_shouldReturnMovieSaved() throws Exception {
        given(movieService.saveMovie(any(Movie.class))).willReturn(getSimpleMovie());
        RequestPostMovieDTO request = new RequestPostMovieDTO();
        request.setTitle("Test");
        request.setDuration(300L);
        request.setMovieDirectorId(1L);
        request.setRating(3);
        request.setOverview("Test");

        mockMvc.perform(post("/movies")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("CREATED"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body.id").value(1L))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void saveMovie_shouldReturnBadRequest() throws Exception {
        given(movieService.saveMovie(any())).willThrow(new NoMovieDirectorFoundException());

        mockMvc.perform(post("/movies")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(new RequestPostMovieDTO())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isString())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("BAD_REQUEST"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.body").isEmpty())
                .andExpect(status().isBadRequest());
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Movie getSimpleMovie() {
        return new Movie(1L, "Test", "Test", 300L, 3,
                new MovieDirector(1L, "Test", "Test", "Test"));
    }
}
