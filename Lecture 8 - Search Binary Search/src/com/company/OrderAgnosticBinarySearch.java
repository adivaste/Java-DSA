package com.company;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
        int[] arr = {78,67,56,45,34,23,12};
        System.out.println(orderAgnosticBinarySearch(arr, 67));
    }

    private static int orderAgnosticBinarySearch(int[] arr, int target) {
        if (arr.length == 0) return -1;

        boolean isAscending = false;
        if (arr[0] <= arr[arr.length-1]) isAscending = true;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target){
                return mid;
            }

            if (isAscending){
                if( arr[mid] > target){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
            else{
                if( arr[mid] > target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}
