package com.company;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,4,1,2,1,3,2,1};
        System.out.println(Arrays.toString(mergeSort(arr)));
    }
    private static int[] mergeSort(int[] arr){
        // If single element exists then return array
        if (arr.length == 1) return arr;

        // Finding the mid of array
        int mid = arr.length/2;

        // Get the sorted part's of array for merging
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        // Merging the two sub arrays
        return merge(left, right);
    }


    // Merge Function
    private static int[] merge(int[] left, int[] right) {

        // Create array to store the elements
        int[] sorted = new int[left.length + right.length];

        // Create variable to keep track of elements of each array
        // i = left , j = right, k = sorted
        int i = 0;
        int j = 0;
        int k = 0;

        // Continue the loop till any of the pointer reaches last
        // if any reaches the last then quit, so all the remaining elements
        // can be added directly without any comparison
        while ( i < left.length && j < right.length ){
            if (left[i] < right[j]){
                sorted[k] = left[i];
                i++;
            }
            else{
                sorted[k] = right[j];
                j++;
            }
            k++;
        }

        // If left has some elements not inserted in sorted array insert it
        while (i < left.length){
            sorted[k] = left[i];
            i++; k++;
        }

        // If right has some elements not inserted in sorted array insert it
        while (j < right.length){
            sorted[k] = right[j];
            j++; k++;
        }

        // Return the sorted array to previous level each time
        return sorted;
    }
}
