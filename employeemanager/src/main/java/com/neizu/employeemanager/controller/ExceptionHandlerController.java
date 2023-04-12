package com.neizu.employeemanager.controller;

import com.neizu.employeemanager.exception.IdNotFoundException;
import com.neizu.employeemanager.exception.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(IdNotFoundException.class)
    public ErrorResponse handleIdNotFoundException(IdNotFoundException e) {
        return ErrorResponse.builder()
                .message(e.getMessage())
                .date(LocalDateTime.now())
                .errorCode(HttpStatus.NOT_FOUND)
                .build();
    }











}
