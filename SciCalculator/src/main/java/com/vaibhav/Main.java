package com.vaibhav;
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

            // **Prevent crash by checking input validity**
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter number: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    double num1 = scanner.nextDouble();
                    System.out.println("Result: " + squareRoot(num1));
                    break;
                case 2:
                    System.out.print("Enter an integer: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    int num2 = scanner.nextInt();
                    System.out.println("Result: " + factorial(num2));
                    break;
                case 3:
                    System.out.print("Enter number: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    double num3 = scanner.nextDouble();
                    System.out.println("Result: " + naturalLog(num3));
                    break;
                case 4:
                    System.out.print("Enter base: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
                    double base = scanner.nextDouble();
                    System.out.print("Enter exponent: ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                        continue;
                    }
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
        }
    }
}
