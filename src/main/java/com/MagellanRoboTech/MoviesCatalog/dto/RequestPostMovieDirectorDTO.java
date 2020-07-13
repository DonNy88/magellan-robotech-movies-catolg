package com.MagellanRoboTech.MoviesCatalog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class RequestPostMovieDirectorDTO {

    @NotBlank(message = "The field name cannot be blank")
    @Size(max = 70, message = "The field name length cannot be more then 70 chars")
    private String name;

    @Size(max = 70, message = "The field middleName length cannot be more then 70 chars")
    private String middleName;

    @NotBlank(message = "The field name cannot be blank")
    @Size(max = 70, message = "The field surname length cannot be more then 70 chars")
    private String surname;
}
