package com.company;

import java.util.ArrayList;

public class FindAllOccurrences {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,6,7,85,23,6,6};
        ArrayList<Integer> answer = new ArrayList<>();

        System.out.println(findAllOccurrences(arr, 453, 0, answer));
    }

    private static ArrayList<Integer> findAllOccurrences(int[] arr, int target, int idx, ArrayList<Integer> indexes){
            if (idx == arr.length) return indexes;
            if (arr[idx] == target) indexes.add(idx);
            return findAllOccurrences(arr, target, idx+1, indexes);
    }
}

