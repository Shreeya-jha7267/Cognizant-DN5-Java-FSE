package com.cognizant.junit;

public class StringUtils {

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}