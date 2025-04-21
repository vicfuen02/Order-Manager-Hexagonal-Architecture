package com.springbootessentials.springbootessentials.domain.exception;

import org.springframework.http.HttpStatus;

public enum UserExceptionsEnum {


    USER_NOT_FOUND ("USR002", "User was not found", HttpStatus.NOT_FOUND)

            ;

    private String code;
    private String desc;
    private HttpStatus httpStatus;

    UserExceptionsEnum(String code, String desc, HttpStatus httpStatus) {
        this.code = code;
        this.desc = desc;
        this.httpStatus = httpStatus;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
