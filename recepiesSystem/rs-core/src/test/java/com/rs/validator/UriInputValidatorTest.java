package com.rs.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UriInputValidatorTest {

    @Test
    void validateId() {
        Assertions.assertDoesNotThrow(() -> UriInputValidator.validateId("3"));
    }

    @Test
    void validateBlankId() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriInputValidator.validateId(""));
    }

    @Test
    void validateNoNumericId() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriInputValidator.validateId("aaa"));
    }

    @Test
    void validateString() {
        Assertions.assertDoesNotThrow(() -> UriInputValidator.validateString("abc"));
    }

    @Test
    void validateNumericString() {
        Assertions.assertDoesNotThrow(() -> UriInputValidator.validateString("1"));
    }

    @Test
    void validateBlankString() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> UriInputValidator.validateString(""));
    }
}