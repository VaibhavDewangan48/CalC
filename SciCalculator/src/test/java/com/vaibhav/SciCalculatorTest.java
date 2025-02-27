package com.vaibhav;

import org.junit.jupiter.api.Test;

import static com.vaibhav.SciCalculator.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;
//import static org.junit.jupiter.api.Assertions.*;

public class SciCalculatorTest {

    @Test
    void testSquareRoot() {
        assertEquals(5.0, squareRoot(25), 0.001);
        assertThrows(IllegalArgumentException.class, () -> squareRoot(-4));
    }

    @Test
    void testFactorial() {
        assertEquals(120, factorial(5));
        assertEquals(1, factorial(0));
        assertThrows(IllegalArgumentException.class, () -> factorial(-3));
    }

    @Test
    void testNaturalLog() {
        assertEquals(0, naturalLog(1), 0.001);
        assertThrows(IllegalArgumentException.class, () -> naturalLog(0));
        assertThrows(IllegalArgumentException.class, () -> naturalLog(-1));
    }

    @Test
    void testPower() {
        assertEquals(8.0, power(2, 3), 0.001);
        assertEquals(1.0, power(5, 0), 0.001);
    }
}
