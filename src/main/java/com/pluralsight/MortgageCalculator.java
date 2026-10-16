package com.pluralsight;

import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        // Get loan information
        double principal = getPrincipal(read);
        double annualRate = getAnnualInterestRate(read);
        int years = getLoanTerm(read);

        // Calculate monthly payment and total interest
        double monthlyPayment = calculateMonthlyPayment(principal, annualRate, years);
        double totalInterest = calculateTotalInterest(monthlyPayment, years, principal);

        // Display results
        displayResults(monthlyPayment, totalInterest);

        read.close();
    }

    // Input methods

    public static double getPrincipal(Scanner read) {
        System.out.print("Enter loan principal ($): ");
        return read.nextDouble();
    }

    // Get the annual interest rate as a percentage
    public static double getAnnualInterestRate(Scanner read) {
        System.out.print("Enter annual interest rate (%): ");
        return read.nextDouble();
    }

    // Get the loan term in years
    public static int getLoanTerm(Scanner read) {
        System.out.print("Enter loan term (years): ");
        return read.nextInt();
    }

    // Calculation methods
    public static double calculateMonthlyPayment(
            double principal, double annualRate, int years) {

        double monthlyRate = annualRate / 100.0 / 12.0;
        int numberOfPayments = years * 12;

        // Handle a zero interest loan to catch divide by zero calculation
        /*
        if (monthlyRate == 0) {
            return principal / numberOfPayments; // Return statement exits method
        }
        */

        double compoundFactor = Math.pow(1 + monthlyRate, numberOfPayments);

        return principal * (monthlyRate * compoundFactor) / (compoundFactor - 1);
    }

    public static double calculateTotalInterest(
            double monthlyPayment, int years, double principal) {

        // Number of Monthly Payments (n)
        int numberOfPayments = years * 12;

        // Total Interest = (M × n) - P
        return (monthlyPayment * numberOfPayments) - principal;
    }

    // Output method
    public static void displayResults(double monthlyPayment, double totalInterest) {
        System.out.printf("%nMonthly Payment: $%.2f%n", monthlyPayment);
        System.out.printf("Total Interest Paid: $%.2f%n", totalInterest);
    }
}
