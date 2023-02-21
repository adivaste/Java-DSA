package com.company;

import java.util.Scanner;

public class PrimeNumsBetweenTwoNums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number 1 : ");
        int num1 = input.nextInt();
        System.out.print("Enter the number 2 : ");
        int num2 = input.nextInt();

        printPrimeNumbers(num1, num2);
    }

    private static boolean isItPrime(int num){
        int i = 2;
        while(i*i <= num){
            if (num%i == 0) return false;
            i++;
        }
        return true;
    }

    private static void printPrimeNumbers(int num1, int num2) {
        for (int i = num1; i <= num2; i++) {
            if (isItPrime(i)) System.out.print(i + " ");
        }
    }
}