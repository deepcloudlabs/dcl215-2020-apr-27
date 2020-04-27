package com.example.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@DisplayName("A stack")
public class StackTest {

    @Test
    @DisplayName("is instantiated with new operator")
    void isStackInstantiatedWithNewOperator() {
    }

    @Nested
    @DisplayName("When new stack")
    class WhenNew {
        @DisplayName("is empty")
        @Test
        void isEmpty() {
        }

        @DisplayName("throws EmptyStackException when popped")
        @Test
        void throwsExceptionWhenPopped() {
        }

        @DisplayName("throws EmptyStackException when peeked")
        @Test
        void throwsExceptionWhenPeeked() {
        }
    }

    @DisplayName("after pushing one element")
    @Nested
    class AfterPushing {

        @DisplayName("is not empty")
        @Test
        void notEmpty() {
        }
    }
}
