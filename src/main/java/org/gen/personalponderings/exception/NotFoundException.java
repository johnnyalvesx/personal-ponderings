package org.gen.personalponderings.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, HttpStatus httpStatus) {
        super(message);
    }
}