package com.company;

import java.util.Arrays;

public class CycleSortBruteForce {

    public static void main(String[] args) {
	    int[] arr = {5,1,3,4,2};
        System.out.println(Arrays.toString(cycleSortBruteForce(arr)));
    }
    private static int[] cycleSortBruteForce(int[] arr){
        int currIdx = 0;
        int comparisons = 0;

        while (currIdx < arr.length){
            comparisons++;
            if(arr[currIdx] == currIdx+1) currIdx++;
            else{
                int value = arr[currIdx];

                int temp = arr[value-1];
                arr[value-1] = value;
                arr[currIdx] = temp;
            }
        }
        System.out.println("Comparisons : " + comparisons);
        return arr;
    }
}
