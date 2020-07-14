package com.MagellanRoboTech.MoviesCatalog.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *  Dto Class that is used for all response of this Spring Application.
 *
 * @param <T> Object Type of the Object returned on body field of the response. Please, see the readme file for find out the Response schema
 */
@Data
@Builder
public class ResponseDTO<T> {
    /**
     *
     */
    @Builder.Default
    private HttpStatus status = HttpStatus.OK;

    /**
     *
     */
    @Builder.Default
    private String message = "Success";

    /**
     *
     */
    private T body;
}