package com.company;

import java.util.Arrays;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] arr = {
                {97,12,34,56,23},
                {65,22,86,1},
                {90,54,25,86,32,89},
                {1,2,4}
        };
        int[] ans = searchIn2DArray(arr,454);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] searchIn2DArray(int[][] arr, int target){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == target) return new int[] {i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
