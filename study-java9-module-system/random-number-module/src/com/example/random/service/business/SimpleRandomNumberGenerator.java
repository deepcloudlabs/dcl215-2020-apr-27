package com.example.random.service.business;

import com.example.random.service.RandomNumberGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class SimpleRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public int generate(int max) {
        return ThreadLocalRandom.current().nextInt(max);
    }

    @Override
    public int generate(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min,max);
    }
}
