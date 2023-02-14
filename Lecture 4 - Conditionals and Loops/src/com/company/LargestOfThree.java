package com.company;

import java.util.Scanner;

public class LargestOfThree {
    public static void main(String[] args) {

        // Create input object for taking input
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter num1 : ");
        int num1 = input.nextInt();
        System.out.print("Enter num2 : ");
        int num2 = input.nextInt();
        System.out.print("Enter num3 : ");
        int num3 = input.nextInt();

        int largest = num1;
        if (num2 >= largest){
            largest = num2;
        }
        if (num3 >= largest){
            largest = num3;
        }

        // Print out the output
        System.out.println("Largest number : " + largest);
    }
}
