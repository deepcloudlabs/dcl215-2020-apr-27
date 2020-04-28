package com.example.domain;

import com.example.conditional.OperatingSystem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.List;

public class UseParameterizedTests {
    //@Test --> static
    //@RepeatedTest(50) --> static
    //@TestFactory --> Dynamic test
    @ParameterizedTest
    @ValueSource(ints={4,8,15,16,23,42})
    void test1(int i){
        System.out.println("Running test for the value "+i);
    }

    @ParameterizedTest
    @ValueSource(strings = {"jack","kate","james","sun","jin"})
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    void test2(String name){
        System.out.println("Running test for the value "+name);
    }

    @ParameterizedTest
    @EnumSource(OperatingSystem.class)
    void test3(OperatingSystem os){
        System.out.println(os);
    }

    @ParameterizedTest
    @MethodSource({"generateNumbers1","generateNumbers2"})
    void test4(int i){
        System.out.println(i);
    }

    @ParameterizedTest
    @CsvSource({
        "ankara,312",
        "istanbul-avrupa,212",
        "istanbul-anadolu,216"
    })
    void test5(String city,int code){
        System.out.println(String.format("%s: %d",city,code));
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/area-codes.csv")
    void test6(String city,int code){
        System.out.println(String.format("%s: %d",city,code));
    }

    static List<Integer> generateNumbers1(){
        return List.of(1,2,3,4,5,6,7,8,9);
    }

    static List<Integer> generateNumbers2(){
        return List.of(100,200,300,400);
    }
}
