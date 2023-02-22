package com.company;

public class MinimumNumber {
    public static void main(String[] args) {
        int[] arr = {61,27,32,47,5,6,23,232,23};
        System.out.println(findMinimum(arr));
    }

    private static int findMinimum(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < min) min = j;
        }
        return min;
    }
}