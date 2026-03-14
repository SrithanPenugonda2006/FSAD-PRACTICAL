package com.klu.exception;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleStudentNotFound(StudentNotFoundException ex){

        Map<String,Object> error=new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("message", ex.getMessage());
        error.put("statusCode",404);

        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<Map<String,Object>> handleInvalidInput(InvalidInputException ex){

        Map<String,Object> error=new HashMap<>();

        error.put("timestamp", LocalDateTime.now());
        error.put("message", ex.getMessage());
        error.put("statusCode",400);

        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }

}