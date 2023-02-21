package com.company;

import java.util.Scanner;

public class CheckNumberPalindrome {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your number : ");
        int number = input.nextInt();

        if (isPalindrome(number)) System.out.println("Number is palindrome");
        else System.out.println("Not palindrome");
    }

    private static int getNoOfDigits(int num){
        int count = 0;
        while(num > 0){
            count++;
            num = num/10;
        }
        return count;
    }

    private static int getReverse(int num){
        int digitCount = getNoOfDigits(num);
        int power = digitCount - 1;

        int reverse = 0;
        while(num > 0){
            reverse = reverse + (int)((num%10)*Math.pow(10,power));
            num = num/10;
            power--;
        }

        return reverse;
    }

    private static boolean isPalindrome(int num){
        int reverseNum = getReverse(num);
        return reverseNum == num;
    }
}
