package com.MagellanRoboTech.MoviesCatalog.validation;

import com.MagellanRoboTech.MoviesCatalog.dto.ResponseDTO;
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
        ResponseDTO responseDTO = ResponseDTO.builder()
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
    public final ResponseEntity<ResponseDTO> handleNoMovieFoundException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);

        ResponseDTO responseDTO = ResponseDTO.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getMessage()).build();

        return new ResponseEntity(responseDTO, responseDTO.getStatus());
    }

//    /**
//     *
//     * @param ex
//     * @param request
//     * @return
//     */
//    @ExceptionHandler(BindException.class)
//    public final ResponseEntity<Object> handleBindException(Exception ex, WebRequest request) {
//        log.error(ex.getMessage(), ex);
//
//        ResponseDTO responseDTO = ResponseDTO.builder()
//                .status(HttpStatus.BAD_REQUEST)
//                .message(ex.getMessage()).build();
//
//        return new ResponseEntity(responseDTO,responseDTO.getStatus());
//    }
}
