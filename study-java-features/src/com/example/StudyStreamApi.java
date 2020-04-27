package com.example;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyStreamApi {
    public static void main(String[] args) {
        List<String> names =
                List.of("Jack", "Kate", "James", "Ben", "Jin", "Sun", "Hugo");
        // Hadoop: FilterMapReduce
        Predicate<String> _3letterNames =
                name -> name.length() == 3;
        String csv = names.stream().filter(_3letterNames)
                .collect(Collectors.joining(","));
        System.out.println(csv);
        // "Jack","Kate","James","Ben","Jin","Sun","Hugo"
        //   |      |       |      |     |     |     |   mapToInt(String::length)
        //   v      v       v      v     v     v     v
        //   4      4       5      3     3     3     4
        //          .sum() ----> reduce
        int totalLength = names.stream().mapToInt(String::length).sum();
        totalLength = names.stream().mapToInt(String::length)
                .reduce(0, (sum, len) -> sum + len);
        // reduce lambda function: (sum,len) -> sum + len
        System.out.println(totalLength);
        // Outer Loop
        int sum = 0;
        for (String name : names) {
            sum += name.length();
        }
        System.out.println(sum);
        Set<Integer> set = new TreeSet<>();
        while (set.size() < 6) { // loop
            set.add(ThreadLocalRandom.current().nextInt(1, 50));
        }
        System.out.println(set);
        List<Integer> lotteryNumbers = // inner loop --> Stream API
                ThreadLocalRandom.current()
                        .ints(1, 50)
                        .distinct()
                        .limit(6)
                        .sorted()
                        .parallel()
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(lotteryNumbers);
    }
}
