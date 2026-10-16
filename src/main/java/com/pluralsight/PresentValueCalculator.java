package com.pluralsight;

import java.util.Scanner;

public class PresentValueCalculator {
    public static void run(Scanner read) {

        // Get annuity information
        double monthlyPayout = getMonthlyPayout(read);
        double annualRate = getAnnualInterestRate(read);
        int years = getYears(read);

        // Calculate present value
        double presentValue = calculatePresentValue(monthlyPayout, annualRate, years);

        // Display result
        displayResult(presentValue);

        read.close();
    }

    // Get monthly payout amount
    public static double getMonthlyPayout(Scanner read) {
        System.out.print("Enter monthly payout ($): ");
        return read.nextDouble();
    }

    // Get annual interest rate as a percentage
    public static double getAnnualInterestRate(Scanner read) {
        System.out.print("Enter annual interest rate (%): ");
        return read.nextDouble();
    }

    // Get payout duration in years
    public static int getYears(Scanner read) {
        System.out.print("Enter number of years: ");
        return read.nextInt();
    }

    // Calculate present value of an ordinary annuity
    public static double calculatePresentValue(
            double monthlyPayout, double annualRate, int years) {

        double monthlyRate = (annualRate / 100.0) / 12.0;
        int numberOfPayments = years * 12;

        // Handle zero interest
        /*
        if (monthlyRate == 0) {
            return monthlyPayout * numberOfPayments;
        }
        */

        double discountFactor = Math.pow(1 + monthlyRate, -numberOfPayments);

        return monthlyPayout * (1 - discountFactor) / monthlyRate;
    }

    // Output method
    public static void displayResult(double presentValue) {
        System.out.printf("%nPresent Value: $%.2f%n", presentValue);
    }
}
