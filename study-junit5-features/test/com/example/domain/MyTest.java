package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class MyTest implements LifeCycleLogger {

    @Test
    @DisplayName("First test")
    void test1(TestInfo testInfo) {
        System.err.println("CUT: "+testInfo.getTestClass().get().getSimpleName());
        System.err.println("MUT: "+testInfo.getTestMethod().get().getName());
        System.err.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("Second test")
    void test2(TestInfo testInfo) {
        System.err.println(testInfo.getTestClass().get().getSimpleName());
        System.err.println(testInfo.getTestMethod().get().getName());
        System.err.println(testInfo.getDisplayName());
    }

}
