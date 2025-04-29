package com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common;

import com.springbootessentials.springbootessentials.domain.exception.SPEssentialsException;
import com.springbootessentials.springbootessentials.infrastructure.adapter.input.rest.common.dto.ControllerErrorResDTO;
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
    public ResponseEntity<ControllerErrorResDTO> handleException(SPEssentialsException ex) {

        log.error(ex);
        ControllerErrorResDTO errorResponse = new ControllerErrorResDTO.Builder()
                .setMsg(ex.getMessage())
                .setHttpStatus(ex.getHttpStatus())
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ControllerErrorResDTO> handleException(RuntimeException ex) {

        log.error(ex);
        ControllerErrorResDTO errorResponse = new ControllerErrorResDTO.Builder()
                .setMsg(ex.getMessage())
                .setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }

}
