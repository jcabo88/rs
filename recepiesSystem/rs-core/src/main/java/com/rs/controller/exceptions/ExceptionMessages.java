package com.rs.controller.exceptions;

public enum ExceptionMessages {

    INPUT_EXCEPTION ("The id is not numeric or it is not valid");

    private final String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
