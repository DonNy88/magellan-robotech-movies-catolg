package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import org.springframework.http.ResponseEntity;

public interface MovieDirectorController {

    /**
     * GET /movies/directors/all
     * <p>
     *     Fetch all Movies Directors that they has been saved before.
     * </p>
     * @return A Dto Object with all Movies Directors retrieved from DB. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Iterable<MovieDirector>>> getAllMovieDirectors();

    /**
     * GET /movies/directors?movieDirectorId={}
     * <p>
     *     Fetch a Movie Director by movieDirectorId
     * </p>
     * @param movieDirectorId movie director id used for filter Movie Directors DB Table.
     * @return A Dto Object with the Movies Directors required. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<MovieDirector>> getMovieDirector(Long movieDirectorId);

    /**
     * POST /movies/directors
     * <p>
     *     Add a Movie Director.
     * </p>
     * @param movieDirector movie director to add.
     * @return A Dto Object with the Movie Director just saved. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<MovieDirector>> addMovieDirector(RequestPostMovieDirectorDTO movieDirector);

    /**
     * PUT /movies/directors
     * <p>
     *     Update movie director saved before.
     * </p>
     * @param movieDirector Movie Director to update.
     * @return A Dto Object with the Movie Director just updated. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<MovieDirector>> updateMovieDirector(RequestPutMovieDirectorDTO movieDirector);

    /**
     * PUT /movies/directors
     * <p>
     *     Update movie director saved before.
     * </p>
     * @param movieDirectorId
     * @return A Dto Object with the Movie Director just updated. Please @see {@link ResponseDTO}
     */
    ResponseEntity<ResponseDTO<Void>> deleteMovieDirector(Long movieDirectorId);
}
