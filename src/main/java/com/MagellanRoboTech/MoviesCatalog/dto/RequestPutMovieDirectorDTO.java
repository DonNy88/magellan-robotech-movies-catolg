package com.MagellanRoboTech.MoviesCatalog.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RequestPutMovieDirectorDTO {

    @NotNull(message = "The field id cannot be null")
    private Long id;

    @Size(max = 70, message = "The field name length cannot be more then 70 chars")
    private String name;

    @Size(max = 70, message = "The field middleName length cannot be more then 70 chars")
    private String middleName;

    @Size(max = 70, message = "The field surname length cannot be more then 70 chars")
    private String surname;
}
