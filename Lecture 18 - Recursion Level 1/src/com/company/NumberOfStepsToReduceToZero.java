package com.company;

public class NumberOfStepsToReduceToZero {
    public static void main(String[] args) {
        int num = 123;
        System.out.println(numberOfStepsToReduceToZero(num, 0));
    }

    // Simple counting the steps per each call.
    private static int numberOfStepsToReduceToZero(int num, int steps){
        if (num == 0) return steps;
        if((num&1) == 0) return numberOfStepsToReduceToZero(num/2,++steps);
        else return numberOfStepsToReduceToZero(num-1,++steps);
    }
}