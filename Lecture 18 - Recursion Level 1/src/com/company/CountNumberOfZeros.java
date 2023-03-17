package com.company;

public class CountNumberOfZeros {
    public static void main(String[] args) {
        int num = 1100;
        System.out.println(countZeros(num));
    }

    private static int countZeros(int num) {
        if (num == 0) return 1;
        return helper(num, 0);
    }

    private static int helper(int number, int zeros){
        if (number == 0) return zeros;
        if (number%10 == 0) zeros++;

        return helper(number/10, zeros);
    }
}
