package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoMovieFoundException extends NotFoundException {

    public NoMovieFoundException() {
        super("No movie found");
    }
}
