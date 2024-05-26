package com.ibooking.systemapp.controller;

import com.ibooking.systemapp.exceptions.BookingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookingException.class)
    public ProblemDetail handlerBookingException(BookingException e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        var fieldError = e.getFieldErrors().stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()));
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your Request parameters didn't validate");
        pb.setProperty("Fields: ", fieldError);
        return null;
    }
    private record InvalidParam(String fieldName, String reason){};
}
