package com.MagellanRoboTech.MoviesCatalog.service;

import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieFoundException;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;

public interface MovieService {

    /**
     *
     * @return
     */
    Iterable<Movie> getAllMovies();

    /**
     *
     * @param movieId
     * @return
     * @throws NoMovieFoundException
     */
    Movie getMovie(Long movieId) throws NoMovieFoundException;

    /**
     *
     * @param movie
     * @return
     */
    Movie saveMovie(Movie movie);

    /**
     *
     * @param movie
     * @return
     * @throws NoMovieFoundException
     */
    Movie updateMovie(Movie movie) throws NoMovieFoundException;

    /**
     *
     * @param id
     * @throws NoMovieFoundException
     */
    void removeMovie(Long id) throws NoMovieFoundException;
}
