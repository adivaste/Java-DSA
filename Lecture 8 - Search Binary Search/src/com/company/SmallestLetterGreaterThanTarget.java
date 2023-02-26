package com.company;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] arr  = {'b','d','f','f','j','k','x'};
        char target = 'z';

        System.out.println(nextGreatestLetter(arr,target));

    }
    public static char nextGreatestLetter(char[] arr, char target) {
        int start = 0, end = arr.length - 1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] <= target) start = mid+1;
            else end = mid-1;
        }
        return arr[start % arr.length];
    }
}