package com.MagellanRoboTech.MoviesCatalog.exception;

public class MovieRatingOutOfBoundsException extends MovieCatalogException {

    public MovieRatingOutOfBoundsException() {
        super("Rating must be greater than 0 and less than 6");
    }
}
