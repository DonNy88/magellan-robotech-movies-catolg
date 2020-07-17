package com.MagellanRoboTech.MoviesCatalog.validation;

import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
import com.MagellanRoboTech.MoviesCatalog.exception.MovieCatalogException;
import com.MagellanRoboTech.MoviesCatalog.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Please, @See {@link ResponseEntityExceptionHandler}
     */
    @Override
    protected ResponseEntity handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage(), ex);

        FieldError fieldError = ex.getBindingResult().getFieldError();
        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(status)
                .message(fieldError.getDefaultMessage())
                .build();

        return ResponseEntity.badRequest().body(responseDTO);
    }

    /**
     * Exception Handler that catch all {@link NotFoundException} and response with Dto Object with NOT FOUND.
     *
     * @param ex the exception
     * @param request the REST request
     * @return A Dto Object with 404 Status Code. Please @see {@link ResponseDTO}
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ResponseDTO<Void>> handleNoMovieFoundException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    /**
     * Exception Handler that catch all {@link MovieCatalogException} and response with Dto Object with BAD REQUEST.
     *
     * @param ex the exception
     * @param request the REST request
     * @return A Dto Object with 400 Status Code. Please @see {@link ResponseDTO}
     */
    @ExceptionHandler(MovieCatalogException.class)
    public final ResponseEntity<ResponseDTO<Void>> handleMovieCatalogException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }

    /**
     * General Exception Handler that catch all {@link Exception} and response with Dto Object with INTERNAL SERVER ERROR.
     * Not should be never invoked.
     *
     * @param ex the exception
     * @param request the REST request
     * @return A Dto Object with 500 Status Code. Please @see {@link ResponseDTO}
     */
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ResponseDTO<Void>> handleGeneralException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        ResponseDTO<Void> responseDTO = ResponseDTO.<Void>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(ex.getMessage()).build();

        return new ResponseEntity<>(responseDTO, responseDTO.getStatus());
    }
}
