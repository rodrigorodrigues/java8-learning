package com.learning.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class LambdaExpressionsTest {
    @Test
    @DisplayName("Lambda Expressions - Increment Number")
    public void testIncrementNumber() {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();

        Integer increment = lambdaExpressions.incrementNumber.apply(1);

        assertThat(increment).isEqualTo(2);
    }

    @Test
    @DisplayName("Lambda Expressions - Double Number")
    public void testDoubleNumber() {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();

        Integer increment = lambdaExpressions.doubleNumber.apply(10);

        assertThat(increment).isEqualTo(20);
    }

    @Test
    @DisplayName("Lambda Expressions - Divide Number By 2")
    public void testDivideNumberBy2() {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();

        Integer increment = lambdaExpressions.divideNumberBy2.apply(100);

        assertThat(increment).isEqualTo(50);
    }

    @Test
    @DisplayName("Lambda Expressions - Using Multiple Functions")
    public void testWithMultipleFunctions() {
        LambdaExpressions lambdaExpressions = new LambdaExpressions();

        Integer apply = lambdaExpressions.incrementNumber
            .andThen(lambdaExpressions.multiplyNumber)
            .andThen(lambdaExpressions.divideNumberBy2)
            .andThen(lambdaExpressions.decrementNumber)
            .apply(9);

        assertThat(apply).isEqualTo(49);
    }

    @Test
    @DisplayName("Using custom lambda")
    public void testUsingCustomLambda() {
        LambdaExpressions.CustomLambda innerClass = new LambdaExpressions.CustomLambda() {
            @Override
            public String getName() {
                return "Inner Class";
            }
        };
        innerClass.printName();

        LambdaExpressions.CustomLambda customLambda = () -> "CustomLambda Expressions";
        customLambda.printName();

        Predicate predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.toLowerCase().contains("customlambda");
            }
        };

        log.debug("Should be false: {}", predicate.test(innerClass.getName()));
        assertThat(predicate.test(innerClass.getName())).isFalse();

        log.debug("Should be true: {}", predicate.test(customLambda.getName()));
        assertThat(predicate.test(customLambda.getName())).isTrue();
    }
}
