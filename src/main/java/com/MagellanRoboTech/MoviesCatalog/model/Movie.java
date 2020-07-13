package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Data
@Entity
public class Movie extends BasicEntity {

    @NotBlank(message = "Title cannot be blank")
    private String title;
    private Date releaseDate;
    @NotBlank(message = "Title cannot be blank")
    @Size(max=255, message = "Overview max length is 255 characters")
    private String overview;
    @NotNull
    @Min(value = 1, message = "Movie should lasts at least 1 minute")
    private int duration;
    @NotNull
    private boolean adult;
    @NotNull
    @Min(value = 1, message = "Rating must be greater than or equal to 1")
    @Max(value = 5, message = "Rating must be less than or equal to 5")
    private int rating;

//    @ManyToOne
//    private MovieDirector movieDirector;
}
