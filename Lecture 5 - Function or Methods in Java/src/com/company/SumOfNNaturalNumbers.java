package com.company;

public class SumOfNNaturalNumbers {
    public static void main(String[] args) {
        int num = 12;
        int sum = sumOfNaturalNumbers(num);
        System.out.println(sum);
    }

    private static int sumOfNaturalNumbers(int num) {
        int sum = 0;
        for (int i = 1; i <=num; i++) {
            sum += i;
        }
        return sum;
    }
}