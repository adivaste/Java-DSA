package com.company;

public class CountOfElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7,12,26,26,26,37,60};
        int f = firstAndLastOccurrence(arr, 26,true);
        int l = firstAndLastOccurrence(arr, 26,false);

        System.out.printf("Count : %d", l-f+1 );
    }
    private static int firstAndLastOccurrence(int[] arr, int target,boolean lookingFirst){
        int start = 0;
        int end = arr.length - 1;
        int idxToReturn = -1;

        while (start <= end){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                idxToReturn = mid;
                if (lookingFirst) end = mid - 1;
                else start = mid + 1;
            }
            else if (target < arr[mid]) end = mid - 1;
            else start = mid + 1;
        }
        return idxToReturn;
    }
}
