package com.sayildiz.kbe_AppService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ProductControllerAdvice {
    @ResponseBody
    @ExceptionHandler

    @ResponseStatus(HttpStatus.NOT_FOUND)
    String ProductNotFoundHandler(HttpClientErrorException.NotFound exception){
        return exception.getMessage();
    }
}
