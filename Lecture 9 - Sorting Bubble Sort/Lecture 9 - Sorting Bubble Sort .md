# Lecture 9 - Sorting | Bubble Sort

<aside>
💎 Practise explaining the concepts to someone or virtually while making an eye contact.

</aside>

## 1. Sorting Introduction

> **What is sorting ?**
> 
- Sorting is just the process of arranging the data items in particular order it may be ascending and descending order.
- Ex. Bubble Sort, Merge Sort, Insertion sort, Selection sort.

> **What is stable and unstable sorting ?**
> 
- A stable sorting is a type of sorting algorithm in which the relative order of the equal elements present inside array is preserved/maintained during the sorting.
- Example of the red and green balls where sorting is done on number basis where order of colour is maintained.
- Ex. Bubble sort, Merge sort, Insertion sort

- A unstable sorting is the type of sorting algorithm in which order elements are sorted perfectly but the order is not maintained for equal elements.
- Ex. Selection sort, Quick sort.

> **In-place and out-place algorithms**
> 
- In place sorting algorithms sort the data in same memory space without taking extra space.
- Out place sorting algorithms sort the data by taking extra space than given, that is arbitrary space.

> **Internal and external sorting algo’s**
> 
- Internal sorting is a process of sorting the data which can fit entirely inside a memory.
- External sorting is a process of sorting the data which cannot fit entirely inside of memory, like terabytes of data stored in disk.

> **Types of sorting algos based on its nature**
> 

1. Comparison based
2. Non-Comparison based
3. Divide and conquer
4. In-place
5. Out-place
6. Stable 

1. Unstable
2. Hybrid
3. Internal
4. External
5. Parallel
6. Distributed

---

## 2. Bubble Sort Algorithm

> **What is bubble sort algorithm**
> 

FORMAT : Sorting + Type of Algo + Algo in max 2 sentence + Naming analogy + Time & Space complex. + Use case

It is simple sorting algorithm used to sort the elements in ascending and descending order. It is Comparison based algo. which compares two adjacent items and swap in indented order making the largest element come to an end in each iteration. After performing N iterations array get sorted. Just like bubble comes from bottom to surface in water, In this algorithm largest element moves to end of array like just like bubble. Which takes an O(n) time complexity in best case O(n^2) in worst case and it takes constant space complexity.

> **Algorithm**
> 
1. START
2. Take Input `arr`
3. Create variable `swapped` and initialize to `true`
4. Iterate for the `arr.length-1` time for moving the one  largest/smallest element to the end.
5. Set the `swapped` equal to `false` 
6. Now again iterate over the array `arr` and check for is the `prev` element is greater than `curr` one, if yes then SWAP them and make `swapped = true`
7. After completing the loop return the array `arr`
8. END

> **Working of Algorithm**
> 
1. A bubble sort algorithms works in the form of passes like pass 1, pass 2, pass 3.
2. In each pass or iteration the largest element of the unsorted array moves to the end of the unsorted part. In this way logically array get divided into the two parts unsorted and sorted respectively.
3. Bubble sort algorithms works like, it check the two adjacent elements,  and depending on the intended order we simply swap them. This makes largest element come to end of array.( For ascending order : If previous element is greater than the current one then we will simply swap them )
4. In this way, in each pass one element get sorted and by doing this for (n-1) times we will end up sorting the array.
5. Just like movement of bubble in water, it moves from bottom to surface and here also largest elements bubbles up to the end that’s why we call it Bubble Sort.

> **Pseudo Code**
> 

```java
START
INPUT arr
SET swapped = true

for i=0 to i=arr.length-1: 
	swapped = false
	for j=1 to j=arr.length-i: 
		if arr[j-1] > arr[j]
			SWAP
			swapped = true

return arr
END
```

> **Code**
> 

```java
package com.company;

import java.util.Arrays;

public class BubbleSortOptimised {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(bubbleSortOptimised(arr)));
    }
    private static int[] bubbleSortOptimised(int[] arr){
        // To check total comparisons occurring in algo.
        int comparisons = 0;
        // To check are elements actually swapped in prev iteration or not
        boolean swapped = true;

        // Looping arr.length-1 time and checking swapped condition, which makes
        // arr.length-1 passes and check in previous iteration are elements are swapped
        // or not if not then terminate the loop
        for (int i=0; i<arr.length-1 && swapped; i++){
            // When we enter for checking, first make flag it as false, so when any comparison
            // occurs then it will be true, if not then always false and in next iteration loop
            // terminates
            swapped = false;
            for (int j = 1; j < arr.length-i; j++) {
                comparisons++;
                // Swap if prev element is larger than current ones
                if (arr[j-1] > arr[j]){
                    // Swapping the numbers
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    // Modifying the flag
                    swapped = true;
                }
            }
        }
        // Print comparisons and return
        System.out.println("Comparisons : " + comparisons);
        return arr;
    }
}
```

> **Time Complexity**
> 
1. Best case  :  O(n) 
    
    For the array which is already sorted, the time complexity will be O(n). Where it checks for each element with its previous one to comparison. And when no swapping occurs in 1st iteration then loop terminates.
    
2. Average case : O(n^2)
3. Worst case : O(n^2)
    
    For the array which is reversely sorted and intended to make in ascending order then for each iteration on average `n` comparisons will be required. Making the complexity `n^2` . For each iteration (n-x) comparisons will be required. (x is  number of elements which are sorted)
    
    No. of comparisons required = $`n + (n-1) + (n-2) + (n-3) + (n-4)`$
    
                                                          =  $`4n - n*(n-1)/2`$
    
                                                    =  $`n^2`$
    

> **Space Complexity**
> 

 It takes constant amount of space as no extra space is required for all the cases.

- Best case : O(1)
- Average case : O(1)
- Worst case : O(1)

> **Advantages**
> 
1. Easy to understand and simple for implementation.
2. Takes no extra memory space.
3. Suitable for small datasets
4. Its is stable sorting algorithm

> **Disadvantages**
> 
1. Take the more time complexity O(n^2) which is slow for sorting.
2. Not suitable and efficient for large datasets as it requires multiple passes to data

> **Use cases**
> 
1. Sorting the small data sets
2. In computer graphics for polygon filling application.
3. In Phone book and files directory for sorting according to the name, date, size.

---

## 3. Codes and Questions

- Bubble sort Brute force approach
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class BubbleSortBruteforce {
    
        public static void main(String[] args) {
            int[] arr = {1,5,3,4,2,0};
            System.out.println(Arrays.toString(bubbleSortBruteforce(arr)));
        }
        private static int[] bubbleSortBruteforce(int[] arr){
            for (int i=0; i<arr.length-1; i++){
                for (int j = 1; j < arr.length; j++) {
    
                    if (arr[j-1] > arr[j]){
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }
    }
    ```
    
- Bubble sort regular
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class BubbleSort {
    
        public static void main(String[] args) {
            int[] arr = {1,2,3,4,5,6,7,8,9,10};
            System.out.println(Arrays.toString(bubbleSort(arr)));
        }
        private static int[] bubbleSort(int[] arr){
            int comparisons = 0;
            for (int i=0; i<arr.length-1; i++){
                for (int j = 1; j < arr.length-i; j++) {
                    comparisons++;
                    if (arr[j-1] > arr[j]){
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            // Print comparisons and return
            System.out.println("Comparisons : " + comparisons);
            return arr;
        }
    }
    ```
    
- Bubble sort Optimised
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class BubbleSortOptimised {
    
        public static void main(String[] args) {
            int[] arr = {5, 4, 3, 2, 1};
            System.out.println(Arrays.toString(bubbleSortOptimised(arr)));
        }
        private static int[] bubbleSortOptimised(int[] arr){
            // To check total comparisons occurring in algo.
            int comparisons = 0;
            // To check are elements actually swapped in prev iteration or not
            boolean swapped = true;
    
            // Looping arr.length-1 time and checking swapped condition, which makes
            // arr.length-1 passes and check in previous iteration are elements are swapped
            // or not if not then terminate the loop
            for (int i=0; i<arr.length-1 && swapped; i++){
                // When we enter for checking, first make flag it as false, so when any comparison
                // occurs then it will be true, if not then always false and in next iteration loop
                // terminates
                swapped = false;
                for (int j = 1; j < arr.length-i; j++) {
                    comparisons++;
                    // Swap if prev element is larger than current ones
                    if (arr[j-1] > arr[j]){
                        // Swapping the numbers
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                        // Modifying the flag
                        swapped = true;
                    }
                }
            }
            // Print comparisons and return
            System.out.println("Comparisons : " + comparisons);
            return arr;
        }
    }
    
    // Total Number of comparisons will be equal to = Sum of arr.length-1 natural numbers.
    // Time = O(n^2)
    // Space = O(1)
    ```