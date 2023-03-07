package com.company;

import java.util.ArrayList;
import java.util.List;

class FindAllDuplicatesCycleSort {

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(findDuplicates(arr));
    }

    private static List<Integer> findDuplicates(int[] nums) {
        int currIdx = 0;

        while(currIdx < nums.length){
            int correctIdx = nums[currIdx] - 1;
            if ((nums[currIdx] == currIdx + 1) || (nums[currIdx] == nums[correctIdx])){
                currIdx++;
            }
            else{
                swap(nums, currIdx, nums[currIdx]-1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) list.add(nums[i]);
        }
        return  list;

    }
    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}