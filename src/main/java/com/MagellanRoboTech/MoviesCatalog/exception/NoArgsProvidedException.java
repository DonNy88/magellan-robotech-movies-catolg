package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoArgsProvidedException extends RuntimeException {

    public NoArgsProvidedException() {
        super("No arguments provided");
    }
}
