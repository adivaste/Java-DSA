package com.company;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your Number : ");
        int number = input.nextInt();
        long f = factorial(number);
        System.out.printf("Factorial of %d is %d", number, f);
    }

    private static long factorial(int number) {
        long factorial = 1;
        for (int i=1; i<=number; i++){
            factorial = factorial*i;
        }
        return factorial;
    }
}
