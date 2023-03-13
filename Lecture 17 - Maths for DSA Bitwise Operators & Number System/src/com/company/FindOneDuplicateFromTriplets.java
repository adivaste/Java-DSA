package com.company;

import java.sql.SQLOutput;
import java.util.Arrays;

public class FindOneDuplicateFromTriplets {
    public static void main(String[] args) {
        int[] arr = {2,2,2,5,5,45,3,6,7,8,5,3,3,6,6,7,8,7,8};
        System.out.println(findOneDuplicateFromTriplets(arr));
    }
    private static int findOneDuplicateFromTriplets(int num[]){

        // Finding the size of an array
        int arraySize = 0;
        for (int j : num) {
            int count = countNumberOfBits(j);
            if (arraySize < count) arraySize = count;
        }

        // Creating the array of size "arraySize"
        int[] arr = new int[arraySize];

        // Adding the bits in array
        for (int j : num) {
            addUpTheBits(arr, j);
        }

        // Modifying the array
        StringBuilder binaryString = new StringBuilder();
        for (int j : arr) {
            if (j % 3 != 0) binaryString.append("1");
            else binaryString.append("0");
        }

        // Return number
        return Integer.parseInt(binaryString.toString(), 2);
    }


    // Modifying the array
    private static void addUpTheBits(int[] arr, int num){
        int pointerIdx = arr.length-1;
        while (num != 0){
            // Number
            int lastBit = num & 1;
            num >>= 1;

            // Array
            if (lastBit == 1) arr[pointerIdx] ++;
            pointerIdx--;
        }
    }

    // Count number of Bits
    private static int countNumberOfBits(int num){
        if (num == 0) return 1;
        int count = 0;
        while(num != 0){
            count++;
            num >>= 1;
        }
        return count;
    }
}
