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

    @Autowired
    private  MovieDirectorRepository movieDirectorRepository;

    @Test
    public void findAllByRatingGreaterThanEqual_shouldReturnMovieWithRatingGreaterThanOrEqualTo3() {

        List<Movie> moviesAbove3Rating = IterableUtils.toList(movieRepository.findAllByRatingGreaterThanEqual(3));

        assertThat(moviesAbove3Rating).isNotEmpty();
        moviesAbove3Rating.forEach((elem) -> {
            assertThat(elem.getRating()).isGreaterThanOrEqualTo(3);
        });
    }

    @Test
    public void findAllByRatingGreaterThanEqual_shouldReturnNoMovies() {

        List<Movie> moviesAbove4Rating = IterableUtils.toList(movieRepository.findAllByRatingGreaterThanEqual(5));

        assertThat(moviesAbove4Rating).isEmpty();
    }

    @Test
    public void findAllByMovieDirectorId_shouldReturnANotEmptyListOfMovies() {
        Long id = IterableUtils.toList(movieDirectorRepository.findAll()).get(0).getId();

        List<Movie> movies = IterableUtils.toList(movieRepository.findAllByMovieDirectorId(id));

        assertThat(movies).isNotEmpty();
    }

    @BeforeEach
    public void emptyDB() {
        movieRepository.deleteAll();
        movieDirectorRepository.deleteAll();

        MovieDirector movieDirector = new MovieDirector();
        movieDirector.setSurname("Test Surname");
        movieDirector.setName("Test Name");
        movieDirector.setMiddleName("Test MiddleName");

        Movie movie = new Movie();
        movie.setTitle("Test title 1");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(1);
        movieRepository.save(movie);

        movie = new Movie();
        movie.setTitle("Test title 2");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(2);
        movieRepository.save(movie);

        movie = new Movie();
        movie.setTitle("Test title 3");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(3);
        movieRepository.save(movie);

        movie = new Movie();
        movie.setTitle("Test title 4");
        movie.setMovieDirector(movieDirector);
        movie.setDuration(300L);
        movie.setOverview("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        movie.setRating(4);
        movieRepository.save(movie);
    }
}
