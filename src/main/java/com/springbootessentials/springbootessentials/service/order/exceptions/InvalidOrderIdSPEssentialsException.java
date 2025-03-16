package com.springbootessentials.springbootessentials.service.order.exceptions;

import com.springbootessentials.springbootessentials.common.exception.SPEssentialsException;

public class InvalidOrderIdSPEssentialsException extends SPEssentialsException {
    private static final OrderExceptionsEnum orderExceptionsEnum = OrderExceptionsEnum.INVALID_ORDER_ID;

    public InvalidOrderIdSPEssentialsException() {
        super(orderExceptionsEnum.getCode(), orderExceptionsEnum.getDesc(), orderExceptionsEnum.getHttpStatus());
    }
}
