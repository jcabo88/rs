package com.rs.validator;

import com.rs.controller.exceptions.InputValidationException;
import org.apache.commons.lang.StringUtils;

import com.rs.controller.exceptions.ExceptionMessages;

public class UriInputValidator {

    public UriInputValidator() {
    }


    public static void validateId(String id) throws InputValidationException {
        if (StringUtils.isBlank(id) || !StringUtils.isNumeric(id)) {
            throw new InputValidationException(ExceptionMessages.INPUT_EXCEPTION);
        }
    }

    public static void validateString(String stringId) throws InputValidationException {
        if (StringUtils.isBlank(stringId) || StringUtils.isNumeric(stringId)) {
            throw new InputValidationException(ExceptionMessages.INPUT_EXCEPTION);
        }
    }
}
