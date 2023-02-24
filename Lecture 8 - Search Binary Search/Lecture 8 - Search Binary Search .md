# Lecture 8 - Search | Binary Search

## 1. Binary Search Theory, Algorithm and other basics

> **What is binary search ?**
> 

A binary search is one of the most efficient algorithm for searching the elements in data structure having the random access to elements and sorted. As the array is sorted it checks the middle element, do some comparisons and each time it reduces its search space to half and that’s why it has complexity of `log(n)`

> **Algorithm**
> 
1. Start
2. Read the inputs `arr` and `target` element.
3. Sort the array is not sorted.
4. Declare the start and end variable with  `0` and `arr.length-1` these are the indices to find middle index each time.
5. While `start <= end`  then continue only otherwise skip it.
6. Initialize `mid=start + (end-start)/2`
7. Check for three conditions 
    - Is `arr[mid]` equal to target element if yes then return `mid` index.
    - Check is target element is less than middle element then make your end shorter by `end=mid-1`
    - Check is target element is greater than middle element then make your start longer by `start=mid+1`
8. After completing while loop if it return nothing then element not found return `-1`
9. END

> **Pseudo Code**
> 

```java
START
READ arr, target
start = 0
end = arr.length - 1 
while (start <= end):
	mid = start + (end-start)/2
	if arr[mid] == target:
		return mid;
	else if arr[mid] < target:
		start = mid+1
	else 
		end = mid-1
return -1
END
```

> **Why binary is used most and how it works actually ?**
> 
- For the binary search the the worst case complexity is `log(n)` which means if you are performing the binary search on 1,000,000 One million items then it will take max only 20 searches to search the element inside it. While in case of linear search it will take 1 million comparisons.
- Every time the search space is reduced to half of the previous one.
- Steps
    
    ![Untitled](Lecture%208%20-%20Search%20Binary%20Search%20bdfb92e4bd5c497094124f1d1914b468/Untitled.png)
    
    ![Untitled](Lecture%208%20-%20Search%20Binary%20Search%20bdfb92e4bd5c497094124f1d1914b468/Untitled%201.png)
    
    ![Untitled](Lecture%208%20-%20Search%20Binary%20Search%20bdfb92e4bd5c497094124f1d1914b468/Untitled%202.png)
    

> **Code**
> 

```java
package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {2,3,43,45,67,78,79,84,94};
        System.out.println(binarySearch(arr, 34));
    }

    private static int binarySearch(int[] arr, int target){
        // Declare initial variables 
        int start = 0;
        int end = arr.length - 1;

        // Continue the loop until start<=end 
        while(start <= end){
            // Assign mid = half of sum of indexes, to avoid data type memory limitations we used new formula
            int mid = start + (end-start)/2;

            // Check for three conditions
            if (arr[mid] == target){
                return mid;
            }
            else if( arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        
        // If not found then finally return -1
        return -1;
    }
}
```

> **Order-Agnostic Search**
> 
- Order agnostic search is type of searching in which the sorting order is not given already, so we have to find is it sorted in ascending or descending. So for that we will compare first and last elements.
- Code
    
    ```java
    package com.company;
    
    public class OrderAgnosticBinarySearch {
        public static void main(String[] args) {
            int[] arr = {78,67,56,45,34,23,12};
            System.out.println(orderAgnosticBinarySearch(arr, 67));
        }
    
        private static int orderAgnosticBinarySearch(int[] arr, int target) {
            if (arr.length == 0) return -1;
    
            boolean isAscending = false;
            if (arr[0] <= arr[arr.length-1]) isAscending = true;
    
            int start = 0;
            int end = arr.length - 1;
    
            while (start <= end){
                int mid = start + (end-start)/2;
                if (arr[mid] == target){
                    return mid;
                }
    
                if (isAscending){
                    if( arr[mid] > target){
                        end = mid - 1;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                else{
                    if( arr[mid] > target){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    ```
    

> **Points to remember about binary search**
> 
1. Takes `log(n)` time complexity.
2. For specifying the middle element use `mid = start + (end-start)/2` which eventually makes it same to `(start+end)/2` to avoid/escape data type memory limitations.
3. If order is not given i.e. Order-Agnostic Binary search we compare first and last elements to check is it in reverse or normal order.

> **Time Complexity**
> 
- Worst Case : It takes the `log(n)` logarithmic time for finding the element.
- Best Case    : It takes the `O(1)`  constant time for finding the element.

> **Space Complexity / Auxiliary Space**
> 
- Worst Case : It takes `O(1)` constant space.
- Best Case   : It takes `O(1)` constant space.

> **Advantages**
> 
1. Easy for implementation and it is more efficient and faster than linear search. 
2. Used for large datasets for searching the elements like hard drive or cloud.
3. It is building block of most of the algo’s used in Computer Graphics and Machine Learning.

> **Disadvantages**
> 
1. Data need to be sorted.
2. Memory locations should be contiguous & work on linked list but time and space complexity is more, it takes `O(n)`  time complexity.
3. If datasets is too large stored in drives, not possible to fit in memory then it is impossible to use binary search.
4. Still less efficient than Hash-tables.

> **Applications**
> 
1. Used in searching the files and folders by operating system in Linux and Windows.
2. Used in Image processing in computer graphics, to find the threshold value for image segmentation, which separates the image into foreground and background.
3. Used in Network routing and machine learning algorithms ( As a basic building block )
4. Used in database for finding customer data and product information.

---

## 2. Questions and approaches

> **Patterns In Binary Search Questions**
> 

Binary search, Sliding window, Two Pointer, N-sorted arrays, 01 knapsacks, Heaps, Hash-maps, K-merge

> **When to use binary search or try for binary search**
> 
1. Sorted word or related to sorted something in mentioned in question.
2. Following continuous sequence again and again to find answer like square root, or sequence of numbers.

> **Questions**
> 
- Ceiling of the number ( My Approach )
    
    ```java
    package com.company;
    
    public class CeilingOfNumber {
        public static void main(String[] args) {
            int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
            int num = 100;
    
            System.out.println(ceilingOfNumber(arr, num));
        }
    
        private static int ceilingOfNumber(int[] arr, int target) {
            int ceiling = Integer.MAX_VALUE;
    
            int start = 0;
            int end = arr.length - 1;
    
            while (start <= end){
                int mid = start + (end-start)/2;
    
                if (arr[mid]==target) return arr[mid];
                else if(arr[mid] < target) start = mid+1;
                else {
                    ceiling = arr[mid];
                    end = mid-1;
                }
            }
            return ceiling;
        }
    }
    ```
    
- Ceiling of the number
    
    ```java
    package com.company;
    
    public class CielingOfNumeberOptimal {
        public static void main(String[] args) {
            int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
            int num = 32;
    
            System.out.println(ceilingOfNumber(arr, num));
        }
    
        // Ceiling : Smallest of the numbers greater than or equal to target
        private static int ceilingOfNumber(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
    
            while (start <= end){
                int mid = start + (end-start)/2;
    
                if (arr[mid]==target) return arr[mid];
                else if(arr[mid] < target) start = mid+1;
                else end = mid-1;
            }
    
            if (start==arr.length) return Integer.MAX_VALUE;
            return arr[start];
        }
    }
    ```
    
- Floor of the number
    
    ```java
    package com.company;
    
    public class FloorOfNumberOptimal {
        public static void main(String[] args) {
            int[] arr = {12,33,37,45,48,49,56,69,73,82,99};
            int num = 0;
    
            System.out.println(floorOfNumberOptimal(arr, num));
        }
    
        // Floor : Greatest of numbers smaller than or equal to Target
        private static int floorOfNumberOptimal(int[] arr, int target) {
    
            int start = 0;
            int end = arr.length - 1;
    
            while (start <= end){
                int mid = start + (end-start)/2;
    
                if (arr[mid]==target) return arr[mid];
                else if(arr[mid] < target) start = mid+1;
                else end = mid-1;
            }
            return arr[end];
        }
    }
    ```