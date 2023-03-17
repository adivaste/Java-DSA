package com.company;

public class NToOne {

    public static void main(String[] args) {
        int num = 10;
        printNumbers(num);
    }

    private static void printNumbers(int num){
        // Base condition
        if (num == 0) return;

        // Printing
        System.out.println(num);

        // Calling the recursive function
        printNumbers(num-1);
    }
}
