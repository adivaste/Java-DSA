package com.company;

public class FibonacciNumber {
    public static void main(String[] args) {
        int num = fibonacciNumber(6);
        System.out.println(num);
    }
    private static int fibonacciNumber(int num){
        if (num<2) return num;
        return fibonacciNumber(num-1) + fibonacciNumber(num-2);
    }
}