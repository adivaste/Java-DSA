package com.company;

public class FindLastIndexInDuplicateSortedOptimal {
    public static void main(String[] args) {
        int[] arr = {8,32,32,32,32,32,48,56,56,60,72,84,92,92,93};
        int[] arr2 = {32,32,32,32,32,48,56,56,60,72,84,92,92,93};
        int[] arr3 = {12,12,12,12,12,12,12,45};
        int target = 92;

        System.out.println(binarySearch(arr2,target));
    }
    private static int binarySearch(int[] arr, int target){
        int lastOccurrenceIdx = -1;

        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                lastOccurrenceIdx = mid;
                start = mid + 1;
            }
            else if (arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return lastOccurrenceIdx;
    }

    private static int binarySearch2(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }

        if (end >= 0 && arr[start] == target) return end;
        return -1;
    }
}