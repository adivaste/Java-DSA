package com.company;

public class FindDuplicateNumberBruteForce {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,6,7,8};
        System.out.println(findDuplicateNumberBruteForce(arr));
    }
    private static int findDuplicateNumberBruteForce(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] == arr[i]) return arr[i];
            }
        }
        return -1;
    }
}
