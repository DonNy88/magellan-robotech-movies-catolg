package com.MagellanRoboTech.MoviesCatalog.core;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 *
 * @param <T>
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