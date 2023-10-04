package com.api.mentorize.controllers.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.api.mentorize.repositories.exception.RepositoryException;


import java.time.Instant;

@ControllerAdvice

public class ControllerException extends  RuntimeException{
    private DefaultError error = new DefaultError();

    @ExceptionHandler()
    public ResponseEntity<DefaultError> entityNotFound(RepositoryException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Repository error");
        error.setMessage(exception.getMessage());
        return ResponseEntity.status(status).body(this.error);
    }

}
