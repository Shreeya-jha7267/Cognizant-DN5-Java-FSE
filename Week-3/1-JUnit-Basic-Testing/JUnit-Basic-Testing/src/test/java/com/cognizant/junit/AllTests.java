package com.cognizant.junit;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        CalculatorTest.class,
        DivisionTest.class,
        NumberCheckerTest.class,
        StringUtilsTest.class,
        EvenCheckerTest.class
})
public class AllTests {
}