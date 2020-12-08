package com.itlg.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(BusinessRunTimeException.class)
    public ResponseEntity<R> handlerException(BusinessRunTimeException e){
        return  ResponseEntity.status(e.getCodeMsg().getCode())
                .body(new R(e.getCodeMsg()));
    }
}