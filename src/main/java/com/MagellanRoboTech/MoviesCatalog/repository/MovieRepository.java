package com.MagellanRoboTech.MoviesCatalog.repository;

import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    /**
     *
     * @param rating
     * @return
     */
    Iterable<Movie> findAllByRatingGreaterThanEqual(Integer rating);
}
