package com.company;

public class MissingNumberUsingCycleSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,0,2,5};
        int n = 6;

        System.out.println(missingNumberUsingCycleSort(arr, n));
    }
    private static int missingNumberUsingCycleSort(int[] arr, int end){
        int missingNumberIndex = end;  // missingNumberIndex = arr.length
        int currIdx = 0;

        while (currIdx < arr.length){

            if (arr[currIdx] == arr.length){
                missingNumberIndex = currIdx;
                currIdx++;
            }
            else if (arr[currIdx] == currIdx){
                currIdx++;
            }
            else{
                int value = arr[currIdx];
                swap(arr,currIdx,value);
            }
        }

        return arr[missingNumberIndex];
    }

    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
