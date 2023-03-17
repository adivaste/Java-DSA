package com.company;

public class Palindrome {
    public static void main(String[] args) {
        int num = 1213;
        System.out.println(isPalindrome(num));
    }
    private static boolean isPalindrome(int num){
        int power = (int)Math.log10(num);
        int reverseNumber =  helper(num, power);
        return (reverseNumber == num);
    }

    // Helper function to help original one
    private static int helper(int num, int power){
        if (num%10 == num) return num;
        return (num%10)*(int)Math.pow(10, power) + helper(num/10, power-1);
    }
}
