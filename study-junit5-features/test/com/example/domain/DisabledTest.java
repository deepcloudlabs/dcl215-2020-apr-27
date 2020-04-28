package com.example.domain;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Skip for this time")
public class DisabledTest {

    @Test
    void test1() {
        System.err.println("test #1");
    }

    @Test
    void test2() {
        System.err.println("test #2");
    }
}
