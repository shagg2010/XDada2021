package com.yadas.web.rest.exception;

import java.util.Date;

public class RestApiExceptions {

    private Date date;
    private String message;
    private String details;

    public RestApiExceptions(Date date, String message, String details) {
        super();
        this.date = date;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return this.date;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
