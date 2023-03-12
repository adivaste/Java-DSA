package com.company;

public class ResetIthBit {
    public static void main(String[] args) {
        int num = 1;
        int i = 1;
        System.out.println(resetIthBit(num,i));
    }

    private static int resetIthBit(int num, int i) {
        int mask = 1 << i-1;
        int compliment = ~mask;
        return num & compliment;
    }

}
