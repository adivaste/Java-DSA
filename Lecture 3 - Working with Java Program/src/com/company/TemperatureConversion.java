package com.company;

import java.util.Scanner;

public class TemperatureConversion {
    public static void main(String[] args) {

        // Creating the scanner class for taking Input
        Scanner input = new Scanner(System.in);

        // Taking the input from user
        System.out.print("\n 1. Celsius to Fahrenheit \n 2. Fahrenheit to Celsius \n\nChoose mode of conversion : ");
        int choice = input.nextInt();

        // Checking User Input and making decision based on it
        if (choice == 1){
            System.out.print("* Enter Temp. In Celsius : ");
            double cel = input.nextDouble();
            float tempInFahre = (float) celToFahre(cel);
            System.out.println("* Temp. In Fahrenheit is : " + tempInFahre);
        }
        else if (choice == 2){
            System.out.print("* Enter Temp. In Fahrenheit : ");
            double fahre = input.nextDouble();
            float tempInCel = (float)fahreToCel(fahre);
            System.out.println("* Temp. In Celsius is : " + tempInCel);
        }
        else{
            System.out.println("\n* Please choose correct option !!");
        }
    }

    private static double fahreToCel(double fahre) {
        return (fahre - 32)*5/9;
    }

    private static double celToFahre(double cel) {
        return (cel + 32)*9/5;
    }
}
