package com.company;

import java.util.Scanner;

public class PrincipleRateTime {

    public static void main(String[] args) {

        // Create input object for taking input
        Scanner input = new Scanner(System.in);

        // Taking User Input
        System.out.print("Enter Principle amount : ");
        double principle = input.nextDouble();

        System.out.print("Enter Rate : ");
        double rate = input.nextDouble();

        System.out.print("Enter Time : ");
        double time = input.nextDouble();

        // Using formula
        float simpleInterest = (float)(principle*rate*time)/100;

        // Writing the output on console
        System.out.println("\nSimple Interest : " + simpleInterest) ;
    }


}
