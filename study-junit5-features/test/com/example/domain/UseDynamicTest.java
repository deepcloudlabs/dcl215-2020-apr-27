package com.example.domain;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UseDynamicTest {

    @TestFactory // dynamic test
    //Iterator<DynamicTest>
    //Iterable<DynamicTest>
    //Stream<DynamicTest>
    Collection<DynamicTest> test1(){
        return List.of(
             DynamicTest.dynamicTest(
                     "my dynamic test #1",
                     () -> {
                         // setup/fixture
                         // call exercise method
                         // verification
                     }
             ),
             DynamicTest.dynamicTest(
                     "my dynamic test #2",
                     () -> {
                         // setup/fixture
                         // call exercise method
                         // verification
                     }
             )
        );
    }

    @TestFactory
    Stream<DynamicTest> test2(){
        return List.of(4,8,15,16,23,42).stream()
                   .map( i -> DynamicTest.dynamicTest( "test #"+i , () -> {}));
    }
}
