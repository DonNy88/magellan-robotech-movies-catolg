package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import org.springframework.http.ResponseEntity;

public interface MovieController {

    /**
     * GET /movies/all
     * <p>
     *     Fetch all Movies that they has been saved before.
     * </p>
     * @return A Dto Object with a List of Movies. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getAllMovies();

    /**
     * GET /movies?movieId={}
     * <p>
     *     Fetch a Movie by movieId
     * </p>
     * @param movieId movie id of the Movie saved on DB
     * @return A Dto Object with the required Movie. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Movie>> getMovie(Long movieId);

    /**
     * POST /movies
     * <p>
     *     Add A Movie.
     * </p>
     * @param movie movie to save on the DB
     * @return A Dto Object with the Movie just saved. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Movie>> addMovie(RequestPostMovieDTO movie);

    /**
     * PUT /movies
     * <p>
     *     Update movie saved before.
     * </p>
     * @param movie movie to update
     * @return A Dto Object with the Movie just updated. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Movie>> updateMovie(RequestPutMovieDTO movie);

    /**
     * DELETE /movies?movieId={}
     * <p>
     *     Remove from DB the Movie by movie id.
     * </p>
     * @param movieId movie id of the Movie record to remove.
     * @return An empty Dto Object. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Void>> deleteMovie(Long movieId);

    /**
     * GET /movies/searchByRating?aboveRating={}
     * <p>
     *     Search movies where the rating is above a provided rating.
     * </p>
     * @param aboveRating rating provided for filter Movies
     * @return A Dto Object with the Movie found by the query. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getMoviesAboveGivenRating(Integer aboveRating);

    /**
     * GET /movies/searchByMovieDirector?movieDirectorId={}
     * <p>
     *     Search movies by Director.
     * </p>
     * @param movieDirectorId movie director id for filter Movies
     * @return @return A Dto Object with the Movie found by the query. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Iterable<Movie>>> getMoviesByMovieDirector(Long movieDirectorId);
}
