package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoMovieDirectorFoundException extends NotFoundException {

    public NoMovieDirectorFoundException() {
        super("No Movie Director found");
    }
}
