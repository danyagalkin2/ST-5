package com.mycompany.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {

    // --- calc() ---

    @Test
    void testCalcSqrt4() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt9() {
        Sqrt sqrt = new Sqrt(9.0);
        assertEquals(3.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt2() {
        Sqrt sqrt = new Sqrt(2.0);
        assertEquals(Math.sqrt(2.0), sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt1() {
        Sqrt sqrt = new Sqrt(1.0);
        assertEquals(1.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrtQuarter() {
        Sqrt sqrt = new Sqrt(0.25);
        assertEquals(0.5, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt100() {
        Sqrt sqrt = new Sqrt(100.0);
        assertEquals(10.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt16() {
        Sqrt sqrt = new Sqrt(16.0);
        assertEquals(4.0, sqrt.calc(), 1e-6);
    }

    @Test
    void testCalcSqrt0point01() {
        Sqrt sqrt = new Sqrt(0.01);
        assertEquals(0.1, sqrt.calc(), 1e-6);
    }

    // --- average() ---

    @Test
    void testAverageBasic() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(3.0, sqrt.average(2.0, 4.0), 1e-9);
    }

    @Test
    void testAverageWithZero() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(5.0, sqrt.average(0.0, 10.0), 1e-9);
    }

    @Test
    void testAverageSameValues() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(7.0, sqrt.average(7.0, 7.0), 1e-9);
    }

    // --- good() ---

    @Test
    void testGoodWhenAccurate() {
        Sqrt sqrt = new Sqrt(4.0);
        assertTrue(sqrt.good(2.0, 4.0));
    }

    @Test
    void testGoodWhenNotAccurate() {
        Sqrt sqrt = new Sqrt(4.0);
        assertFalse(sqrt.good(1.0, 4.0));
    }

    // --- improve() ---

    @Test
    void testImprove() {
        Sqrt sqrt = new Sqrt(4.0);
        // improve(1.0, 4.0) = average(1.0, 4.0/1.0) = average(1.0, 4.0) = 2.5
        assertEquals(2.5, sqrt.improve(1.0, 4.0), 1e-9);
    }

    @Test
    void testImproveCloserToRoot() {
        Sqrt sqrt = new Sqrt(9.0);
        // improve(2.0, 9.0) = average(2.0, 4.5) = 3.25
        assertEquals(3.25, sqrt.improve(2.0, 9.0), 1e-9);
    }

    // --- iter() ---

    @Test
    void testIterConverges() {
        Sqrt sqrt = new Sqrt(4.0);
        assertEquals(2.0, sqrt.iter(1.0, 4.0), 1e-6);
    }

    @Test
    void testIterAlreadyGood() {
        Sqrt sqrt = new Sqrt(4.0);
        // guess=2.0 is already accurate for x=4.0
        assertEquals(2.0, sqrt.iter(2.0, 4.0), 1e-9);
    }
}
