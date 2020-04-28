package com.example.domain;

import org.junit.jupiter.api.Test;

import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AssumeTest {

    @Test
    void test1(){
        assumeTrue(ZoneId.systemDefault().getId().contains("Asia"));
        assumeTrue(System.getProperty("os.version").toString().contains("win"));
        assumeTrue(ZoneId.systemDefault().getId().contains("Asia")
                && System.getProperty("os.version").toString().contains("win")
        );
        assertEquals(4, 2+2);
    }

    @Test
    void test2(){
        assumeTrue(ZoneId.systemDefault().getId().contains("Africa"));
        assumeTrue(System.getProperty("os.version").toString().contains("nix"));
        assertEquals(4, 2+2);
    }
}
