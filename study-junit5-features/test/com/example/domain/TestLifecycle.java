package com.example.domain;

import org.junit.jupiter.api.*;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("Study test lifecycle methods")
@TestMethodOrder(MethodOrderer.Random.class)
public class TestLifecycle {
    @BeforeAll
    static void beforeAllTests() {
        System.err.println("@BeforeAll runs once before all test methods...");
    }

    @AfterAll
    static void afterAllTests() {
        System.err.println("@AfterAll runs once after all test methods...");
    }

    @BeforeEach
    void beforeEachTest() {
        System.err.println("@BeforeEach runs once before each test method...");
    }

    @AfterEach
    void afterEachTest() {
        System.err.println("@AfterEach runs once after each test method...");
    }


    @Test
    @DisplayName("elma is done")
    @Order(3)
    void elma() {
        System.err.println("elma is running...");
    }


    @Test
    @DisplayName("muz is done")
    @Order(2)
    void muz() {
        System.err.println("muz is running...");
    }

    @Test
    @DisplayName("kiraz is done")
    @Order(1)
    void kiraz() {
        System.err.println("kiraz is running...");
    }
}
