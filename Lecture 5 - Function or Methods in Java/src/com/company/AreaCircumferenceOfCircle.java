package com.company;

import java.util.Scanner;

public class AreaCircumferenceOfCircle {
    public static void main(String[] args) {
        calculateAreaCircumferenceOfCircle();
    }

    private static void calculateAreaCircumferenceOfCircle() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Radius of circle : ");
        int radius = input.nextInt();

        double circumference = 2*Math.PI*radius;
        double area = Math.PI*Math.pow(radius,2);

        System.out.printf("Area : %f and Circumference : %f", area, circumference);
    }
}
