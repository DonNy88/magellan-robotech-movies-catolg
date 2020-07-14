package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class MovieDirector {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "The field name cannot be blank")
    @Size(max = 70, message = "The field name length cannot be more then 70 chars")
    private String name;
    @Size(max = 70, message = "The field middleName length cannot be more then 70 chars")
    private String middleName;
    @NotBlank(message = "The field name cannot be blank")
    @Size(max = 70, message = "The field surname length cannot be more then 70 chars")
    private String surname;

//    // Not required
//    @OneToMany
//    private Set<Movie> movies;
}
