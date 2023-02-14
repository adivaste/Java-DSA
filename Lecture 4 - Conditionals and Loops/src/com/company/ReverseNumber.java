package com.company;

import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {

        // Create object of scanner to take input
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the number : ");
        int number = input.nextInt();

        // Calculate reverse
        int reverseNumber = 0;
        while (number != 0){
            reverseNumber = reverseNumber*10 + number%10;
            number = number/10;
        }

        System.out.print("Reverse Number : " + reverseNumber);
    }
}