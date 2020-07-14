package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieController {

    /**
     *
     * @return
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getAllMovies();

    /**
     *
     * @param movieId
     * @return
     */
    ResponseEntity<ResponseDTO<Movie>> getMovie(Long movieId);

    /**
     *
     * @param movie
     * @return
     */
    ResponseEntity<ResponseDTO<Movie>> addMovie(RequestPostMovieDTO movie);

    /**
     *
     * @param movie
     * @return
     */
    ResponseEntity<ResponseDTO<Movie>> updateMovie(RequestPutMovieDTO movie);

    /**
     *
     * @param movieId
     * @return
     */
    ResponseEntity<ResponseDTO<Void>> deleteMovie(Long movieId);

    /**
     *
     * @param aboveRating
     * @return
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getMoviesAboveGivenRating(Integer aboveRating);

    /**
     *
     * @param movieDirectorId
     * @return
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getMoviesByMovieDirector(Long movieDirectorId);
}
