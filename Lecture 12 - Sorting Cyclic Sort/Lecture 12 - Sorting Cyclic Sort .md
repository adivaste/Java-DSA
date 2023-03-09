# Lecture 12 - Sorting | Cyclic Sort

> **What is Cyclic Sort**
> 

Sorting is a method of arranging the elements in ascending and descending order. It is the comparison based sorting algorithm. In this algorithm elements are sorted from particular range (like 1-N or 0-N ) using the index of array. For each element in array we find the relation with index, if this relation is true for all element then element is at correct index. If not then we swap the elements until it is at correct position. Which takes O(n^2) time complexity.  

> **When To Use Cyclic Sort**
> 
- When numbers are given from 1-N
- If any particular definite range is given then definitely try for Cycle Sort.

> **Algorithm**
> 

> **Pseudo Code**
> 

```java
START
READ arr
SET n = length of arr
for i = 1 to n-1
   cur_idx = i
   prev_idx = curr_idx - 1

   while prev_idx >= 0 and arr[prev_idx] > arr[curr_idx]
      swap arr[prev_idx] and arr[curr_idx]
      curr_idx = prev_idx
      prev_idx = curr_idx - 1
return arr
END
```

> **Code**
> 

```java
package com.company;

import java.util.Arrays;

public class CycleSort {

    public static void main(String[] args) {
        int[] arr = {5,1,3,4,2};
        System.out.println(Arrays.toString(cycleSort(arr)));
    }
    private static int[] cycleSort(int[] arr){
        int currIdx = 0;

        while (currIdx < arr.length){
            if(arr[currIdx] == currIdx+1) currIdx++;
            else{
                int currValue = arr[currIdx];

                int temp = arr[currValue-1];
                arr[currValue-1] = currValue;
                arr[currIdx] = temp;
            }
        }
        return arr;
    }
}
```

> **Time Complexity**
> 

The time complexity in both Best, Worst and Average case is `O(n^2)`. Because first I have to iterate over an array, for each element and check for its correctness, that is it at its correct position if yes then for that particular case there will be constant time, but if it is not at correct location then I have to make the swaps and in worst case that number can be `n`. So at the end logically it will be `O(n^2)` 

`The Number of comparisons made by cycle sort in worst case are = (n-1) + n`

- Best Case : `O(n^2)`
- Avg. Case : `O(n^2)`
- Worst Case : `O(n^2)`

> **Space Complexity**
> 

The space complexity in all Best, Worst and Average cases is constant `O(1)`

- Best Case : `O(1)`
- Avg. Case : `O(1)`
- Worst Case : `O(1)`

> **Advantages**
> 
- Though it has a time complexity of `O(n^2)` in practise, I it faster than other `O(n^2)` algo’s, especially in sorted duplicate element arrays.
- It is a in-place sorting algorithm having the constant space complexity of `O(1)`
- It is a adaptive algorithm, means time complexity can be minimized if array is partially sorted or nearly sorted.

> **Disadvantages**
> 
- It has a `O(n^2)` time complexity, which is inefficient in sorting large arrays.
- It is not a stable sorting algorithm.

> **Use Cases**
> 
- Cycle sort can be a useful algorithm for applications that involve sorting small to medium-sized data sets that contain clusters of similar values or nearly sorted data.

---

## 2. Questions

- Cycle Sort Brute force
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class CycleSortBruteForce {
    
        public static void main(String[] args) {
           int[] arr = {5,1,3,4,2};
            System.out.println(Arrays.toString(cycleSortBruteForce(arr)));
        }
        private static int[] cycleSortBruteForce(int[] arr){
            int currIdx = 0;
            int comparisons = 0;
    
            while (currIdx < arr.length){
                comparisons++;
                if(arr[currIdx] == currIdx+1) currIdx++;
                else{
                    int value = arr[currIdx];
    
                    int temp = arr[value-1];
                    arr[value-1] = value;
                    arr[currIdx] = temp;
                }
            }
            System.out.println("Comparisons : " + comparisons);
            return arr;
        }
    }
    
    ```
    
- Missing Number
    
    ```java
    package com.company;
    
    public class MissingNumber {
        public static void main(String[] args) {
            int n = 5;
            int[] arr = {5,3,4,2};
    
            System.out.println(missingNumber(arr, n));
        }
        private static int missingNumber(int[] arr, int n){
            int sum = n*(n+1)/2;
            for (int j : arr) sum = sum - j;
            return sum;
        }
    }
    
    ```
    
- Missing Number using cycle sort
    
    ```java
    package com.company;
    
    public class MissingNumberUsingCycleSort {
        public static void main(String[] args) {
            int[] arr = {1,3,4,0,2,5};
            int n = 6;
    
            System.out.println(missingNumberUsingCycleSort(arr, n));
        }
        private static int missingNumberUsingCycleSort(int[] arr, int end){
            int missingNumberIndex = end;  // missingNumberIndex = arr.length
            int currIdx = 0;
    
            while (currIdx < arr.length){
    
                if (arr[currIdx] == arr.length){
                    missingNumberIndex = currIdx;
                    currIdx++;
                }
                else if (arr[currIdx] == currIdx){
                    currIdx++;
                }
                else{
                    int value = arr[currIdx];
                    swap(arr,currIdx,value);
                }
            }
    
            return arr[missingNumberIndex];
        }
    
        private static void swap(int[] arr, int idx1, int idx2){
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }
    
    ```
    
- First Missing Positive Number
    
    ```java
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
    ```
    
- All missing number using cycle sort
    
    ```java
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
    ```
    
- Find Duplicate Brute Force
    
    ```java
    package com.company;
    
    public class FindDuplicateNumberBruteForce {
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,5,6,7,8};
            System.out.println(findDuplicateNumberBruteForce(arr));
        }
        private static int findDuplicateNumberBruteForce(int[] arr){
            for (int i = 0; i < arr.length; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    if (arr[j] == arr[i]) return arr[i];
                }
            }
            return -1;
        }
    }
    
    ```
    
- Find Duplicate Cycle sort
    
    ```java
    package com.company;
    
    public class FindDuplicateCycleSort {
        public static void main(String[] args) {
            int[] arr = {1,3,4,5,2,4};
            findDuplicateCycleSort(arr);
        }
        private static void findDuplicateCycleSort(int[] arr){
            int currIdx = 0;
    
            while (currIdx < arr.length){
                int correctIdx = arr[currIdx] - 1;
                if (arr[currIdx] == currIdx+1 || arr[currIdx] == arr[correctIdx]){
                    currIdx++;
                }
                else{
                    swap(arr, currIdx, arr[currIdx]-1);
                }
            }
            System.out.println(arr[arr.length-1]);
        }
    
        private static void swap(int[] arr, int idx1, int idx2) {
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }
    
    ```
    
- Find all the duplicates Cycle sort
    
    ```java
    package com.company;
    
    import java.util.ArrayList;
    import java.util.List;
    
    class FindAllDuplicatesCycleSort {
    
        public static void main(String[] args) {
            int[] arr = {};
            System.out.println(findDuplicates(arr));
        }
    
        private static List<Integer> findDuplicates(int[] nums) {
            int currIdx = 0;
    
            while(currIdx < nums.length){
                int correctIdx = nums[currIdx] - 1;
                if ((nums[currIdx] == currIdx + 1) || (nums[currIdx] == nums[correctIdx])){
                    currIdx++;
                }
                else{
                    swap(nums, currIdx, nums[currIdx]-1);
                }
            }
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1) list.add(nums[i]);
            }
            return  list;
    
        }
        private static void swap(int[] arr, int idx1, int idx2){
            int temp = arr[idx1];
            arr[idx1] = arr[idx2];
            arr[idx2] = temp;
        }
    }
    ```
    
- Set Mismatch Cycle sort
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class SetMismatchCycleSort {
        public static void main(String[] args) {
            int[] arr = {1,1};
            System.out.println(Arrays.toString(setMismatch(arr)));
        }
        private static int[] setMismatch(int[] arr){
            int currIdx = 0;
    
            while(currIdx < arr.length){
                int correctIdx = arr[currIdx] - 1;
                if ((arr[currIdx] == currIdx+1) || (arr[currIdx] == arr[correctIdx])){
                    currIdx++;
                }
                else{
                    swap(arr, currIdx, correctIdx);
                }
            }
    
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != i+1) return (new int[]{arr[i], i+1});
            }
            return new int[]{};
        }
    
        private static void swap(int[] arr, int currIdx, int correctIdx) {
            int temp = arr[currIdx];
            arr[currIdx] = arr[correctIdx];
            arr[correctIdx] = temp;
        }
    }
    
    ```
    
- Finding Kth Min element of unsorted array
    
    ```java
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
    
    ```