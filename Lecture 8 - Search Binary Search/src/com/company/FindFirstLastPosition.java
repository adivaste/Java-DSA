package com.company;

import java.util.Arrays;

public class FindFirstLastPosition {
    public static void main(String[] args) {
        int[] arr = {8,32,32,32,32,32,48,56,56,60,72,84,92,92,93};
        int[] indices = { binarySearch(arr,92,true), binarySearch(arr,92,false)};
        System.out.println(Arrays.toString(indices));
    }
    private static int binarySearch(int[] arr, int target, boolean lookingFirst){
        int start  = 0;
        int end = arr.length - 1;

        int idxToReturn = -1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid] == target) {
                idxToReturn = mid;
                if (lookingFirst) end = mid - 1;
                else start = mid + 1;
            }
            else if(target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return idxToReturn;
    }
}
