package com.company;

public class MountainArray {
    public static void main(String[] args) {

        int[] arr = {3,5,3,2,0};
        System.out.println(mountainSearch(arr));
    }

    private static int mountainSearch(int[] arr){

        int start = 0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if (arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
            else if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) start = mid;
            else end = mid;
        }
        return -1;
    }
}
