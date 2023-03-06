package com.company;

import java.util.Arrays;

public class BubbleSortBruteforce {

    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2,0};
        System.out.println(Arrays.toString(bubbleSortBruteforce(arr)));
    }
    private static int[] bubbleSortBruteforce(int[] arr){
        for (int i=0; i<arr.length-1; i++){
            for (int j = 1; j < arr.length; j++) {

                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
