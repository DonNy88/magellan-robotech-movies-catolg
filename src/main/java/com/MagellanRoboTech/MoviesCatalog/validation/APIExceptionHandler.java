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
     *
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
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
     *
     * @param ex
     * @param request
     * @return
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
     *
     * @param ex
     * @param request
     * @return
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
     *
     * @param ex
     * @param request
     * @return
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
