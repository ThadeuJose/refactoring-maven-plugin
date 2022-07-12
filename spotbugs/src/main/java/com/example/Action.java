package com.example;

import java.math.BigInteger;

public class Action {
    public void doSomething() {
        Long notUsedLong = 5L;
        int i = 7;
        try {
            System.out.println(i + 2);
        } catch (Exception e) {
        }
    }

    private String[] x;

    public void foo(String[] param) {
        // Don't do this, make a copy of the array at least
        this.x = param;
    }

    void myMethod() {
        BigInteger bi2 = new BigInteger("0");
        boolean condition1 = false;
        boolean condition2 = false;
        try {
            if (condition1) { // +1
                for (int i = 0; i < 10; i++) { // +2 (nesting=1)
                    while (condition2) {
                    } // +3 (nesting=2)
                }
            }
        } catch (Exception | ExceptionInInitializerError e) { // +1
            if (condition2) {
            } // +2 (nesting=1)
        }
    } // Cognitive Complexity 9
}
