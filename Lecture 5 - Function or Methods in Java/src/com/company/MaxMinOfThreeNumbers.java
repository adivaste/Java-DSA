// Problem: Write a Program to find the Maximum and Minimum of the Given Three Numbers.
// Read more: https://www.java67.com/2019/05/how-to-find-largest-and-smallest-of-three-numbers-in-java.html#ixzz7twDvuQ2V
package com.company;

import java.util.Scanner;

public class MaxMinOfThreeNumbers {
    public static void main(String[] args) {

        // Define the three numbers
        int num1;
        int num2;
        int num3;

        // Scanner object to take the input from the user.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number 1: ");
        num1 = input.nextInt();
        System.out.print("Enter number 2: ");
        num2 = input.nextInt();
        System.out.print("Enter number 3: ");
        num3 = input.nextInt();

        int maximum = maxOfThreeNums(num1,num2,num3);
        int minimum = minOfThreeNums(num1,num2,num3);

        System.out.printf("* Maximum of %d %d %d : %d \n", num1,num2,num3,maximum );
        System.out.printf("* Minimum of %d %d %d : %d \n", num1,num2,num3,minimum );

        // CLosing the scanner class
        input.close();
    }

    private static int maxOfThreeNums(int num1, int num2, int num3){
        int max = num1;
        if (num2 >= max) max = num2;
        if (num3 >= max) max = num3;

        return max;
    }
    private static int minOfThreeNums(int num1, int num2, int num3){
        int min = num1;
        if (num2 <= min) min = num2;
        if (num3 <= min) min = num3;

        return min;
    }
}
