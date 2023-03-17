package com.company;

public class OneToN {
    public static void main(String[] args) {
        int num = 6;
        printOneToN2(num);
    }

    private static void printOneToN(int num, int curr){
        if (curr > num) return;

        System.out.println(curr);
        printOneToN(num, curr+1);
    }

    private static void printOneToN2(int num){
        if (num == 0) return;

        printOneToN2(num-1);
        System.out.println(num);
    }
}
