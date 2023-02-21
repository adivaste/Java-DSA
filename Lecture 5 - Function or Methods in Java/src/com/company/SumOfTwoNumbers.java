package com.company;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        sumOfTwoNumbers();
    }

    private static void sumOfTwoNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number 1 : ");
        int num1 = input.nextInt();

        System.out.println("Enter number 2 : ");
        int num2 = input.nextInt();

        int sum = num1 + num2;
        System.out.println("Sum of two numbers : " + sum);
    }
}
