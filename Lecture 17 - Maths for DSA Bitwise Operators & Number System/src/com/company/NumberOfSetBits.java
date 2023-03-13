package com.company;

public class NumberOfSetBits {
    public static void main(String[] args) {
        System.out.println(noOfSetBits(1121));
    }
    private static int noOfSetBits(int num){
        int count  = 0;
        while ( num != 0){
            if ((num & 1) == 1) count++;
            num >>= 1;
        }
        return count;
    }
}
