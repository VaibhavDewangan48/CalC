package com.vaibhav;

import java.util.Scanner;
import static com.vaibhav.SciCalculator.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Shutdown Hook to handle Ctrl+C
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("\nReceived termination signal. Exiting gracefully...");
            scanner.close();
        }));

        while (true) {
            try {
                System.out.println("\nScientific Calculator - Choose an operation:");
                System.out.println("1. Square Root (√x)");
                System.out.println("2. Factorial (x!)");
                System.out.println("3. Natural Logarithm (ln(x))");
                System.out.println("4. Power Function (x^b)");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("No valid input detected. Please enter a number.");
                    scanner.next();  // Consume invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        System.out.print("Enter number: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
                            continue;
                        }
                        double num1 = scanner.nextDouble();
                        System.out.println("Result: " + squareRoot(num1));
                        break;
                    case 2:
                        System.out.print("Enter an integer: ");
                        if (!scanner.hasNextInt()) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            scanner.next();
                            continue;
                        }
                        int num2 = scanner.nextInt();
                        System.out.println("Result: " + factorial(num2));
                        break;
                    case 3:
                        System.out.print("Enter number: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
                            continue;
                        }
                        double num3 = scanner.nextDouble();
                        System.out.println("Result: " + naturalLog(num3));
                        break;
                    case 4:
                        System.out.print("Enter base: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
                            continue;
                        }
                        double base = scanner.nextDouble();

                        System.out.print("Enter exponent: ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.next();
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
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.nextLine();  // Clear the scanner buffer
            }
        }
    }
}
