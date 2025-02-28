package com.vaibhav;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.vaibhav.SciCalculator.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nScientific Calculator - Choose an operation:");
            System.out.println("1. Square Root (√x)");
            System.out.println("2. Factorial (x!)");
            System.out.println("3. Natural Logarithm (ln(x))");
            System.out.println("4. Power Function (x^b)");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1-5.");
                scanner.next(); // Clear invalid input
                continue;
            }
            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        double num1 = scanner.nextDouble();
                        System.out.println("Result: " + squareRoot(num1));
                        break;
                    case 2:
                        System.out.print("Enter an integer: ");
                        int num2 = scanner.nextInt();
                        System.out.println("Result: " + factorial(num2));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        double num3 = scanner.nextDouble();
                        System.out.println("Result: " + naturalLog(num3));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        double base = scanner.nextDouble();
                        System.out.print("Enter exponent: ");
                        double exponent = scanner.nextDouble();
                        System.out.println("Result: " + power(base, exponent));
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice, try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
