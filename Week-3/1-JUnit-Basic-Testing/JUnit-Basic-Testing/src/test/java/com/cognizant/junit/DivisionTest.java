package com.cognizant.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DivisionTest {

    Division division = new Division();

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            division.divide(10, 0);
        });
    }
}