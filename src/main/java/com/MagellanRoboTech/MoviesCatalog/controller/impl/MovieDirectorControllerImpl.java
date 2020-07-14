package com.MagellanRoboTech.MoviesCatalog.controller.impl;

import com.MagellanRoboTech.MoviesCatalog.controller.MovieDirectorController;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPostMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.RequestPutMovieDirectorDTO;
import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import com.MagellanRoboTech.MoviesCatalog.service.MovieDirectorService;
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
@RequestMapping("/movies/directors")
public class MovieDirectorControllerImpl implements MovieDirectorController {

    private final MovieDirectorService movieDirectorService;

    @Autowired
    public MovieDirectorControllerImpl(MovieDirectorService movieDirectorService) {
        this.movieDirectorService = movieDirectorService;
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<ResponseDTO<Iterable<MovieDirector>>> getAllMovieDirectors() {
        log.trace("GET /movies/directors/all");

        ResponseDTO<Iterable<MovieDirector>> response = ResponseDTO.<Iterable<MovieDirector>>builder()
                .body(movieDirectorService.getAllMovieDirectors())
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @GetMapping
    public ResponseEntity<ResponseDTO<MovieDirector>> getMovieDirector(@PathParam("movieDirectorId") Long movieDirectorId) {
        log.trace("GET /movies/directors?movieDirectorId={}", movieDirectorId);

        ResponseDTO<MovieDirector> response = ResponseDTO.<MovieDirector>builder()
                .body(movieDirectorService.getMovieDirector(movieDirectorId))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @PostMapping
    public ResponseEntity<ResponseDTO<MovieDirector>> addMovieDirector(@RequestBody @Valid RequestPostMovieDirectorDTO movieDirector) {
        log.trace("POST /movies/directors {}", movieDirector.toString());

        ResponseDTO<MovieDirector> response = ResponseDTO.<MovieDirector>builder()
                .status(HttpStatus.CREATED)
                .body(movieDirectorService.saveMovieDirector(new ModelMapper().map(movieDirector, MovieDirector.class)))
                .build();

        return new ResponseEntity<>(response, response.getStatus());
    }

    @Override
    @PutMapping
    public ResponseEntity<ResponseDTO<MovieDirector>> updateMovieDirector(@RequestBody @Valid RequestPutMovieDirectorDTO movieDirector) {
        log.trace("PUT /movies/directors {}", movieDirector.toString());

        ResponseDTO<MovieDirector> response = ResponseDTO.<MovieDirector>builder()
                .body(movieDirectorService.updateMovieDirector(new ModelMapper().map(movieDirector, MovieDirector.class)))
                .build();

        return ResponseEntity.ok(response);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<ResponseDTO<Void>> deleteMovieDirector(@PathParam("movieDirectorId") Long movieDirectorId) {
        log.trace("DELETE /movies/directors?movieDirectorId={}", movieDirectorId);

        movieDirectorService.removeMovieDirector(movieDirectorId);
        ResponseDTO<Void> response = ResponseDTO.<Void>builder().build();

        return ResponseEntity.ok(response);
    }
}
