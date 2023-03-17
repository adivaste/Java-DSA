package com.company;

public class FactorialUsingRecursion {
    public static void main(String[] args) {
        int num = 6;
        System.out.println(factorialUsingRecursion(num));
    }
    private static int factorialUsingRecursion(int n){
        if (n <= 1) return 1;
        return n*factorialUsingRecursion(n-1);
    }
}
