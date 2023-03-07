package com.company;

public class MissingNumber {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5,3,4,2};

        System.out.println(missingNumber(arr, n));
    }
    private static int missingNumber(int[] arr, int n){
        int sum = n*(n+1)/2;
        for (int j : arr) sum = sum - j;
        return sum;
    }
}
