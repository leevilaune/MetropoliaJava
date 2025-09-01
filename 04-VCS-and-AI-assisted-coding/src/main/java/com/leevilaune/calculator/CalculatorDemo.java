package com.leevilaune.calculator;

/**
 * Demonstration of the Calculator class functionality.
 */
public class CalculatorDemo {
    public static void main(String[] args) {
        demonstrateCalculator();
    }

    private static void demonstrateCalculator() {
        Calculator calculator = new Calculator();

        // Demonstrate basic addition
        System.out.println("Starting value: " + calculator.getTotal());

        calculator.add(5);
        System.out.println("After adding 5: " + calculator.getTotal());

        calculator.add(10);
        System.out.println("After adding 10: " + calculator.getTotal());

        // Demonstrate reset functionality
        calculator.reset();
        System.out.println("After reset: " + calculator.getTotal());

        // Demonstrate error handling
        try {
            calculator.add(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly caught error: " + e.getMessage());
        }

        // Show calculator still works after error
        calculator.add(7);
        System.out.println("Final value: " + calculator.getTotal());
    }
}
