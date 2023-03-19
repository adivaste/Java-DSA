package com.company;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,4,5,232,2,5};
        System.out.println(linearSearch(arr, 2, 0));
        System.out.println(linearSearchRev(arr, 2, arr.length-1));
    }

    private static boolean linearSearch(int[] arr, int target, int idx){
        if (idx == arr.length) return false;
        return ((arr[idx] == target) || linearSearch(arr, target, idx+1));
    }

    private static boolean linearSearchRev(int[] arr, int target, int idx){
        if (idx == -1) return false;
        return ((arr[idx] == target) || linearSearchRev(arr, target, idx-1));
    }
}
