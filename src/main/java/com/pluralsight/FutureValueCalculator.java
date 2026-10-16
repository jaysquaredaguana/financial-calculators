package com.pluralsight;

import java.util.Scanner;

public class FutureValueCalculator {
    public static void run(Scanner read) {

        // Get deposit information
        double principal = getDeposit(read);
        double annualRate = getAnnualInterestRate(read);
        int years = getYears(read);

        // Calculate future value and interest earned
        double futureValue = calculateFutureValue(principal, annualRate, years);
        double totalInterest = calculateTotalInterest(futureValue, principal);

        // Display results
        displayResults(futureValue, totalInterest);

        read.close();
    }

    // Get the initial deposit
    public static double getDeposit(Scanner read) {
        System.out.print("Enter initial deposit ($): ");
        return read.nextDouble();
    }

    // Get annual interest rate as a percentage (divide by 100 later)
    public static double getAnnualInterestRate(Scanner read) {
        System.out.print("Enter annual interest rate (%): ");
        return read.nextDouble();
    }

    // Get investment term in years
    public static int getYears(Scanner read) {
        System.out.print("Enter number of years: ");
        return read.nextInt();
    }

    // Calculate future value using daily compounding
    public static double calculateFutureValue(double principal, double annualRate, int years) {

        double dailyRate = (annualRate / 100.0) / 365.0;
        int numberOfDays = years * 365;

        return principal * Math.pow(1 + dailyRate, numberOfDays);
    }

    // Calculate total interest earned
    public static double calculateTotalInterest(double futureValue, double principal) {

        // Total Interest Earned = FV - P
        return futureValue - principal;
    }

    // Output method
    public static void displayResults(double futureValue, double totalInterest) {
        System.out.printf("%nFuture Value: $%.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%.2f%n", totalInterest);
    }
}
