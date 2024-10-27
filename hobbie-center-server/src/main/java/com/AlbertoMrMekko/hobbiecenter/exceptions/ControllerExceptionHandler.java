package com.AlbertoMrMekko.hobbiecenter.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> entityNotFoundException()
    {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> illegalArgumentException()
    {
        return ResponseEntity.badRequest().body("Invalid argument");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException()
    {
        return ResponseEntity.badRequest().body("Validations failed");
    }
}
