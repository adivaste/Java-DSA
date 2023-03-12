package com.company;

public class IthBitOfNumber {
    public static void main(String[] args) {
        int num = 4;
        int i = 1;
        System.out.println(findIthBitOfNumber2(num,i));
    }
    private static int findIthBitOfNumber(int num, int i){
        int numberToAndWith = (int) Math.pow(2,i-1);
        return ((num & numberToAndWith) == numberToAndWith) ? 1 : 0 ;
    }

    private static int findIthBitOfNumber2(int num, int i){
        // Creating the mask where 1 will be placed at ith index, by shifting
        // it by n-1 digits to left
        int mask = 1 << i-1;
        return (num & mask) == mask ? 1  : 0;
    }
}
