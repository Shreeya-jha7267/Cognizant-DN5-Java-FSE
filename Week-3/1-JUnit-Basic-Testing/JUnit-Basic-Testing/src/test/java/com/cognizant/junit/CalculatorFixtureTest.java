package com.cognizant.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorFixtureTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("Setup");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Cleanup");
    }

    @Test
    void testAdd() {
        assertEquals(10, calculator.add(4, 6));
    }

    @Test
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
    }
}