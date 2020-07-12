package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class MovieDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String middleName;
    private String surname;
    private Date bornDate;

    @ManyToMany
    private Set<Movie> movies;
}
