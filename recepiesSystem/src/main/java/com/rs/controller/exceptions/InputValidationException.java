package com.rs.controller.exceptions;

import java.io.InvalidObjectException;

public class InputValidationException extends InvalidObjectException {

    public InputValidationException(String message) {
        super(message);
    }
}
