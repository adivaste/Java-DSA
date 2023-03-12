package com.company;

public class FindSingle {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,1,3,2,45,5,-2,-2};
        System.out.println(findSingle(arr));
    }
    private static int findSingle(int[] arr){
        int single = 0;
        for (int i = 0; i < arr.length; i++) {
            single = single^arr[i];
        }
        return single;
    }
}

// Works also for negative numbers