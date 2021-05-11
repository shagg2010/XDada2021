package com.yadas.web.rest.controller.exceptionhandlers;

import com.yadas.web.rest.controller.exceptions.EmployeeNotFoundException;
import com.yadas.web.rest.controller.exceptions.RestApiExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class EmployeeAPIExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<RestApiExceptions> handleAllExceptions(Exception ex, WebRequest request) {
        RestApiExceptions restApiExceptions = new RestApiExceptions(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(restApiExceptions, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    public final ResponseEntity<RestApiExceptions> handleEmployeeNotFoundExceptions(EmployeeNotFoundException ex, WebRequest request) {
        RestApiExceptions restApiExceptions = new RestApiExceptions(new Date(), ex.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(restApiExceptions, HttpStatus.NOT_FOUND);
    }
}
