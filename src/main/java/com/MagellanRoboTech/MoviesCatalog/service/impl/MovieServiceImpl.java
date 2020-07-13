package com.MagellanRoboTech.MoviesCatalog.service.impl;

import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieFoundException;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import com.MagellanRoboTech.MoviesCatalog.repository.MovieRepository;
import com.MagellanRoboTech.MoviesCatalog.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(Long movieId) throws NoMovieFoundException {
        Optional<Movie> movieFound = movieRepository.findById(movieId);
        if (!movieFound.isPresent()) {
            log.error("No Movie with id {} found", movieId);
            throw new NoMovieFoundException();
        }

        return movieFound.get();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) throws NoMovieFoundException {
        if (!movieRepository.existsById(movie.getId())) {
            log.error("No Movie with id {} found", movie.getId());
            throw new NoMovieFoundException();
        }

        return movieRepository.save(movie);
    }

    @Override
    public void removeMovie(Long id) throws NoMovieFoundException {
        if (!movieRepository.existsById(id)) {
            log.error("No Movie with id {} found", id);
            throw new NoMovieFoundException();
        }

        movieRepository.deleteById(id);
    }
}
