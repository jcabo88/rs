package com.rs.controller.exceptions;

import java.io.InvalidObjectException;

public class InputValidationException extends InvalidObjectException {

    public InputValidationException(ExceptionMessages message) {
        super(message.getMessage());
    }
}
