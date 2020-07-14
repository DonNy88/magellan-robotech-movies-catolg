package com.MagellanRoboTech.MoviesCatalog.dto;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestPutMovieDTO {

    @NotNull(message = "The field id cannot be null")
    private Long id;

    @Size(max=100, message = "The title max length is 25 characters")
    private String title;

    @Size(max=255, message = "The overview max length is 255 characters")
    private String overview;

    @Min(value = 1, message = "The movie should lasts at least 1 minute")
    private Long duration;

    @Min(value = 1, message = "The field rating must be greater than or equal to 1")
    @Max(value = 5, message = "The field rating must be less than or equal to 5")
    private Integer rating;

    private Long movieDirectorId;
}
