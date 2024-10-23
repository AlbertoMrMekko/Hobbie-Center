package com.AlbertoMrMekko.hobbiecenter.exceptions;

import com.AlbertoMrMekko.hobbiecenter.model.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<Book> entityNotFoundException(EntityNotFoundException ex) // TODO comprobar <Book>
    {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler
    public ResponseEntity<Book> illegalArgumentException(IllegalArgumentException ex) // TODO comprobar <Book>
    {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler
    public ResponseEntity<Book> methodArgumentNotValidException(MethodArgumentNotValidException ex) // TODO comprobar <Book>
    {
        return ResponseEntity.badRequest().build();
    }
}
