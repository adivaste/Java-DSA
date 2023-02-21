package com.company;

import java.util.Scanner;

public class CheckAdult {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your age : ");
        int age = input.nextInt();
        boolean eligible = isEligibleOrNot(age);
        if (eligible) System.out.println("Eligible for vote");
        else System.out.println("Not eligible for vote");
    }

    public static boolean isEligibleOrNot(int age) {
        return age >= 18;
    }
}
