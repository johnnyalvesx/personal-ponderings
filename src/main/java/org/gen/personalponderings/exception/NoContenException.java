package org.gen.personalponderings.exception;

import org.springframework.http.HttpStatus;

public class NoContenException extends RuntimeException {

    public NoContenException(String message, HttpStatus httpStatus) {
        super(message);
    }
}
