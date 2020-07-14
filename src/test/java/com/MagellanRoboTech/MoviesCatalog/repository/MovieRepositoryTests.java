package com.MagellanRoboTech.MoviesCatalog.repository;

import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import org.apache.commons.collections4.IterableUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTests {

    @Autowired
    private MovieRepository movieRepository;

    @BeforeEach
    public void emptyDB() {
        movieRepository.deleteAll();

        MovieDirector movieDirector = new MovieDirector();
        movieDirector.setSurname("Test Surname");
        movieDirector.setName("Test Name");
        movieDirector.setMiddleName("Test MiddleName");
        Movie movie = new Movie();
        movie.setTitle("Test title 1");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(3);
        movieRepository.save(movie);
        movie = new Movie();
        movie.setTitle("Test title 2");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(4);
        movieRepository.save(movie);
    }

    @Test
    public void findAllByRatingGreaterThanEqual_whenSaveMoviesWithMoreThan2RatingSaved_ExpectedMovieSaved() {

        List<Movie> moviesAbove3Rating = IterableUtils.toList(movieRepository.findAllByRatingGreaterThanEqual(3));

        assertThat(moviesAbove3Rating).isNotEmpty();
        assertThat(moviesAbove3Rating.get(0).getTitle()).containsPattern("^Test title.+");
        assertThat(moviesAbove3Rating.get(1).getTitle()).containsPattern("^Test title.+");
    }

    @Test
    public void findAllByRatingGreaterThanEqual_whenMovieWithMoreThan2RatingSaved_ExpectedNoMovies() {

        List<Movie> moviesAbove3Rating = IterableUtils.toList(movieRepository.findAllByRatingGreaterThanEqual(5));

        assertThat(moviesAbove3Rating).isEmpty();
    }
}
