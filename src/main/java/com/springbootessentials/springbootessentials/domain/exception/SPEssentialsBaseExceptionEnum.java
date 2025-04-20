package com.springbootessentials.springbootessentials.domain.exception;

import org.springframework.http.HttpStatus;

public enum SPEssentialsBaseExceptionEnum {

    GENERIC_ERROR("GEN001", "An internal error occured", HttpStatus.INTERNAL_SERVER_ERROR)

    ;
    private String code;
    private String desc;
    private HttpStatus httpStatus;

    SPEssentialsBaseExceptionEnum(String code, String desc, HttpStatus httpStatus) {
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
