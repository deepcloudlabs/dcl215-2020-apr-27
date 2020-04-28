package com.example.domain;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class UseRepeatedTest {

    @RepeatedTest(10)
    void test1(RepetitionInfo info){
        System.err.println(String.format("#%d of %d",
                info.getCurrentRepetition(),
                info.getTotalRepetitions()));
    }
}
