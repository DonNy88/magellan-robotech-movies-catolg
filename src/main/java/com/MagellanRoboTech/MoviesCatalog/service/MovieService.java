package com.MagellanRoboTech.MoviesCatalog.service;

import com.MagellanRoboTech.MoviesCatalog.exception.MovieRatingOutOfBoundsException;
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
     * @throws NoMovieDirectorFoundException
     */
    Movie updateMovie(Movie movie) throws NoArgsProvidedException, NoMovieFoundException, NoMovieDirectorFoundException;

    /**
     *
     * @param id
     * @throws NoMovieFoundException
     */
    void removeMovie(Long id) throws NoMovieFoundException;

    /**
     *
     * @param aboveRating
     * @return
     * @throws NoMovieFoundException
     * @throws MovieRatingOutOfBoundsException
     */
    Iterable<Movie> searchMoviesAboveGivenRating(Integer aboveRating) throws NoMovieFoundException, MovieRatingOutOfBoundsException;
}
