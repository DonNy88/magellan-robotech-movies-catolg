package com.MagellanRoboTech.MoviesCatalog.service;

import com.MagellanRoboTech.MoviesCatalog.exception.NoArgsProvidedException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieDirectorFoundException;
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
     * @throws NoMovieDirectorFoundException
     */
    Movie saveMovie(Movie movie) throws NoMovieDirectorFoundException;

    /**
     *
     * @param movie
     * @return
     * @throws NoArgsProvidedException
     * @throws NoMovieFoundException
     */
    Movie updateMovie(Movie movie) throws NoArgsProvidedException, NoMovieFoundException;

    /**
     *
     * @param id
     * @throws NoMovieFoundException
     */
    void removeMovie(Long id) throws NoMovieFoundException;
}
