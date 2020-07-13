package com.MagellanRoboTech.MoviesCatalog.controller;

import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import org.springframework.http.ResponseEntity;

public interface MovieDirectorController {

    /**
     *
     * @return
     */
    ResponseEntity<ResponseDTO<Iterable<MovieDirector>>> getAllMovieDirectors();

    /**
     *
     * @param movieDirectorId
     * @return
     */
    ResponseEntity<ResponseDTO<MovieDirector>> getMovieDirector(Long movieDirectorId);

    /**
     *
     * @param movieDirector
     * @return
     */
    ResponseEntity<ResponseDTO<MovieDirector>> addMovieDirector(RequestPostMovieDirectorDTO movieDirector);

    /**
     *
     * @param movieDirector
     * @return
     */
    ResponseEntity<ResponseDTO<MovieDirector>> updateMovieDirector(RequestPutMovieDirectorDTO movieDirector);

    /**
     *
     * @param movieDirectorId
     * @return
     */
    ResponseEntity<ResponseDTO<Void>> deleteMovieDirector(Long movieDirectorId);
}
