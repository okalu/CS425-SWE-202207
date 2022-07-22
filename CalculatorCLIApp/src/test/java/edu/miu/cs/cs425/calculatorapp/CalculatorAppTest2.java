package edu.miu.cs.cs425.calculatorapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorAppTest2 {
    private CalculatorApp calculatorApp;

    @Before
    public void setUp() throws Exception {
        this.calculatorApp = new CalculatorApp();
    }

    @After
    public void tearDown() throws Exception {
        this.calculatorApp = null;
    }

    @Test
    public void testAddNegative() {
        calculatorApp.add(-23.255);
        assertEquals("Adding negative is not working",
                -23.255, calculatorApp.getValue(), 0.0000001);
    }

    @Test
    public void getValue() {
        double actual = calculatorApp.getValue();
        double expected = 0.0;
        assertEquals("GetValue is not working correctly",
                expected, actual, 0.0000001);
    }
}