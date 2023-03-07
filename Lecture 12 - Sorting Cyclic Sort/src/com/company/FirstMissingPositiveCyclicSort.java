package com.company;

class FirstMissingPositiveCyclicSort {
    public static void main(String[] args) {
        int[] arr = {2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648};
        System.out.println(firstMissingPositive(arr));
    }
    private static int firstMissingPositive(int[] nums) {
        int currIdx = 0;

        while (currIdx < nums.length ){
            int correctIdx = nums[currIdx] - 1;

            // Or you can swap the condition if/else as here multiple check are done.
            if ((nums[currIdx] >= nums.length) || (correctIdx >= nums.length) || (correctIdx < 0) || (nums[currIdx] == currIdx+1) || (nums[currIdx] == nums[correctIdx]) ){
                currIdx++;
            }
            else{
                swap(nums, currIdx, correctIdx);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1 ) return i+1;
        }
        return nums.length+1;
    }

    private static void swap(int[] nums, int currIdx, int correctIdx) {
        int temp =  nums[currIdx];
        nums[currIdx] = nums[correctIdx];
        nums[correctIdx] = temp;
    }
}