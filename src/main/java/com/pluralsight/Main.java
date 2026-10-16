package com.pluralsight;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        displayMenu();

        System.out.print("Select an option (1-4): ");
        int choice = read.nextInt();

        switch (choice) {
            case 1:
                MortgageCalculator.run(read);
                break;
            case 2:
                FutureValueCalculator.run(read);
                break;
            case 3:
                PresentValueCalculator.run(read);
                break;
            case 4:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid selection.");
        }

        read.close();
    }

    public static void displayMenu() {
        System.out.println("================================");
        System.out.println("     FINANCIAL CALCULATORS");
        System.out.println("================================");
        System.out.println("1. Mortgage Calculator");
        System.out.println("2. Future Value Calculator");
        System.out.println("3. Present Value Calculator");
        System.out.println("4. Exit");
        System.out.println("================================");
    }
}
