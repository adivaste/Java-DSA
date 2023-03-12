package com.company;

public class FactorialOfNumber {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(factorialOfNumber(num));
    }

    private static int factorialOfNumber(int num) {
        if (num < 2) return 1;
        return num*factorialOfNumber(num-1);
    }
}
