package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoIdProvidedException extends RuntimeException {

    public NoIdProvidedException() {
        super("No Id provided");
    }
}
