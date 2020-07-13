package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestGetMovieDTO;
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
    ResponseEntity<ResponseDTO<Movie>> addMovie(RequestGetMovieDTO movie) throws Exception;

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
}
