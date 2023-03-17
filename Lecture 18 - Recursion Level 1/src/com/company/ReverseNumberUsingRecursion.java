package com.company;

public class ReverseNumberUsingRecursion {
    public static void main(String[] args) {
        int num = 8967;
        System.out.println(reverseNumberUsingRecursion2(num));
    }

    // Here we are updating our number each time in call, one number is getting divided in each
    // call, we are getting a last digit and adding it to 10th multiple of existing reverseNumber
    // so that each time number is increased in power of ten and single number is added to it.
    private static int reverseNumberUsingRecursion(int num, int reverseNum){
        // Return 0 when num is zero, as we are dividing each time.
        if (num == 0) return reverseNum;

        // ReverseNum will be updated with 10*reverseNumber and last digit of current number
        reverseNum = reverseNum*10 + num%10;

        // Passing the updated values of Number and Reverse Number
        return reverseNumberUsingRecursion(num/10, reverseNum);
    }

    private static int reverseNumberUsingRecursion2(int num){
        // Using the log10 to find the (number_of_digits-1) log(1000) = 3 which is the powered
        // with 10 each time
        int power = (int)Math.log10(num);

        return helper(num, power);
    }

    // Helper function to help original one
    private static int helper(int num, int power){
        if (num%10 == num) return num;
        return (num%10)*(int)Math.pow(10, power) + helper(num/10, power-1);
    }
}
