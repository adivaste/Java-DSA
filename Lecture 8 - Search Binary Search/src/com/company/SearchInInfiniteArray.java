package com.company;

public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9,13,45,56,58,67,78,89,101,1233,3232,34455,37332,67766,68564,72232};
        int target = 37332;

        int start = 0;
        int end = 1;
        while (target > arr[end]){
            start = end+1;
            end = end*2;
        }
        System.out.println(binarySearch(arr, target, start, end));
    }

    private static int binarySearch(int[] arr, int target, int start, int end){

        while(start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target) return mid;
            else if( arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }
}
