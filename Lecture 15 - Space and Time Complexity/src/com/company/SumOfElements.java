package com.company;

public class SumOfElements {
    public static void main(String[] args) {
        int[] arr = {8};
        System.out.println(sumOfElements(arr, 0, 0));

    }
    private static int sumOfElements(int arr[], int sum, int idx){
        if (idx == arr.length) return sum;
        return arr[idx] + sumOfElements(arr, sum,idx+1);
    }
}
