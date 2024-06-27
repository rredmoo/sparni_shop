package lv.venta.controller;

import java.util.NoSuchElementException;

import org.aspectj.lang.reflect.NoSuchAdviceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchAdviceException.class)
    public ResponseEntity<String> handleNoSuchElementFoundException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("Item not found");
    }
}
