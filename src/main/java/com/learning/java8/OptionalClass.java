package com.learning.java8;

import java.util.Optional;

public class OptionalClass {
    public String convertToString(int positiveNumber) {
        return Optional.ofNullable(checkPositiveNumber(positiveNumber))
            .orElseThrow(() -> new IllegalArgumentException(String.format("Invalid(%s) number!", positiveNumber)));
    }

    private String checkPositiveNumber(int number) {
        return (number >= 0 ? String.valueOf(number) : null);
    }
}
