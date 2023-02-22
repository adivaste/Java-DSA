package com.company;

public class LinearSearchInRange {
    public static void main(String[] args) {
        int[] arr = {12,24,36,48,60,72};
        System.out.println(linearSearchInRange(arr, 36, 0,9));
    }

    private static int linearSearchInRange(int[] arr, int target, int start, int end){
        // Checking for empty array
        if (arr.length == 0) return -1;

        // Checking for correct indexes
        if (start < 0) return -1;
        if (end >= arr.length) end = arr.length-1;

        // Checking for element within range
        for (int idx = start; idx < end; idx++) {
            if (arr[idx] == target) return idx;
        }

        // If not find then return -1
        return -1;
    }
}

