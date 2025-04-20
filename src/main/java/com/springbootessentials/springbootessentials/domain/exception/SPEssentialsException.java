package com.springbootessentials.springbootessentials.domain.exception;

import org.springframework.http.HttpStatus;

public class SPEssentialsException extends RuntimeException {

    private String code;
    private String message;
    private HttpStatus httpStatus;

    public SPEssentialsException(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public SPEssentialsException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
