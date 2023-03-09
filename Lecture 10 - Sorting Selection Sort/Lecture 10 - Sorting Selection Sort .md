# Lecture 10 - Sorting | Selection Sort

> **What is Selection Sort**
> 

A selection sort is a sorting algorithm used to sort the items in ascending and descending order. Selection sort is comparison based searching algorithm.  In Selection sort algorithm the smallest or largest element from the unsorted array is selected and placed in its correct position/index by swapping. Performing this for (n-1) times makes array fully sorted. Its has a O(n^2) best, worst time complexity and O(1) space complexity. It is not a stable sorting algorithm. Mostly used in small datasets.

> **Algorithm**
> 
1. Start
2. Read the input array `arr`
3. For the `n` times traverse over the array, we are going to add fill the each index with the correct sorted elements.
4. Set `idxToReplace` as a `i` which is index of each element, element in it will be swapped further from it.
5. Set `idxToReplaceBy` to `i` which is the temporary value.
6. Now iterate over the array from `i^th` position to last position, find the index of minimum valued element and store it in `idxToReplaceBy`
7. After finding index of minimum valued element, swap these two elements with `idxToReplace` and `idxToReplaceBy` 
8. After completing all iterations array will be sorted and return it.
9. END

> **Pseudo Code**
> 

Here is the pseudo code for selection sort algorithm:

```java
Selection sort(arr)
    for i from 0 to len(arr) - 1
        idxToReplace = i
        idxToReplaceBy = i
        for j from i to len(arr) - 1
            if arr[j] < arr[idxToReplaceBy]
                idxToReplaceBy = j
         swap arr[idxToReplace] and arr[idxToReplaceBy]
    return arr
```

> **Code**
> 

```java
package com.company;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,1,1,5,5,7,-2,-4,-5};
        System.out.println(Arrays.toString(selectionSort(arr)));

    }
    private static int[] selectionSort(int[] arr){
        int comparisons = 0;

        // Selecting each index and filling that index with its proper element
        for (int i = 0; i < arr.length-1; i++) {
            // Which index has to replace
            int idxToReplace = i;
            // By Which index has to replace
            int idxToReplaceBy = i;
            // Storing Comparisons

            // Finding the minimum element of the array and storing its index.
            for (int j = i; j < arr.length; j++) {
                comparisons++;
                if (arr[j] < arr[idxToReplaceBy]){
                    idxToReplaceBy = j;
                }
            }

            // Swapping the numbers
            int temp = arr[idxToReplace];
            arr[idxToReplace] = arr[idxToReplaceBy];
            arr[idxToReplaceBy] = temp;
        }
        // Returning the sorted array
        System.out.println(comparisons);
        return arr;
    }
}

```

> **Time Complexity**
> 

In every case we have to check smallest/largest element from the unsorted array, and that smallest/largest number will not be known until large element  so each iteration nearly around `n` comparisons will be done.

Total Number of comparisons = `(n-1) + (n-2) + (n-3) + ... + 2 + 1`

                                                  = `n*(n-1)/2`

                                         ~= `n^2`

- Best Case : O(n^2)  (When Array is sorted)
- Average Case : O(n^2)
- Worst Case : O(n^2) (When Array is sorted in reverse order)

> **Space Complexity**
> 

For every case space complexity is constant as only constant space is acquired by algorithm.

- Best Case : O(1)
- Average Case : O(1)
- Worst Case : O(1)

> **Advantages**
> 
1. Simple and easy for understanding
2. Space complexity is constant `O(1)` 
3. Stable algorithm. Preserves the relative order of the elements inside an array, if we are choosing the first element out of two equal elements in array while making comparison for smallest/largest element.
4. Good for small datasets.
5. In-place sorting algorithm

> **Disadvantages**
> 
1. Time Complexity is `O(n^2)` for all the cases.
2. Not suitable for a large datasets.
3. Poor cache performance.
4. Not an adaptive, as it does not takes an advantage of already sorted array.

> **When to actually use Selection Sort**
> 
1. When array is the small.
2. When memory usage is an issue.
3. When Stability is required.
4. For nearly sorted or partial sorted array is will have same performance.

> **Use Cases**
> 

It is not commonly used in real-world application, having large time complexity, than other best algorithms like merge sort or quick sort.