package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void area() {
        // Setup/Fixture
        var unitCircle = new Circle(0.,0.,1.);
        // Call exercise method: area
        var area = unitCircle.area();
        // Verification
        assertAll(
            () -> assertEquals(Math.PI,area),
            () -> assertEquals(0.,unitCircle.getX()),
            () -> assertEquals(0.,unitCircle.getY()),
            () -> assertEquals(1.,unitCircle.getRadius())
        );
    }
}