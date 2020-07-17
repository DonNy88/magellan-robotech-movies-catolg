package com.MagellanRoboTech.MoviesCatalog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * Entity that maps the Db table movie.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "The field title cannot be blank")
    @Size(max=100, message = "The title max length is 100 characters")
    private String title;
    @NotBlank(message = "The field overview cannot be blank")
    @Size(max=255, message = "The overview max length is 255 characters")
    private String overview;
    @NotNull
    @Min(value = 1, message = "The movie should lasts at least 1 minute")
    private Long duration; // minutes of the movie
    @NotNull
    @Min(value = 1, message = "The rating must be greater than or equal to 1")
    @Max(value = 5, message = "The rating must be less than or equal to 5")
    private Integer rating;

    @NotNull(message = "Each Movie has to a Movie Director")
    @ManyToOne(cascade = CascadeType.ALL)
    private MovieDirector movieDirector;
}
