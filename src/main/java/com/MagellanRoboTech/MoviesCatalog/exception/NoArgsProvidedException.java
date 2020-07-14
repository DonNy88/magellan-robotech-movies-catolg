package com.MagellanRoboTech.MoviesCatalog.exception;

public class NoArgsProvidedException extends MovieCatalogException {

    public NoArgsProvidedException() {
        super("No arguments provided");
    }
}
