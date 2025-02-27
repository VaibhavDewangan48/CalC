package com.vaibhav;

public class SciCalculator {

    // Function for Square Root
    public static double squareRoot(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number.");
        }
        return Math.sqrt(x);
    }

    // Function for Factorial
    public static long factorial(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("Factorial of negative numbers is not defined.");
        }
        long fact = 1;
        for (int i = 1; i <= x; i++) {
            fact *= i;
        }
        return fact;
    }

    // Function for Natural Logarithm
    public static double naturalLog(double x) {
        if (x <= 0) {
            throw new IllegalArgumentException("Logarithm of non-positive numbers is undefined.");
        }
        return Math.log(x);
    }

    // Function for Power
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
}
