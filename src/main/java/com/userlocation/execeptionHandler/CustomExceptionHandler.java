package com.userlocation.execeptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> exceptionHandle (MethodArgumentNotValidException e) {
        Map<String, String> eMap = new HashMap<>();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        for (ObjectError error : allErrors) {
            String code = error.getCode();
            String defaultMessage = error.getDefaultMessage();
            eMap.put(code, defaultMessage);
        }
        return  new ResponseEntity<>(eMap, HttpStatus.BAD_REQUEST);
    }
}
