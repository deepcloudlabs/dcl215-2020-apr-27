package com.example.lottery.service;

import com.example.random.service.RandomNumberGenerator;

import java.util.List;

public interface LotteryService {
    List<Integer> draw();
    List<List<Integer>> draw(int column);
    void setRandomNumberGenerator(RandomNumberGenerator rng);
}
