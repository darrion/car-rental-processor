package com.example.carrentalprocessor.handler;

import com.example.carrentalprocessor.exception.ApiException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CarRentalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        final MethodArgumentNotValidException ex, 
        final HttpHeaders headers, 
        final HttpStatus status, 
        final WebRequest request
        ) {
        List<String> errors = new ArrayList<>();
        List<String> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        List<String> globalErrors = ex.getBindingResult()
                .getGlobalErrors()
                .stream()
                .map(globalError -> globalError.getObjectName() + ": " + globalError.getDefaultMessage())
                .collect(Collectors.toList());
        errors.addAll(fieldErrors);
        errors.addAll(globalErrors);
        return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class) 
    protected ResponseEntity<Object> handleConstraintViolation(
        final ConstraintViolationException ex
    ) {
        List<String> errors = new ArrayList<>(); 
        errors.add(ex.getMessage());
        return new ResponseEntity<>(new ApiException(HttpStatus.BAD_REQUEST, errors), HttpStatus.BAD_REQUEST); 
    }
}