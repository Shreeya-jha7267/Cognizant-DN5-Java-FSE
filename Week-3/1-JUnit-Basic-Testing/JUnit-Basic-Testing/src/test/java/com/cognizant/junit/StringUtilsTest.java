package com.cognizant.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringUtilsTest {

    @Test
    void testReverse() {
        StringUtils s = new StringUtils();

        assertEquals("olleH", s.reverse("Hello"));
    }
}