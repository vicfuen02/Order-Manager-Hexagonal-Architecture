package com.springbootessentials.springbootessentials.controller.order.impl;

import com.springbootessentials.springbootessentials.controller.common.BaseExceptionHandler;
import com.springbootessentials.springbootessentials.controller.common.ControllerErrorResponseDTO;
import com.springbootessentials.springbootessentials.service.order.exceptions.InvalidOrderIdSPEssentialsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class OrderExceptionHandler extends BaseExceptionHandler {


    @ExceptionHandler({InvalidOrderIdSPEssentialsException.class})
    public ResponseEntity<ControllerErrorResponseDTO> handleException(InvalidOrderIdSPEssentialsException ex) {

        String msg  = new StringBuilder("My special treatement to invalid order id. ")
                .append(ex.getMessage())
                .toString();
        ControllerErrorResponseDTO errorResponse = new ControllerErrorResponseDTO.Builder()
                .setMsg(msg)
                .setHttpStatus(ex.getHttpStatus())
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }



}
