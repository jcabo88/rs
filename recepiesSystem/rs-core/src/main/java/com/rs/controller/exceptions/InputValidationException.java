package com.rs.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InputValidationException extends IllegalArgumentException {

    public InputValidationException(ExceptionMessages message) {
        super(message.getMessage());
    }
}
