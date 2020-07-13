package com.MagellanRoboTech.MoviesCatalog.controller.impl;

import com.MagellanRoboTech.MoviesCatalog.controller.MovieController;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestGetMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import com.MagellanRoboTech.MoviesCatalog.service.MovieService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@Slf4j
@RestController
@RequestMapping("/movies")
public class MovieControllerImpl implements MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieControllerImpl(MovieService movieService) {
        this.movieService = movieService;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<Iterable<Movie>>> getAllMovies() {
        log.trace("GET /movies/all");

        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.getAllMovies())
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDTO<Movie>> getMovie(@PathParam("movieId") Long movieId) {
        log.trace("GET /movies?movieId={}", movieId);

        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.getMovie(movieId))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseDTO<Movie>> addMovie(@RequestBody @Valid RequestGetMovieDTO movie) {
        log.trace("POST /movies {}", movie.toString());

        ResponseDTO response = ResponseDTO.builder()
                .status(HttpStatus.CREATED)
                .body(movieService.saveMovie(new ModelMapper().map(movie, Movie.class)))
                .build();

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDTO<Movie>> updateMovie(@RequestBody @Valid RequestPutMovieDTO movie) {
        log.trace("PUT /movies {}", movie.toString());

        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.updateMovie(new ModelMapper().map(movie, Movie.class)))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDTO<Void>> deleteMovie(@PathParam("movieId") Long movieId) {
        log.trace("DELETE /movies?movieId={}", movieId);

        movieService.removeMovie(movieId);
        ResponseDTO response = ResponseDTO.builder().build();

        return ResponseEntity.ok(response);
    }
}
