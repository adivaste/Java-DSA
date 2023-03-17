package com.company;

public class BothWayNumberPrinting {
    public static void main(String[] args) {
        int num = 5;
        bothWayNumberPrinting(num);
    }

    private static void bothWayNumberPrinting(int num){
        if (num == 0) return;

        System.out.println(num);
        bothWayNumberPrinting(num-1);
        System.out.println(num);
    }
}
