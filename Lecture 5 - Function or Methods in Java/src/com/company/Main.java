package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(sum(1,2));

        int a = 5;
        int b = a;
        b = 25;
        System.out.println(a);
        System.out.println(b);
    }
    
    public static int sum(int num1, int num2){
        int sum;
        sum = num1 + num2;
        return sum;
    }
}
