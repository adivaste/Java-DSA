package com.company;

public class FloorOfNumberOptimal {
    public static void main(String[] args) {
        int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
        int num = 0;

        System.out.println(floorOfNumberOptimal(arr, num));
    }

    // Floor : Greatest of numbers smaller than or equal to Target
    private static int floorOfNumberOptimal(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid]==target) return arr[mid];
            else if(arr[mid] < target) start = mid+1;
            else end = mid-1;
        }
        return arr[end];
    }
}
