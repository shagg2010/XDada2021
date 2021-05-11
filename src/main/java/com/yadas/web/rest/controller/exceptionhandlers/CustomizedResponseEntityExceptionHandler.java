package com.yadas.web.rest.controller.exceptionhandlers;

import com.yadas.web.rest.controller.exceptions.HeroNotFoundException;
import com.yadas.web.rest.controller.exceptions.RestApiExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<RestApiExceptions> handleAllExceptions(Exception ex, WebRequest request) {
        RestApiExceptions restApiExceptions = new RestApiExceptions(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(restApiExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HeroNotFoundException.class)
    public final ResponseEntity<RestApiExceptions> handleUserNotFoundException(HeroNotFoundException ex, WebRequest request) {
        RestApiExceptions restApiExceptions = new RestApiExceptions(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(restApiExceptions, HttpStatus.NOT_FOUND);
    }
}
