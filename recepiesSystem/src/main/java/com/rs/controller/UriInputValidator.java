package com.rs.controller;

import com.rs.controller.exceptions.InputValidationException;
import org.apache.commons.lang.StringUtils;

import static com.rs.controller.exceptions.ExceptionMessages.INPUT_EXCEPTION;

public class UriInputValidator {

    public UriInputValidator() {
    }

    public static void validateId(String id) throws InputValidationException {
        if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
            throw new InputValidationException(INPUT_EXCEPTION);
        }
    }

    public static void validateString(String stringId) throws InputValidationException {
        if (StringUtils.isBlank(stringId)) {
            throw new InputValidationException(INPUT_EXCEPTION);
        }
    }
}
