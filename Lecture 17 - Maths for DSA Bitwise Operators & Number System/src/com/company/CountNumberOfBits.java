package com.company;

public class CountNumberOfBits {
    public static void main(String[] args) {
        System.out.println(countNumberOfBits3(23223,10));
    }

    // Approach 1 -  Using a right shift
    private static int countNumberOfBits(int num){
        if (num == 0) return 1;

        int count = 0;
        while(num != 0){
            count++;
            num >>= 1;
        }
        return count;
    }

    // Approach 2 - Using 2's Power
    private static int countNumberOfBits2(int num){
        int power = 1;
        while (num >= Math.pow(2,power)) power++;
        return power;
    }

    private static int countNumberOfBits3(int num, int base){
        return (int)(Math.log(num)/Math.log(base)) + 1;
    }
}
