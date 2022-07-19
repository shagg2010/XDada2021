package com.yadas.web.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such hero in DCU database...")
public class HeroNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public HeroNotFoundException(String message) {
        super(message);
    }
}
