package com.company;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2};
        System.out.println(Arrays.toString(cycleSort(arr)));
    }
    private static int[] cycleSort(int[] arr){
        int currIdx = 0;

        while (currIdx < arr.length){
            if(arr[currIdx] == currIdx+1) currIdx++;
            else{
                int currValue = arr[currIdx];

                int temp = arr[currValue-1];
                arr[currValue-1] = currValue;
                arr[currIdx] = temp;
            }
        }
        return arr;
    }
}
