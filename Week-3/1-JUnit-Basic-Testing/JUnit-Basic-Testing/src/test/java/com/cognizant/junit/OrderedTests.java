package com.cognizant.junit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testOne() {
        System.out.println("Test 1");
    }

    @Test
    @Order(2)
    void testTwo() {
        System.out.println("Test 2");
    }

    @Test
    @Order(3)
    void testThree() {
        System.out.println("Test 3");
    }
}