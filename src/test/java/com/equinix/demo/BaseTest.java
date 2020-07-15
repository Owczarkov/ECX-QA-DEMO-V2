package com.equinix.demo;

import lombok.val;
import org.junit.AfterClass;
import org.junit.BeforeClass;

public abstract class BaseTest {

    @BeforeClass
    public static void init() {
        DriverFactory.setDriver("https://react-shopping-cart-67954.firebaseapp.com/");
    }

    public static double getRandomNumber(int max) {
        val min = 0;
        if (min > max) {
            throw new IllegalArgumentException("Invalid range");
        }
        return min + (Math.random() * (max - min));
    }

    @AfterClass
    public static void tearDown() {
        DriverFactory.quitDriver();
    }
}
