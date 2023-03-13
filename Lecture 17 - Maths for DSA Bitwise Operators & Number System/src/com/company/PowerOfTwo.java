package com.company;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(powerOfTwo2(3));
    }
    private static boolean powerOfTwo(int number){
        int mask = (int)Math.pow(2, (int)(Math.log(number)/Math.log(2)));
        System.out.println(mask);
        return (number & mask) == number;
    }

    private static boolean powerOfTwo2(int number){
        return ((number & number-1) == 0);
    }
}
