package com.company;

public class FloorOfNumber {
    public static void main(String[] args) {
        int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
        int num = 100;

        System.out.println(floorOfNumber(arr, num));
    }

    private static int floorOfNumber(int[] arr, int target) {
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
}
