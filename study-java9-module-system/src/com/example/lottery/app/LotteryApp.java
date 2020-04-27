package com.example.lottery.app;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;

import java.util.ServiceLoader;

public class LotteryApp {
    public static void main(String[] args) {
        for (LotteryService ls : ServiceLoader.load(LotteryService.class))
            System.err.println(ls.getClass());
        ServiceLoader<RandomNumberGenerator> randomNumberGenerators = ServiceLoader.load(RandomNumberGenerator.class);
        for (RandomNumberGenerator rng : randomNumberGenerators)
            System.err.println(rng.getClass());
        LotteryService lotteryService =
                ServiceLoader.load(LotteryService.class).findFirst().get();
        for (RandomNumberGenerator rng : randomNumberGenerators){
            System.err.println();
            lotteryService.setRandomNumberGenerator(rng);
            lotteryService.draw(10).forEach(System.out::println);
        }

    }
}
