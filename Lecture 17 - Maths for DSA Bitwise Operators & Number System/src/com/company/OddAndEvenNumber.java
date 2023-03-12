package com.company;

public class OddAndEvenNumber {
    public static void main(String[] args) {
        System.out.println(isOdd2(101));
        System.out.println(isEven2(101));
    }

    private static boolean isOdd(int num) {
        int lsb = num % 2;
        return lsb == 1;
    }

    private static boolean isEven(int num) {
        int lsb = num % 2;
        return lsb == 0;
    }

    private static boolean isOdd2(int num) {
        return (num & 1) == 1;
    }

    private static boolean isEven2(int num) {
        return (num & 1) == 0;
    }
}