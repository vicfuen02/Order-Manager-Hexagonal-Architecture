package com.springbootessentials.springbootessentials.application.service.exception;

import com.springbootessentials.springbootessentials.domain.exception.*;

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
    public static SPEssentialsException throwException(UserExceptionsEnum exceptionEnum) {
        return new SPEssentialsException(exceptionEnum.getCode(), exceptionEnum.getDesc(), exceptionEnum.getHttpStatus());
    }



}
