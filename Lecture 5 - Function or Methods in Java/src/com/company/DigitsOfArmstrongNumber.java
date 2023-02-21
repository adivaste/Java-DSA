package com.company;

public class DigitsOfArmstrongNumber {
    public static void main(String[] args) {
        printDigitsOfArmstrongIfExists(370);
    }

    public static int getNumOfDigits(int number) {
        int digitCount = 0;
        while (number != 0) {
            digitCount++;
            number = number / 10;
        }
        return digitCount;
    }

    public static void printDigitsOfArmstrongIfExists(int number) {
        int digitCount = getNumOfDigits(number);
        int sum = 0;
        int copyOfInput = number;
        int secondCopyOfInput = number;


        while (copyOfInput != 0) {
            sum = sum + (int) Math.pow(copyOfInput % 10, digitCount);
            copyOfInput /= 10;
        }
        if (sum == number) {
            int copyOfDigitCount = digitCount;
            while (copyOfDigitCount > 0) {
                int firstNum = (int) secondCopyOfInput / ((int) Math.pow(10, copyOfDigitCount - 1));
                System.out.println(firstNum);
                secondCopyOfInput = secondCopyOfInput - firstNum * (int) Math.pow(10, copyOfDigitCount - 1);
                copyOfDigitCount--;
            }
        }
    }
}