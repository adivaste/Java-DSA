package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
    private static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int currIdx = i;
            int prevIdx = currIdx-1;

            while(prevIdx>=0 && arr[prevIdx] > arr[currIdx]){
                int temp = arr[prevIdx];
                arr[prevIdx] = arr[currIdx];
                arr[currIdx] = temp;

                currIdx--;
                prevIdx = currIdx-1;
            }
        }
        return arr;
    }
}
