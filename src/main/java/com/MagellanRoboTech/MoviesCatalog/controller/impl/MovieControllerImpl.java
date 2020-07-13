package com.MagellanRoboTech.MoviesCatalog.controller.impl;

import com.MagellanRoboTech.MoviesCatalog.controller.MovieController;
import com.MagellanRoboTech.MoviesCatalog.core.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import com.MagellanRoboTech.MoviesCatalog.service.MovieService;
import lombok.extern.slf4j.Slf4j;
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
        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.getAllMovies())
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDTO<Movie>> getMovie(@PathParam("movieId") Long movieId) {
        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.getMovie(movieId))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseDTO<Movie>> addMovie(Movie movie) {
        log.error("POST movie");
        ResponseDTO response = ResponseDTO.builder()
                .status(HttpStatus.CREATED)
                .body(movieService.saveMovie(movie))
                .build();

        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDTO<Movie>> updateMovie(Movie movie) {
        log.error("PUT movie");
        ResponseDTO response = ResponseDTO.builder()
                .body(movieService.updateMovie(movie))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDTO<Void>> deleteMovie(@PathParam("movieId") Long movieId) {
        log.error("DEL movie");
        movieService.removeMovie(movieId);
        ResponseDTO response = ResponseDTO.builder().build();

        return ResponseEntity.ok(response);
    }
}
