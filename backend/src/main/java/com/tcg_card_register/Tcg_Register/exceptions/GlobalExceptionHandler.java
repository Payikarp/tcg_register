package com.tcg_card_register.Tcg_Register.exceptions;

import com.tcg_card_register.Tcg_Register.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFound(ResourceNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionDTO(Instant.now(), HttpStatus.NOT_FOUND.value(), e.getMessage()));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ExceptionDTO> handleDatabaseException(DatabaseException e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ExceptionDTO(Instant.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }

}
