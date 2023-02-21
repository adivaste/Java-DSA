package com.company;

import java.util.Scanner;

public class CheckOddOrEven {
    public static void main(String[] args) {

        // Scanner object to take input
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number : ");
        int number = input.nextInt();

        // Calling the created function
        isEvenOrOdd(number);

        // Bitwise operations
        isEvenOrOddUsingBitwise(number);

        // LSB
        isEvenOrOddUsingLSB(number);
    }

    private static void isEvenOrOdd(int number){
        if (number%2 == 0){
            System.out.println("Number is even");
            return;
        }
        System.out.println("Number is odd");
    }

    private static void isEvenOrOddUsingBitwise(int number){
        // Using OR operation
        if ((number | 1) > number) System.out.println("Even Number (OR)");
        else if ((number | 1) == number ) System.out.println("Odd Number (OR)");

        // Using AND operation
        if ((number & 1) == 0) System.out.println("Even Number (AND)");
        else if ((number & 1) == 1) System.out.println("Odd Number (AND)");

        // Using XOR operation
        if ((number ^ 1) == number+1) System.out.println("Even Number (XOR)");
        else if ((number ^ 1) == number-1) System.out.println("Odd Number (XOR)");
    }

    private static void isEvenOrOddUsingLSB(int number){
        if (Integer.toBinaryString(number).endsWith("0")) {
            System.out.println("Number is even");
        }
        else if(Integer.toBinaryString(number).endsWith("1")){
                System.out.println("Odd");
            }
        }
}
