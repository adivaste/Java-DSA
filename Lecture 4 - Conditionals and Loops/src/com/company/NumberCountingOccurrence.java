package com.company;

import java.util.Scanner;

public class NumberCountingOccurrence {
    public static void main(String[] args) {

        // Create scanner object to take input
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter Number : ");
        int number = input.nextInt();
        System.out.print("Check for : ");
        int checkFor = input.nextInt();

        // Calculating the occurrences
        // Algo  :
        //      1. Divide the number
        //      2. Get remainder and check condition
        //      3. Update number

        int count = 0;
        while (number != 0){
            if ( number%10 == checkFor ) count++;
            number = number/10;
        }

        // Printing out results
        System.out.printf("Occurrence of %d is %d times in given number", checkFor, count);

    }
}
