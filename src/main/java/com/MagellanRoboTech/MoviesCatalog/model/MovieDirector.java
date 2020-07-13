package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Data
@Entity
public class MovieDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "The field name cannot be blank")
    private String name;
    private String middleName;
    @NotBlank(message = "The field name cannot be blank")
    private String surname;

    @OneToMany
    private Set<Movie> movies;
}
