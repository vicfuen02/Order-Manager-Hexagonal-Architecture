package com.springbootessentials.springbootessentials.service.order.exceptions;

import org.springframework.http.HttpStatus;

public enum OrderExceptionsEnum {

    INVALID_ORDER_ID ("ORD001", "Order id must be a positive value", HttpStatus.BAD_REQUEST),
    ORDER_NOT_FOUND ("ORD002", "Order was not found", HttpStatus.NOT_FOUND)

    ;

    private String code;
    private String desc;
    private HttpStatus httpStatus;

    OrderExceptionsEnum(String code, String desc, HttpStatus httpStatus) {
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
