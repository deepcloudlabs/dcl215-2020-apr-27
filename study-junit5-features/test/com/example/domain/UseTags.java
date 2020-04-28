package com.example.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

//@Tag("functional")
@FunctionalTest
public class UseTags {

    @Test
    @PerformanceTest
    @UnitTest
    void test1(TestInfo testInfo){
        System.out.println(testInfo.getTags());
    }

    @Test
    @Tag("integration")
    @StressTest
    void test2(TestInfo testInfo){
        System.out.println(testInfo.getTags());
    }
}
