package com.company;

public class ArmstrongNumber {
    public static void main(String[] args) {
        for (int i = 0; i <10000; i++) {
            if (isArmstrongNumber3Digit(i)) System.out.println(i);
        }
    }
    public static int getNumOfDigits(int number){
        int digitCount = 0;
        while(number != 0){
            digitCount++;
            number = number/10;
        }
        return digitCount;
    }
    public static boolean isArmstrongNumber3Digit(int number){
        // Armstrong number : Sum of the digits powered to number of digit in numbers equal to number itself.
        int sum = 0;
        int tempNum = number;
        int digitCount = getNumOfDigits(number);

        while (tempNum != 0 ){
            sum = sum + (int)Math.pow(tempNum%10, digitCount);
            tempNum = tempNum/10;
        }
        return sum == number;
    }
}
