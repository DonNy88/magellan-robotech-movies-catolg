package com.MagellanRoboTech.MoviesCatalog.service.impl;

import com.MagellanRoboTech.MoviesCatalog.exception.NoArgsProvidedException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieDirectorFoundException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieFoundException;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import com.MagellanRoboTech.MoviesCatalog.repository.MovieDirectorRepository;
import com.MagellanRoboTech.MoviesCatalog.service.MovieDirectorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MovieDirectorServiceImpl implements MovieDirectorService {

    private final MovieDirectorRepository movieDirectorRepository;

    @Autowired
    public MovieDirectorServiceImpl(MovieDirectorRepository movieDirectorRepository) {
        this.movieDirectorRepository = movieDirectorRepository;
    }

    @Override
    public Iterable<MovieDirector> getAllMovieDirectors() {
        return movieDirectorRepository.findAll();
    }

    @Override
    public MovieDirector getMovieDirector(Long movieDirectorId) throws NoMovieDirectorFoundException {
        Optional<MovieDirector> movieDirectorFound = movieDirectorRepository.findById(movieDirectorId);
        if (!movieDirectorFound.isPresent()) {
            log.error("No Movie Director with id {} found", movieDirectorId);
            throw new NoMovieFoundException();
        }

        return movieDirectorFound.get();
    }

    @Override
    public MovieDirector saveMovieDirector(MovieDirector movieDirector) {
        return movieDirectorRepository.save(movieDirector);
    }

    @Override
    public MovieDirector updateMovieDirector(MovieDirector movieDirector) {
        Optional<MovieDirector> optionalMovieDirectorToUpdate = movieDirectorRepository.findById(movieDirector.getId());
        if (!optionalMovieDirectorToUpdate.isPresent()) {
            log.error("No Movie Director with id {} found", movieDirector.getId());
            throw new NoMovieDirectorFoundException();
        }

        if (StringUtils.isAllBlank(movieDirector.getName(), movieDirector.getMiddleName(), movieDirector.getSurname())) {
            log.error("No args provided");
            throw new NoArgsProvidedException();
        }

        MovieDirector movieMovieDirectorToUpdate = optionalMovieDirectorToUpdate.get();
        movieMovieDirectorToUpdate.setMiddleName(Optional.ofNullable(movieDirector.getMiddleName())
                .orElse(movieMovieDirectorToUpdate.getMiddleName()));
        movieMovieDirectorToUpdate.setName(Optional.ofNullable(movieDirector.getName())
                .orElse(movieMovieDirectorToUpdate.getName()));
        movieMovieDirectorToUpdate.setSurname(Optional.ofNullable(movieDirector.getSurname())
                .orElse(movieMovieDirectorToUpdate.getSurname()));

        return movieDirectorRepository.save(movieMovieDirectorToUpdate);
    }

    @Override
    public void removeMovieDirector(Long movieDirectorId) throws NoMovieDirectorFoundException {
        if (!movieDirectorRepository.existsById(movieDirectorId)) {
            log.error("No Movie Director with id {} found", movieDirectorId);
            throw new NoMovieFoundException();
        }

        movieDirectorRepository.deleteById(movieDirectorId);
    }
}
