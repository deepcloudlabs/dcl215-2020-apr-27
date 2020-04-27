package com.example.random.service.business;

import com.example.random.service.RandomNumberGenerator;

import java.security.SecureRandom;

public class SecureRandomNumberGenerator implements RandomNumberGenerator {
    private SecureRandom random = new SecureRandom();

    @Override
    public int generate(int max) {
        return random.nextInt(max);
    }

    @Override
    public int generate(int min, int max) {
        return random.nextInt(max - min) + min;
    }
}
