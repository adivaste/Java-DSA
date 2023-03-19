package com.company;

public class IsSorted {

    public static void main(String[] args) {
	    int[] arr = {1,89,4,5,6};

        System.out.println(isSorted(arr,0));
        System.out.println(count);
    }

    // To count how many comparisons are made by function or calls
    static int count = 0;

    // Recursion function to check is array sorted to not
    private static boolean isSorted(int[] arr, int idx){

        // Incrementing the count each time
        count++;

        // If index is reached to last element then return true
        if (idx == arr.length - 1) return true;

        // Checking current and next elements if yes then making next recursive
        // call, if false then without calling the next recursion function it will return
        // false
        return arr[idx]<=arr[idx+1] && isSorted(arr, idx+1);
    }
}

// Every arr variable is pointing to the same object, no new object get created for each
// call, different reference variables are created for the same object. When you are modifying
// array in one function call then it is modified in all cases.