package com.example.jpa.example.helper;

import com.example.jpa.example.dto.ExceptionDto;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto indexoutofexception(IndexOutOfBoundsException ex) {

        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Array index out of bound excetion");

    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto nullpointer(NullPointerException ex) {

        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), "Null pointer Exception excetion");

    }

    @ExceptionHandler(CustomeExceptionHelper.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionDto customeExceptionOp(CustomeExceptionHelper ex) {

        return new ExceptionDto(HttpStatus.BAD_REQUEST.value(), ex.getErrorMsg());

    }

}