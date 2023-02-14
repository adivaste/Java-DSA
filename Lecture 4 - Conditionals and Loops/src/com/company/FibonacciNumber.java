package com.company;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {

        // Create scanner object to take input
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter number : ");
        int number = input.nextInt();

        // Calculate Fibonacci
        int prev = 0;
        int curr = 1;
        int fibonacciNumber;

        for (int i = 0; i < number; i++) {
            fibonacciNumber = prev;
            prev = curr;
            curr = curr + fibonacciNumber;

            System.out.print(fibonacciNumber + " ");
        }

    }
}
