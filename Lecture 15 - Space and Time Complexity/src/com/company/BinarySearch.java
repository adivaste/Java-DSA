package com.company;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1,2,3,5,6,7,8,9};
        System.out.println(binarySearch(arr, 5, 0, arr.length-1));
    }

    private static int binarySearch(int[] arr, int num, int start, int end) {
        if (start>end) return -1;

        int mid = start + (end-start)/2;
        if (arr[mid] == num) return mid;
        else if (num < arr[mid]) return binarySearch(arr, num, start, mid-1);
        else return binarySearch(arr, num, mid+1, end);
    }
}
