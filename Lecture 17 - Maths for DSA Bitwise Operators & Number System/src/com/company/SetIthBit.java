package com.company;

public class SetIthBit {
    public static void main(String[] args) {
        // Set the bit => 0 -> 1
        int num = 8;
        int i = 2;
        System.out.println(setIthBit(num,i));
    }
    private static int setIthBit(int num, int i){
        // Creating the mask of 1 and 0's using left shift, of ith bit.
        int mask = 1 << i-1;
        // Returning the "num" OR with "mask"
        return (num | mask);
    }
}
