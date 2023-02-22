# Lecture 7 - Searching | Linear Search

> **What is linear search Algorithm**
> 

It is a very simple searching algorithms for searching the elements inside a data structure like array, linked list any other. It checks each elements from start of the array with target element.

> **Algorithm**
> 
1. Start
2. Read the inputs `arr` and `target` element.
3. Start searching from first element of the array, for target element if found return `index`
4. If not found return `index` as `-1`
5. End

> **Pseudo code**
> 

```java
START
READ arr,target
for item in arr:
	if (item == target) 
		return index
return -1
END
```

> **Code**
> 

```java
package com.company;

public class LinearSearch {

    public static void main(String[] args) {
	    int[] arr = {23,43,67,98,12,45};
        System.out.println(linearSearch(arr, 5634));
    }

    private static int linearSearch(int[] arr, int target){
        // If array size is 0 then return -1
        if (arr.length == 0) return -1;

        // Check for each element within array for target
        for (int idx = 0; idx < arr.length; idx++) {
            int element = arr[idx];
            if (target == element) return idx;
        }

        // If no element found then return -1
        return -1;
    }
}
```

> **Time complexity**
> 
- Time complexity for linear search is `O(n)` where `n` is length of an array. As the input grows the time grows linearly.
- Best case TC    : `O(1)`  ( Constant  : When Element found in first search)
- Worst case TC : `O(n)`  ( Linear : When Element found in last case or not found)

> **Space Complexity**
> 
- Space complexity for linear search is `O(1)` which is constant time complexity.
- Best and Worst case SC : `O(1)`  ( Constant  : As we are not creating any extra array, just defining 2-3 extra variable, and here space is not related to size of array anymore except input )

> **Advantages**
> 
1. Simple to understand and easy to implement
2. Take constant space 
3. Works on both sorted and unsorted array
4. Well suited for small datasets, without any complexity & lightweight. (n<100)

> **Disadvantages**
> 
1. Not suitable for large datasets
2. Not much efficient to work (Hash tables > Linear Search)

> **Use cases**
> 
1. Used in smaller dataset cases.
2. Good for searching in contiguous memory data structures.
3. In real world used in Phonebook, Finding specific word in documents and in databases for searching when indexing is not used.

> **Questions**
> 
- Linear search using range
    
    ```java
    package com.company;
    
    public class LinearSearchInRange {
        public static void main(String[] args) {
            int[] arr = {12,24,36,48,60,72};
            System.out.println(linearSearchInRange(arr, 36, 0,9));
        }
    
        private static int linearSearchInRange(int[] arr, int target, int start, int end){
            // Checking for empty array
            if (arr.length == 0) return -1;
    
            // Checking for correct indexes
            if (start < 0) return -1;
            if (end >= arr.length) end = arr.length-1;
    
            // Checking for element within range
            for (int idx = start; idx < end; idx++) {
                if (arr[idx] == target) return idx;
            }
    
            // If not find then return -1
            return -1;
        }
    }
    ```
    
- Search character in string
    
    ```java
    package com.company;
    
    public class SearchCharInString {
        public static void main(String[] args) {
            System.out.println(searchChar("Aditya", 'a'));
            System.out.println(searchChar2("Aditya", 'a'));
        }
    
        private static boolean searchChar2(String word, char target) {
            if (word.length() == 0) return false;
    
            for (char letter : word.toCharArray()){
                if(letter == target) return true;
            }
    
            return false;
        }
    
        private static boolean searchChar(String word, char target){
            // If string length is 0 then return false
            if (word.length() == 0) return false;
    
            // Iterate over the Word and search for it
            for (int idx = 0; idx < word.length(); idx++) {
                if (word.charAt(idx) == target) return true;
            }
    
            // If char not found
            return false;
        }
    
    }
    ```
    
- Search in 2D array
    
    ```java
    package com.company;
    
    import java.util.Arrays;
    
    public class SearchIn2DArray {
        public static void main(String[] args) {
            int[][] arr = {
                    {97,12,34,56,23},
                    {65,22,86,1},
                    {90,54,25,86,32,89},
                    {1,2,4}
            };
            int[] ans = searchIn2DArray(arr,454);
            System.out.println(Arrays.toString(ans));
        }
    
        private static int[] searchIn2DArray(int[][] arr, int target){
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] == target) return new int[] {i,j};
                }
            }
            return new int[]{-1,-1};
        }
    }
    ```
    
- Minimum Number
    
    ```java
    package com.company;
    
    public class MinimumNumber {
        public static void main(String[] args) {
            int[] arr = {61,27,32,47,5,6,23,232,23};
            System.out.println(findMinimum(arr));
        }
    
        private static int findMinimum(int[] arr) {
            int min = Integer.MAX_VALUE;
            for (int j : arr) {
                if (j < min) min = j;
            }
            return min;
        }
    }
    ```
    
- Find count of even digits
    
    ```java
    package com.company;
    
    class FindCountOfEvenNumDigits {
    
        public static void main(String[] args) {
            int[] nums = {12,34,1,343,12232,534};
            System.out.println(findNumbers(nums));
        }
        public static int findNumbers(int[] nums) {
            int count = 0;
            for(int num:nums){
                if (haveEvenDigits(num)) count++;
            }
            return count;
        }
        private static boolean haveEvenDigits(int number){
            if (number<0) number = number*-1;
            return ((int)Math.log10(number) + 1)%2==0;
        }
    }
    ```
    
- Find count of even digits Optimised
    
    ```java
    package com.company;
    
    public class FindEvenDigitsOptimum {
        public static void main(String[] args) {
            int[] nums = {2,32,3212,4,342,23};
    
            System.out.println(findNumbers(nums));
        }
        public static int findNumbers(int[] nums) {
            int count = 0;
            for(int num:nums){
                if (haveEvenDigits(num)) count++;
            }
            return count;
        }
        private static boolean haveEvenDigits(int number){
            if (number<0) number = number*-1;
            return ((int)Math.log10(number) + 1)%2==0;
        }
    }
    ```
    
- Maximum Wealth
    
    ```java
    package com.company;
    
    class MaxWealth {
        public static void main(String[] args) {
            int[][] arr = {
                    {1,2,3},
                    {4,5,6}
            };
    
            int maxWealth = maximumWealth(arr);
            System.out.println(maxWealth);
        }
        public static int maximumWealth(int[][] accounts) {
            int maxWealth = 0;
            for (int i=0; i<accounts.length; i++){
                int personTotalWealth = 0;
                for (int j=0; j<accounts[i].length; j++){
                    personTotalWealth += accounts[i][j];
                }
                if (maxWealth < personTotalWealth) maxWealth = personTotalWealth;
            }
            return maxWealth;
        }
    ```