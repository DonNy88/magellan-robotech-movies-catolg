package com.MagellanRoboTech.MoviesCatalog.service;

import com.MagellanRoboTech.MoviesCatalog.exception.NoArgsProvidedException;
import com.MagellanRoboTech.MoviesCatalog.exception.NoMovieDirectorFoundException;
import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import org.springframework.stereotype.Service;

@Service
public interface MovieDirectorService {

    /**
     * @return
     */
    Iterable<MovieDirector> getAllMovieDirectors();

    /**
     * @param movieDirectorId
     * @return
     * @throws NoMovieDirectorFoundException
     */
    MovieDirector getMovieDirector(Long movieDirectorId) throws NoMovieDirectorFoundException;

    /**
     * @param movieDirector
     * @return
     */
    MovieDirector saveMovieDirector(MovieDirector movieDirector);

    /**
     * @param movieDirector
     * @return
     * @throws NoArgsProvidedException
     * @throws NoMovieDirectorFoundException
     */
    MovieDirector updateMovieDirector(MovieDirector movieDirector) throws NoArgsProvidedException, NoMovieDirectorFoundException;

    /**
     *
     * @param movieDirectorId
     * @throws NoMovieDirectorFoundException
     */
    void removeMovieDirector(Long movieDirectorId) throws NoMovieDirectorFoundException;
}
