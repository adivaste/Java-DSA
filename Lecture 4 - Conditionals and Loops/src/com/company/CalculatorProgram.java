package com.company;

import java.util.Scanner;

public class CalculatorProgram {
    public static void main(String[] args) {

        // Create scanner object for input
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter Operation type : ");
        char op = input.next().trim().charAt(0);
        if ((op == '+') || op == '-' || op == '*' || op == '/' || op == '^' || op == '%'){
            System.out.print("Enter Num 1 : ");
            int num1 = input.nextInt();
            System.out.print("Enter Num 2 : ");
            int num2 = input.nextInt();

            if (op == '+') System.out.println("Addition : " + sum(num1, num2));
            else if (op == '-') System.out.println("Subtraction : " + sub(num1, num2));
            else if (op == '*') System.out.println("Multiplication : " + mul(num1, num2));
            else if (op == '/') System.out.println("Division : " + div(num1, num2));
            else if (op == '%') System.out.println("Remainder : " + rem(num1, num2));
        }
        else{
            System.out.println("Enter valid operation !");
        }
    }

    private static int sum(int num1, int num2) {
        return num1+num2;
    }
    private static int sub(int num1, int num2) {
        return num1-num2;
    }
    private static int mul(int num1, int num2) {
        return num1*num2;
    }
    private static int div(int num1, int num2) {
        return num1/num2;
    }
    private static int rem(int num1, int num2) {
        return num1%num2;
    }
}
