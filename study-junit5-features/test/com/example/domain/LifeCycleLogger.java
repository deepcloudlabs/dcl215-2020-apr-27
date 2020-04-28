package com.example.domain;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public interface LifeCycleLogger { // Java SE 8
    @BeforeAll
    static void beforeAllTests() {
        System.err.println("@BeforeAll is running...");
    }

    @AfterAll
    static void afterAllTests() {
        System.err.println("@AfterAll is running...");
    }

    @BeforeEach
    default void beforeEachTest() {
        System.err.println("@BeforeEach is running...");
    }

    @AfterEach
    default void afterEachTest() {
        System.err.println("@AfterEach is running...");
    }
}
