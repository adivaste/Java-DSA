package com.company;

public class LinearSearch {

    public static void main(String[] args) {
	    int[] arr = {23,43,67,98,12,45};
        System.out.println(linearSearch(arr, 5634));
    }

    private static int linearSearch(int[] arr, int target){
        // If array size is 0 then return -1
        if (arr.length == 0) return -1;

        // Check for each element within array for target
        for (int idx = 0; idx < arr.length; idx++) {
            int element = arr[idx];
            if (target == element) return idx;
        }

        // If no element found then return -1
        return -1;
    }
}
