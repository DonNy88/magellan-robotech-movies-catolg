package com.MagellanRoboTech.MoviesCatalog.repository;

import com.MagellanRoboTech.MoviesCatalog.model.MovieDirector;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface that performs all Movie Director queries.
 *
 * @see org.springframework.data.repository.Repository
 */
@Repository
public interface MovieDirectorRepository extends CrudRepository<MovieDirector, Long> { }
