package com.springbootessentials.springbootessentials.application.service.exception;

import com.springbootessentials.springbootessentials.domain.exception.AddressExceptionsEnum;
import com.springbootessentials.springbootessentials.domain.exception.OrderExceptionsEnum;
import com.springbootessentials.springbootessentials.domain.exception.SPEssentialsBaseExceptionEnum;
import com.springbootessentials.springbootessentials.domain.exception.SPEssentialsException;

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
