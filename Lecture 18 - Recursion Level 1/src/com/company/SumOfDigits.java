package com.company;

public class SumOfDigits {
    public static void main(String[] args) {
        int num = 10;
        int sum = 0;
        System.out.println(sumOfDigits(num,sum));
    }

    private static int sumOfDigits(int num, int sum){
        if (num == 0) return 0;

        int lastDigit = num%10;
        return lastDigit + sumOfDigits(num/10, sum);
    }
}
