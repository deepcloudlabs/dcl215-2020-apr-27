package com.example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyFunctionalProgramming {

    public static void main(String[] args) {
        int x = 42; // primitive value
        BigDecimal y = new BigDecimal(1_000_000); // object
        MyFun z1 = new MyFun() {
            @Override
            public int sum(int x, int y) {
                return x + y;
            }
        }; // (1) Anonymous Class
        MyFun z2 = (int a, int b) -> {
            return a + b;
        }; // (2) Lambda Expression
        MyFun z3 = (u, v) -> u + v;
        MyFun z4 = MathUtil::topla; // (3) static method, :: -> method reference
        // Function --> Functional Interface ? SAM: Single Abstract Method
        // Arrays.asList(4,8,15,16,23,42)
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42); // Java 9 -> immutable list
        int sum1 = numbers.stream().reduce(0, z3::sum); // z::sum -> function
        int sum2 = numbers.stream().reduce(0, (u, v) -> u + v);
        int sum3 = numbers.stream().reduce(0, z4::sum);
        int sum4 = numbers.stream().reduce(0, MathUtil::topla);
        System.out.println("sum1=" + sum1);
        System.out.println("sum2=" + sum2);
        System.out.println("sum3=" + sum3);
        System.out.println("sum4=" + sum4);
    }
}

interface MathUtil {
    static int topla(int p, int q) { // Java 8 -> interface can have static method
        return p + q;
    }
}

@FunctionalInterface
interface MyFun {
    public int sum(int x, int y); // abstract method

    public static int topla(int p, int q) { // Java 8 -> (1) static method
        return p + q; // functional programming utility functions
    }

    default void gun() {
        run();
    } // Java 8 (2) default method -> API Evaluation

    default void lun() {
        run();
    } // Java 8 (2) default method -> API Evaluation

    static void yun1() {
        sun();
    }

    static void yun2() {
        sun();
    }

    private static void sun() {
    } // Java 9 (1) private static

    private void run() {
    } // Java 9 (2) private method
}
