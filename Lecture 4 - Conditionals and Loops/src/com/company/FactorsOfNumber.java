package com.company;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int number = 60;
        Solution(number);
    }

    private static void Solution(int number) {
        for (int i=1; i<Math.sqrt(number); i++){
            if (number%i == 0) System.out.printf("%d %d ", i, number/i);
        }
    }
}
