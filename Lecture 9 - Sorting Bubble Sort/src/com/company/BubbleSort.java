package com.company;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    private static int[] bubbleSort(int[] arr){
        int comparisons = 0;
        for (int i=0; i<arr.length-1; i++){
            for (int j = 1; j < arr.length-i; j++) {
                comparisons++;
                if (arr[j-1] > arr[j]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // Print comparisons and return
        System.out.println("Comparisons : " + comparisons);
        return arr;
    }
}

// Total Number of comparisons will be equal to = Sum of arr.length-1 natural numbers.
// Time = O(n^2)
// Space = O(1)