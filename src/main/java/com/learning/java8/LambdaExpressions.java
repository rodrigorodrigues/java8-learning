package com.learning.java8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;

public class LambdaExpressions {

    Function<Integer, Integer> incrementNumber = k -> k + 1;

    Function<Integer, Integer> decrementNumber = k -> k - 1;

    Function<Integer, Integer> doubleNumber = k -> k + k;

    Function<Integer, Integer> multiplyNumber = k -> k * k;

    Function<Integer, Integer> divideNumberBy2 = k -> k / 2;

    @FunctionalInterface //This annotation is not necessary but is recommended to have and will produce a compile error when adding another method to this that interface
    interface CustomLambda {
        Logger log = LoggerFactory.getLogger(LambdaExpressions.class);

        String getName();

        default void printName() {
            log.debug("Print Name: {}", getName());
        }

        default void something() {} //'default' methods can have
    }
}
