package com.cognizant.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionTest {

    @Test
    void testDivisionByZero() {

        Division division = new Division();

        assertThrows(ArithmeticException.class, () -> {
            division.divide(10, 0);
        });

    }
}