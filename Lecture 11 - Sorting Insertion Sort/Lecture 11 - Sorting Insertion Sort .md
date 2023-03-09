# Lecture 11 - Sorting | Insertion Sort

## 1. Theory and Algorithm

> **What is Insertion Sort**
> 

Its is the sorting algorithm used to sort the element in ascending and descending order. It is the comparison based sorting algorithm. In the insertion sort the array is logically divided into two part sorted and unsorted respectively, so two adjacent items are compared and if based on intend or prev. number is larger then number are swapped. This swaps are done until element get inserted at correct position. After performing for `(n-1)` times array get sorted. It has `O(n)` and `O(n^2)` for best and worst case time complexity respectively. Also it takes constant space of `O(1)` This is the stable sorting algorithm if we select first element from relative two equal elements. 

> **Algorithm**
> 
1. START
2. Take input array `arr`
3. Iterate over the `arr` from an index `1` 
4. Using while loop check that previous adjacent number is greater than current one, if yes then swap these two elements, else break the loop.
5. Repeat the step for 4 again and again, until loop breaks.
6. After completing the outer loop return the `arr`
7. END

> **Pseudo Code**
> 

```java
START
READ arr
SET n = arr.length
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

This is the pseudo code for the Insertion Sort algorithm. It explains the steps involved in sorting an array using Insertion Sort.

> **Code**
> 

```java
package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(Arrays.toString(insertionSort(arr)));
    }
    private static int[] insertionSort(int[] arr){
				// Iterating over an array elements for finding the position/index of that element
				// in a sorted array present on left side.
        for (int i = 1; i < arr.length; i++) {
						// Storing the current and previous index so that we can compare each time and
						// they are dyanamic
            int currIdx = i;
            int prevIdx = currIdx-1;

						// Now I will check previous element is greater, and is the previous is greater 
						// than or equal to zero to avoid arrayOutOfBound Exeception
            while(prevIdx>=0 && arr[prevIdx] > arr[currIdx]){
								// Swap with the previous one
                int temp = arr[prevIdx];
                arr[prevIdx] = arr[currIdx];
                arr[currIdx] = temp;

								// Updating indexes so that I can check again.
                currIdx--;
                prevIdx = currIdx-1;
            }
        }
				// Returning the sorted array.
        return arr;
    }
}
```

> **Time Complexity**
> 
- Best Case : `O(n)`
    
    For an array of sorted elements, it will check for each element and each time it will compare with it’s previous element only so comparison is done only ones, for each element so time complexity will be `O(n-1) ~= O(n)` ( As we are starting from second element )
    
- Average Case : `O(n^2)`
- Worst Case : `O(n^2)`
    
    For any array which is sorted in reverse order it will make most of the comparison possible.
    
    So total comparisons = `(1) + (2) + (3) + ... + (n-2) + (n-1)`
    
                                       = `n*(n-1)/2`  
    
                              ~= `n^2`
    

> **Space Complexity**
> 

For all the cases space complexity is `O(1)` which is the constant as no extra array has been created only the constant variables get created.

- Best Case : `O(1)`
- Avg. Case : `O(1)`
- Worst Case : `O(1)`

> **Real world Examples**
> 
1. Tailors use insertion sort algorithm for arranging shirt according to size in closet.
2. Also in playing cards we use arrange card in sorted manner using insertion sort.

> **Use Cases**
> 
1. In small databases
2. In Embedded systems, where memory and processing power is limited
3. Used in sorting the partially sorted array.

---

## 2. Code and Questions

- Insertion Sort
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class Main {
    
        public static void main(String[] args) {
            int[] arr = {};
            System.out.println(Arrays.toString(insertionSort(arr)));
        }
        private static int[] insertionSort(int[] arr){
            for (int i = 1; i < arr.length; i++) {
                int currIdx = i;
                int prevIdx = currIdx-1;
    
                while(prevIdx>=0 && arr[prevIdx] > arr[currIdx]){
                    int temp = arr[prevIdx];
                    arr[prevIdx] = arr[currIdx];
                    arr[currIdx] = temp;
    
                    currIdx--;
                    prevIdx = currIdx-1;
                }
            }
            return arr;
        }
    }
    
    ```