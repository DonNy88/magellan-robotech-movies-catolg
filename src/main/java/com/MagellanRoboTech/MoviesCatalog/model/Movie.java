package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private Date releaseDate;
    private String overview;
    private int duration;
    private boolean adult;
    private int rating;

    @ManyToMany
    private Set<MovieDirector> movieDirectors;
}
