package com.company;

public class FindFirstIndexInDuplicateSorted {
    public static void main(String[] args) {
        int[] arr = {8,32,32,32,32,32,48,56,56,60,72,84,92,92,93};
        int[] arr2 = {32,32,32,32,32,48,56,56,60,72,84,92,92,93};
        int[] arr3 = {12,12,12,12,12,12,12,12};
        int target = 12;

        int idx = findFirstIndexInDuplicateSorted(arr2, target);
        System.out.println(idx);
    }

    private static int findFirstIndexInDuplicateSorted(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                int idxToReturn = mid;
                while ((idxToReturn > 0) && (arr[idxToReturn] == arr[idxToReturn-1])){
                    idxToReturn -= 1;
                }
                return idxToReturn;
            }
            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}
