package com.springbootessentials.springbootessentials.service.address.exceptions;

import org.springframework.http.HttpStatus;

public enum AddressExceptionsEnum {

    ADDRESS_NOT_FOUND ("ADR001", "Address was not found", HttpStatus.NOT_FOUND)

    ;

    private String code;
    private String desc;
    private HttpStatus httpStatus;

    AddressExceptionsEnum(String code, String desc, HttpStatus httpStatus) {
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
