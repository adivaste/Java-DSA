package com.company;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,1,1,5,5,7,-2,-4,-5};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }
    private static int[] selectionSort(int[] arr){
        int comparisons = 0;

        // Selecting each index and filling that index with its proper element
        for (int i = 0; i < arr.length-1; i++) {
            // Which index has to replace
            int idxToReplace = i;
            // By Which index has to replace
            int idxToReplaceBy = i;
            // Storing Comparisons

            // Finding the minimum element of the array and storing its index.
            for (int j = i; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[idxToReplaceBy]){
                    idxToReplaceBy = j;
                }
            }

            // Swapping the numbers
            int temp = arr[idxToReplace];
            arr[idxToReplace] = arr[idxToReplaceBy];
            arr[idxToReplaceBy] = temp;
        }
        // Returning the sorted array
        System.out.println(comparisons);
        return arr;
    }
}
