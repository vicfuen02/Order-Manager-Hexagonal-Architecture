package com.springbootessentials.springbootessentials.domain.order;

public enum OrderSentsEnum {


    NOT_SENT("ORS001"),
    PENDING("ORS002"),
    SENT_APPROVED("ORS003"),
    SENT_INVALID("ORS004")
    ;


    private String code;


    OrderSentsEnum(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
