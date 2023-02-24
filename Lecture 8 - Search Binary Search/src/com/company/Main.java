package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {2,3,43,45,67,78,79,84,94};
        System.out.println(binarySearch(arr, 34));
    }

    private static int binarySearch(int[] arr, int target){
        // Declare initial variables
        int start = 0;
        int end = arr.length - 1;

        // Continue the loop until start<=end
        while(start <= end){
            // Assign mid = half of sum of indexes, to avoid data type memory limitations we used new formula
            int mid = start + (end-start)/2;

            // Check for three conditions
            if (arr[mid] == target){
                start = mid + 1;
            }
            else if( arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        // If not found finally return -1
        return -1;
    }
}
