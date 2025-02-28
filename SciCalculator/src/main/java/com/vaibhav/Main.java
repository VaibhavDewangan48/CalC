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

            int choice = getValidIntInput(scanner);

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    double num1 = getValidDoubleInput(scanner);
                    System.out.println("Result: " + squareRoot(num1));
                    break;
                case 2:
                    System.out.print("Enter an integer: ");
                    int num2 = getValidIntInput(scanner);
                    System.out.println("Result: " + factorial(num2));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    double num3 = getValidDoubleInput(scanner);
                    System.out.println("Result: " + naturalLog(num3));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    double base = getValidDoubleInput(scanner);
                    System.out.print("Enter exponent: ");
                    double exponent = getValidDoubleInput(scanner);
                    System.out.println("Result: " + power(base, exponent));
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }

    private static int getValidIntInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // Clear invalid input
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next(); // Clear invalid input
            }
        }
    }
}
