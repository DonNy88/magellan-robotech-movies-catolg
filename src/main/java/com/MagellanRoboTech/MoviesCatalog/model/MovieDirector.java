package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class MovieDirector extends BasicEntity {

    private String name;
    private String middleName;
    private String surname;
    private Date bornDate;

//    @OneToMany
//    private Set<Movie> movies;
}
