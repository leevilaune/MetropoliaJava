package com.leevilaune.calculator;

/**
 * A simple calculator that handles positive integer arithmetic operations.
 * This calculator maintains a running total and supports basic operations.
 */
public final class Calculator {
    private int total;

    /**
     * Creates a new Calculator instance initialized to zero.
     */
    public Calculator() {
        this.total = 0;
    }

    /**
     * Resets the calculator's total to zero.
     */
    public void reset() {
        this.total = 0;
    }

    /**
     * Adds a positive integer to the calculator's total.
     *
     * @param number the positive integer to add
     * @throws IllegalArgumentException if the number is negative
     */
    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Cannot add negative numbers: " + number);
        }
        this.total += number;
    }

    /**
     * Returns the current total value of the calculator.
     *
     * @return the current total
     */
    public int getTotal() {
        return this.total;
    }
}
