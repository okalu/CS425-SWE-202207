package edu.miu.cs.cs425.calculatorapp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class CalculatorAppTest {
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
    public void testAddZero() {
        calculatorApp.add(0.0);
//        assertEquals("Adding zero is not working correctly",
//                0.0, calculatorApp.getValue(), 0.0000001);
        assertThat(calculatorApp.getValue(), equalTo(0.0));
    }

    @Test
    public void testAddPositive() {
        calculatorApp.add(23.255);
        assertEquals("Adding positive is not working correctly",
                23.255, calculatorApp.getValue(), 0.0000001);
    }
}