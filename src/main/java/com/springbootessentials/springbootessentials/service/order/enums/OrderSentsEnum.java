package com.springbootessentials.springbootessentials.service.order.enums;

public enum OrderSentsEnum {


    PENDING("ORS001"),
    SENT_APPROVED("ORS002"),
    SENT_INVALID("ORS003"),
    NOT_SENT("ORS004")

    ;


    private String code;


    OrderSentsEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
