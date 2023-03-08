package com.company;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        int arr[] = {14 ,13 ,17 ,7 ,13 ,5 ,16 ,18 ,10 ,17 ,8 ,0 ,0 ,17 ,1 ,3 ,7, 16 ,11 ,14};
        System.out.println(kthMex(20,9,arr));
    }

    public static int kthMex(int n, int k, int arr[]) {
        int currIdx = 0;

        while (currIdx < arr.length) {
            int correctIdx = arr[currIdx];
            if ((correctIdx >= arr.length) || (correctIdx < 0) || (arr[currIdx] == currIdx) || (arr[currIdx] == arr[correctIdx])) {
                currIdx++;
            } else {
                swap(arr, currIdx, correctIdx);
            }
        }

        // ---- Until this array is sorted ----
        System.out.println(Arrays.toString(arr));

        int done = 0;
        int largestPresent = -1;

        // If K is less than array size then it will return missing element using this
        for (int i = 0; i < n; i++) {
            if (arr[i] == i && arr[i] > largestPresent) largestPresent = arr[i];
            else done++;
            if (done == k) return i;
        }
        largestPresent = arr.length-1;

        // Finding the unique elements from remaining array
        List<Integer> uniqueNumbers = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i && arr[i] > largestPresent) {
                if (!uniqueNumbers.contains(arr[i])) uniqueNumbers.add(arr[i]);
            }
        }

        int possibleNumberToReturn = largestPresent + k - done;
        int start = largestPresent + 1;
        int end = possibleNumberToReturn;

        int count;
        do {
            count = getPossibleUniqueInRange(uniqueNumbers, start, end);
            possibleNumberToReturn = possibleNumberToReturn + count;
            start = end+1;
            end = possibleNumberToReturn;
        } while (count != 0);

        return possibleNumberToReturn;
    }
    // Swapping
    private static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
    private static int getPossibleUniqueInRange(List<Integer> arr, int start, int end){
        int count = 0 ;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= start && arr.get(i) <= end) count++;
        }
        return count;
    }
}
