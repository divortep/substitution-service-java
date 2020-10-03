package com.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class IncorrectInputException extends RuntimeException {

    public IncorrectInputException(final String message) {
        super(message);
    }
}
