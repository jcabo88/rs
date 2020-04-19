package com.rs.controller.exceptions;

public class RecipesControllerException extends RuntimeException {

    public RecipesControllerException() {
    }

    public RecipesControllerException(String message) {
        super(message);
    }
}
