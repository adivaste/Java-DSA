package com.company;

import java.util.Arrays;

public class MergeSortInPlace {

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSortInPlace(arr,0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    private static void mergeSortInPlace(int[] arr, int start, int end){
        // If single element exists then return array
        if ((end-start) == 1) return;

        // Finding the mid of array
        int mid = (start+end)/2;

        // Get the sorted part's of array for merging
        mergeSortInPlace(arr, 0, mid);
        mergeSortInPlace(arr, mid, end);

        // Merging the two sub arrays
        merge(arr, start, mid, end);
    }


    // Merge Function
    private static void merge(int[] arr, int start, int mid, int end) {

        // Create array to store the elements
        int[] sorted = new int[end-start];

        // Create variable to keep track of elements of each array
        // i = left , j = right, k = sorted
        int i = start;
        int j = mid;
        int k = 0;

        // Continue the loop till any of the pointer reaches last
        // if any reaches the last then quit, so all the remaining elements
        // can be added directly without any comparison
        while ( i < mid && j < end ){
            if (arr[i] < arr[j]){
                sorted[k] = arr[i];
                i++;
            }
            else{
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }

        // If left has some elements not inserted in sorted array insert it
        while (i < mid){
            sorted[k] = arr[i];
            i++; k++;
        }

        // If right has some elements not inserted in sorted array insert it
        while (j < end){
            sorted[k] = arr[j];
            j++; k++;
        }

        // Return the sorted array to previous level each time
        for (int l = 0; l < sorted.length; l++) {
            arr[start+l] = sorted[l];
        }
    }
}
