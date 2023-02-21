package com.company;

public class PythagoreanTriplet {
    public static void main(String[] args) {
        if (isPythagoreanTriplet(3,4,7)) System.out.println("This is pythagorean triplet");
        else System.out.println("Not pythagorean triplet");
    }

    private static int getMax(int num1,int num2, int num3){
        int max = num1;
        if (max < num2) max = num2;
        if (max < num3) max = num3;
        return max;
    }

    private static boolean isPythagoreanTriplet(int num1, int num2, int num3){
        int max = getMax(num1, num2, num3);
        if (num1 == max){
            return (num2*num2 + num3*num3 == num1*num1);
        }
        else if (num2 == max){
            return (num1*num1 + num3*num3 == num2*num2);
        }
        else {
            return (num2*num2 + num1*num1 == num3*num3);
        }
    }
}
