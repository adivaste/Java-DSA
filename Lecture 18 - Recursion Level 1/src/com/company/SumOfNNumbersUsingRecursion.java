package com.company;

public class SumOfNNumbersUsingRecursion {
    public static void main(String[] args) {
        int num = 0;
        System.out.println(sumOfNNumbersUsingRecursion(num));
    }

    private static int sumOfNNumbersUsingRecursion(int num){
        if (num <= 1) return num;
        return num + sumOfNNumbersUsingRecursion(num-1);
    }
}