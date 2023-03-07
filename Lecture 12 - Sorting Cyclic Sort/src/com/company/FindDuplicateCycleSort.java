package com.company;

public class FindDuplicateCycleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,2,4};
        findDuplicateCycleSort(arr);
    }
    private static void findDuplicateCycleSort(int[] arr){
        int currIdx = 0;

        while (currIdx < arr.length){
            int correctIdx = arr[currIdx] - 1;
            if (arr[currIdx] == currIdx+1 || arr[currIdx] == arr[correctIdx]){
                currIdx++;
            }
            else{
                swap(arr, currIdx, arr[currIdx]-1);
            }
        }
        System.out.println(arr[arr.length-1]);
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
