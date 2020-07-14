package com.MagellanRoboTech.MoviesCatalog.repository;

import com.MagellanRoboTech.MoviesCatalog.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface that performs all Movie queries.
 *
 * @see org.springframework.data.repository.Repository
 */
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    /**
     * Fetch all movies with rating greater than or Equal to the rating provided.
     * @param rating rating for filter
     * @return the result of the query
     */
    Iterable<Movie> findAllByRatingGreaterThanEqual(Integer rating);

    /**
     * Search all movies by movie Director Id.
     * @param movieDirectorId the movie Director Id for filter.
     * @return the result of the query
     */
    Iterable<Movie> findAllByMovieDirectorId(Long movieDirectorId);
}
