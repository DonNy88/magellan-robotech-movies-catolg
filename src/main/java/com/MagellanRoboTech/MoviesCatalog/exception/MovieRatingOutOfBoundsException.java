package com.MagellanRoboTech.MoviesCatalog.exception;

public class MovieRatingOutOfBoundsException extends RuntimeException {

    public MovieRatingOutOfBoundsException() {
        super("Rating must be greater than 0 and less then 6");
    }
}
