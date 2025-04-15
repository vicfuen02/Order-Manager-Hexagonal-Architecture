package com.springbootessentials.springbootessentials.common.exception;

import com.springbootessentials.springbootessentials.service.address.exceptions.AddressExceptionsEnum;
import com.springbootessentials.springbootessentials.service.order.exceptions.OrderExceptionsEnum;

public class SPEssentialsExceptionFactory {

    public static SPEssentialsException throwException(SPEssentialsBaseExceptionEnum exceptionEnum) {
        return new SPEssentialsException(exceptionEnum.getCode(), exceptionEnum.getDesc(), exceptionEnum.getHttpStatus());
    }
    public static SPEssentialsException throwException(OrderExceptionsEnum exceptionEnum) {
        return new SPEssentialsException(exceptionEnum.getCode(), exceptionEnum.getDesc(), exceptionEnum.getHttpStatus());
    }
    public static SPEssentialsException throwException(AddressExceptionsEnum exceptionEnum) {
        return new SPEssentialsException(exceptionEnum.getCode(), exceptionEnum.getDesc(), exceptionEnum.getHttpStatus());
    }



}
