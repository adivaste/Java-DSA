package com.company;

public class NumberToTimesArrayRotated {
    public static void main(String[] args) {

    }
    private static int numberToTimesArrayRotated(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        int numOfTimesSorted = 0;

        while (start <= end){
            int mid = start + (end-start)/2;

            if( arr[mid-1] > arr[mid]) return mid;
            else if (arr[mid] > )
        }

    }
}
