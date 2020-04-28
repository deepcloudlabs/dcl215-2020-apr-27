package com.example.domain;

import com.example.conditional.ConditionalTestOnOperatingSystem;
import com.example.conditional.OperatingSystem;
import org.junit.jupiter.api.Test;

public class UseDisabledOnOperatingSystemTest {
    @Test
    @ConditionalTestOnOperatingSystem({OperatingSystem.WINDOWS,OperatingSystem.LINUX})
    void test1(){
        System.err.println("Running on Windows/Linux...");
    }

    @Test
    @ConditionalTestOnOperatingSystem(OperatingSystem.LINUX)
    void test2(){
        System.err.println("Running on Linux...");
    }
}
