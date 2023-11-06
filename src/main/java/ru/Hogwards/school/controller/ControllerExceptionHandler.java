package ru.Hogwards.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.Hogwards.school.Exception.AlreadyExistsException;
import ru.Hogwards.school.Exception.NotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({AlreadyExistsException.class})
    public ResponseEntity<String> handelException(AlreadyExistsException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex.getMessage());
    }
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handelException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
}
