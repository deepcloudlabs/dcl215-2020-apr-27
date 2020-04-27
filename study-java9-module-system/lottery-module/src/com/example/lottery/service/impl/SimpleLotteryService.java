package com.example.lottery.service.impl;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleLotteryService implements LotteryService {
    private RandomNumberGenerator randomNumberGenerator;

    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public List<Integer> draw() {
        return IntStream.generate( () -> randomNumberGenerator.generate(1,50))
                        .distinct()
                        .limit(6)
                        .sorted()
                        .boxed()
                        .collect(Collectors.toList());
    }

    @Override
    public List<List<Integer>> draw(int column) {
        return IntStream.range(0,column)
                     .mapToObj( i -> this.draw() )
                     .collect(Collectors.toList()); // Fluent API
    }
}
