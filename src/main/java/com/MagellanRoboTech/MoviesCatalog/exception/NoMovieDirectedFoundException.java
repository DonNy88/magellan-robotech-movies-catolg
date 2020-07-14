package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoMovieDirectedFoundException extends NotFoundException {

    public NoMovieDirectedFoundException() {
        super("The Movie Director has directed no movie yet");
    }
}
