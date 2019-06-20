package com.learning.java8;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OptionalClassTest {

    @Test
    @DisplayName("Using Optional with positive number")
    void testConvertToString() {
        String convertToString = new OptionalClass().convertToString(1);

        assertThat(convertToString).isEqualTo("1");

        convertToString = new OptionalClass().convertToString(100);

        assertThat(convertToString).isEqualTo("100");
    }

    @Test
    @DisplayName("Using Optional with negative number should throw exception")
    void testConvertToStringWithNegativeNumberShouldThrowException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new OptionalClass().convertToString(-1));
    }

}
