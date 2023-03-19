package com.company;

import java.util.ArrayList;

public class FindAllOccurrencesWithoutArgument {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,6,7,85,23,6,6};

        System.out.println(findAllOccurrencesWithoutArgument2(arr, 7, 0));
    }

    private static ArrayList<Integer> findAllOccurrencesWithoutArgument(int[] arr, int target, int idx){
        if (idx == arr.length) {
            return new ArrayList<Integer>();
        }
        if (arr[idx] == target){
            return new ArrayList<Integer>() {{ add(idx); addAll(findAllOccurrencesWithoutArgument(arr, target, idx+1)); }};
        }
        return new ArrayList<Integer>() {{ addAll(findAllOccurrencesWithoutArgument(arr, target, idx+1)); }};
    }

    private static ArrayList<Integer> findAllOccurrencesWithoutArgument2(int[] arr, int target, int idx) {
        ArrayList<Integer> currList = new ArrayList<>();

        // If last element exists then return empty list
        if (idx == arr.length) return currList;

        // If matches then add element to currList
        if (arr[idx] == target) currList.add(idx);

        // Get the remaining below indexes
        ArrayList<Integer> belowIndexes = findAllOccurrencesWithoutArgument2(arr, target, idx+1);

        belowIndexes.addAll(currList);
        return belowIndexes;

    }
}
