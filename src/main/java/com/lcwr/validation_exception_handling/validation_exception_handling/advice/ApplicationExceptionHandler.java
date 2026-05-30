package com.lcwr.validation_exception_handling.validation_exception_handling.advice;

import com.lcwr.validation_exception_handling.validation_exception_handling.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
 public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex) {
     Map<String,String> errorMap = new HashMap<>();
     ex.getBindingResult().getFieldErrors().forEach(error->{
         errorMap.put(error.getField(),error.getDefaultMessage());
     });
     return errorMap;
 }

 @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
 @ExceptionHandler(UserNotFoundException.class)
 public Map<String,String> handleBusinessException(UserNotFoundException ex) {
     Map<String,String> errorMap = new HashMap<>();
     errorMap.put("errorMessage", ex.getMessage());
     return  errorMap;
 }
}
