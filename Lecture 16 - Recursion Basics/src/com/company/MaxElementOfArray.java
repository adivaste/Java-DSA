package com.company;

public class MaxElementOfArray {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,866,3,5,1};
        System.out.println(maxElementOfArray(arr, arr[0], 0));
    }
    private static int maxElementOfArray(int[] arr, int max, int idx){
        if (idx == arr.length) return max;
        max = max <= arr[idx] ? arr[idx] : max;
        return maxElementOfArray(arr, max, idx+1);
    }
}
