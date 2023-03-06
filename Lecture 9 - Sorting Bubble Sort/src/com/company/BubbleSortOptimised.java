package com.company;

import java.util.Arrays;

public class BubbleSortOptimised {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSortOptimised(arr)));
    }
    private static int[] bubbleSortOptimised(int[] arr){
        // To check total comparisons occurring in algo.
        int comparisons = 0;
        // To check are elements actually swapped in prev iteration or not
        boolean swapped = true;

        // Looping arr.length-1 time and checking swapped condition, which makes
        // arr.length-1 passes and check in previous iteration are elements are swapped
        // or not if not then terminate the loop
        for (int i=0; i<arr.length-1 && swapped; i++){
            // When we enter for checking, first make flag it as false, so when any comparison
            // occurs then it will be true, if not then always false and in next iteration loop
            // terminates
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                comparisons++;
                // Swap if prev element is larger than current ones
                if (arr[j-1] > arr[j]){
                    // Swapping the numbers
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    // Modifying the flag
                    swapped = true;
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