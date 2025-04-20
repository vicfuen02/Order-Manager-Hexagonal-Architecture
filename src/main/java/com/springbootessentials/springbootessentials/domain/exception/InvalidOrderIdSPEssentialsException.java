package com.springbootessentials.springbootessentials.domain.exception;

public class InvalidOrderIdSPEssentialsException extends SPEssentialsException {
    private static final OrderExceptionsEnum orderExceptionsEnum = OrderExceptionsEnum.INVALID_ORDER_ID;

    public InvalidOrderIdSPEssentialsException() {
        super(orderExceptionsEnum.getCode(), orderExceptionsEnum.getDesc(), orderExceptionsEnum.getHttpStatus());
    }
}
