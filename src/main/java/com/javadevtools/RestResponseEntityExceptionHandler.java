package com.javadevtools;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        return handleBindException(ex, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        FieldError firstError = ex.getFieldError();

        Map<String, Object> result = new HashMap<>();
        result.put("value", firstError.getDefaultMessage());

        if (!isError(firstError, "dateFormatParams", "pattern", "NotBlank")
                && !isError(firstError, "parseParams", "pattern", "NotBlank")
                && !isError(firstError, "parseParams", "text", "NotBlank")
                && !isError(firstError, "parseParamsWithTimeZone", "pattern", "NotBlank")
                && !isError(firstError, "parseParamsWithTimeZone", "text", "NotBlank")) {
            result.put("error", true);
        }

        return handleExceptionInternal(ex, result, headers, HttpStatus.OK, request);
    }
    
    private boolean isError(FieldError error, String objectName, String field, String code) {
        return error.getObjectName().equals(objectName)
                && error.getField().equals(field) 
                && error.getCode().equals(code);
    }
}