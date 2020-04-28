package com.example.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class UseTimeout {
    @Test
    @Timeout(value=5,unit = TimeUnit.MILLISECONDS)
    void longRunningTest() throws Throwable {
        TimeUnit.SECONDS.sleep(10);
    }
}
