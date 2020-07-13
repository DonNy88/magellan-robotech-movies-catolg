package com.MagellanRoboTech.MoviesCatalog.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class RequestGetMovieDTO {

    @NotBlank(message = "The field title cannot be blank")
    private String title;

    @NotBlank(message = "The field overview cannot be blank")
    @Size(max=255, message = "The overview max length is 255 characters")
    private String overview;

    @NotNull(message = "The field duration cannot be null")
    @Min(value = 1, message = "The movie should lasts at least 1 minute")
    private int duration;

    @NotNull(message = "The field title cannot be null")
    @Min(value = 1, message = "The field rating must be greater than or equal to 1")
    @Max(value = 5, message = "The field rating must be less than or equal to 5")
    private int rating;

    @NotNull(message = "The field movieDirectorId cannot be null")
    private Long movieDirectorId;
}
