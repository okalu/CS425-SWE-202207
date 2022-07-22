package edu.miu.cs.cs425.calculatorapp;

public class CalculatorApp {

    private double value;

    public CalculatorApp() {
        this.value = 0.0;
    }

    public void add(double number) {
        value += number;
    }

    public double getValue() {
        return value;
    }
}
