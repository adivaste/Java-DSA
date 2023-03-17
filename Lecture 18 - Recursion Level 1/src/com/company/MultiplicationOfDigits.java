package com.company;

public class MultiplicationOfDigits {
    public static void main(String[] args) {
        int num = 34222;
        System.out.println(multiplicationOfDigits(num));
    }

    // If last digit is remaining then return digit itself
    // Don't go for 0 condition, it will be completing in noOfDigits calls.
    private static int multiplicationOfDigits(int num){
        if (num%10 == num) {
            return num;
        }
        return (num%10)*multiplicationOfDigits(num/10);
    }
}
