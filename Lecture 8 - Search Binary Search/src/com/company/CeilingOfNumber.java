package com.company;

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
        int num = 100;

        System.out.println(ceilingOfNumber(arr, num));
    }

    private static int ceilingOfNumber(int[] arr, int target) {
        int ceiling = Integer.MAX_VALUE;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid]==target) return arr[mid];
            else if(arr[mid] < target) start = mid+1;
            else {
                ceiling = arr[mid];
                end = mid-1;
            }
        }
        return ceiling;
    }

    // Ceiling : Smallest of the numbers greater than or equal to target
    private static int ceilingOfNumber2(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid]==target) return arr[mid];
            else if(arr[mid] < target) start = mid+1;
            else end = mid-1;
        }

        if (start==arr.length) return Integer.MAX_VALUE;
        return arr[start];
    }
}