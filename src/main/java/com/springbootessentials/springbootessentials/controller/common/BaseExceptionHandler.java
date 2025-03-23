package com.springbootessentials.springbootessentials.controller.common;

import com.springbootessentials.springbootessentials.common.exception.SPEssentialsException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class BaseExceptionHandler extends BaseRestController {

    private final Logger log = LogManager.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler({SPEssentialsException.class})
    public ResponseEntity<ControllerErrorResponseDTO> handleException(SPEssentialsException ex) {

        log.error(ex);
        ControllerErrorResponseDTO errorResponse = new ControllerErrorResponseDTO.Builder()
                .setMsg(ex.getMessage())
                .setHttpStatus(ex.getHttpStatus())
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ControllerErrorResponseDTO> handleException(RuntimeException ex) {

        log.error(ex);
        ControllerErrorResponseDTO errorResponse = new ControllerErrorResponseDTO.Builder()
                .setMsg(ex.getMessage())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}
