package org.gen.personalponderings.exception;

import org.springframework.http.HttpStatus;

public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message, HttpStatus httpStatus) {
        super(message);
    }
}