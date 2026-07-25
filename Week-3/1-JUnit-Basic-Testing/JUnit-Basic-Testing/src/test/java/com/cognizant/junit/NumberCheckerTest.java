package com.cognizant.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberCheckerTest {

    @Test
    void testEvenNumber() {
        NumberChecker checker = new NumberChecker();

        assertTrue(checker.isEven(4));
        assertFalse(checker.isEven(5));
    }
}