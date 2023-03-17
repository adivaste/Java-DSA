package com.company;

public class Concept {
    public static void main(String[] args) {
        int num = 5;
        fun(num);
    }

    // Stack overflow : First calling then subtraction [Wrong Way]
    private static void fun(int num){
        if (num == 0) return;
        System.out.println(num);
        fun(num--);
    }

    // Correct way : First subtraction is done then calling
    private static void fun2(int num){
        if (num == 0) return;
        System.out.println(num);
        fun(--num);
    }
}
