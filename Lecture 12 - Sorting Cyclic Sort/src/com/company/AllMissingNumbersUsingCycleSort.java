package com.company;

import java.util.ArrayList;
import java.util.List;

class AllMissingNumbersUsingCycleSort {

    public static void main(String[] args) {
        int[] arr = {3,3,3,3};
        System.out.println(findDisappearedNumbers(arr));
    }
    private static List<Integer> findDisappearedNumbers(int[] nums) {
        int currIdx = 0;

        while(currIdx < nums.length){
            if (nums[currIdx] == currIdx + 1 || nums[currIdx] == nums[nums[currIdx] - 1] ){
                currIdx++;
            }
            else{
                int correctIdx = nums[currIdx] - 1;

                int temp = nums[correctIdx];
                nums[correctIdx] = nums[currIdx];
                nums[currIdx] = temp;
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) list.add(i+1);
        }
        return list;
    }
}