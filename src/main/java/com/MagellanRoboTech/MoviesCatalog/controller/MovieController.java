package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.core.ResponseDTO;
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
    ResponseEntity<ResponseDTO<Movie>> addMovie(Movie movie);

    /**
     *
     * @param movie
     * @return
     */
    ResponseEntity<ResponseDTO<Movie>> updateMovie(Movie movie);

    /**
     *
     * @param movieId
     * @return
     */
    ResponseEntity<ResponseDTO<Void>> deleteMovie(Long movieId);
}
