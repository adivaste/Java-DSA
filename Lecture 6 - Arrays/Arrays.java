// Arrays 


// ===== QUESTIONS =====

// Q.1) Largest and Smallest element from an array

// :: A1 : Use simple sorting and find the first and last element || TC : O(n.logn) || SC : O(1)

class Solution{

    public int getSmallest(int[] arr){
        Arrays.sort(arr);
        return arr[0];
    }

    public int getLargest(int[] arr){
        Arrays.sort(arr);
        return arr[arr.length-1];
    }
}



// :: A2 : Keep variable largest and smallest  || TC : O(n) || SC : O(1)

class Solution{

    public int getSmallest(int[] arr){
        int smallest = arr[0];

        for(int num : arr){
            if (num < smallest) smallest = num;
        }
        
        return smallest;
    }

    public int getLargest(int[] arr){
        int largest = arr[0];

        for(int num : arr){
            if (num > largest) largest = num;
        }

        return largest;
    }
}

// Q.2) Find second largest and second smallest elment from an array

// :: A1 : Use basic sorting algorithm and return second last element if 
// other than largest otherwise traverse || TC - O(n.logn + n) || SC : O(1)
class Solution{
    
    public int getSecondLargest(int[] arr){
        Arrays.sort(arr);
        int largest = arr[arr.length-1];
        int secondLargest = -1;

        for(int i=arr.length-2; i>=0; i--){
            if (arr[i] < largest){
                secondLargest = arr[i];
                return secondLargest;
            }
        }
        return secondLargest;
    }

    public int getSecondSmallest(int[] arr){
        Arrays.sort(arr);
        int smallest = arr[0];
        int secondSmallest = -1;

        for(int i=1; i<arr.length; i++){
            if (arr[i] > smallest){
                secondSmallest = arr[i];
                return secondSmallest;
            }
        }
        return secondSmallest;
    }
}

// :: A2 : Traverse two times in the arrays and get element in second traversal
// TC : O(n + n)  || SC : O(1)
class Solution{
    
    public int getSecondLargest(int[] arr){
        int secondLargest = -1;
        int largest = arr[0];

        for(int i=0; i<arr.length; i++){
            if(arr[i] > largest) largest = arr[i];
        }

        for(int num : arr){
            if (num > secondLargest && num != largest){
                secondLargest = num;
            }
        }

        return secondSmallest;
    }
}

// :: A3 : Traverse the arrray only ones and maintain two variables largest and 
// secondLargest || TC : O(n)  || SC : O(1)

class Solution{

    public int getSecondLargest(int[] arr){
        int largest = arr[0];
        int secondLargest = -1;

        for(int num : arr){
            if (num > largest){
                secondLargest = largest;
                largest = num;
            }
            else if(num > secondLargest){
                secondLargest = num;
            }
        }
        return secondLargest;
    }
}

// Q.3) Third largest of the array

// :: A1 : Sort the array and start traversing from back and find 1st second and third 
// accordingly

class Solution {
    public int thirdMax(int[] nums) {
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        Arrays.sort(nums);
        max1 = nums[nums.length - 1];

        for(int i=nums.length-1; i>=0; i--){
            if (nums[i] < max1){
                max2 = nums[i];
                for(int j=i-1; j>=0; j--){
                    if(nums[j] < max2){
                        max3 = nums[j];
                        return max3;
                    }
                }
                break;
            }
        }
        return max1;
    }
}

// :: A2 : Maintain the three max1, max2, max3 that will be updated every pass after a 
// element in array


// Q.4) 2 Sum in the array

// :: A1 -> Brutforce one 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int size = nums.length;
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if (i == j) continue;
                if (nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }

        return new int[]{-1,-1};
    }
}

// :: A2 : Optimal using a hashmap
class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int size = nums.length;
        for(int i=0; i<size; i++){
            if (map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}

// :: A3 : Just in case, you dont have to use hasmap, and just return two
// sum is present or not. ( If you want to return a indexes then use another data
// structure )

import java.util.Arrays;

public class Solution {
    public static String read(int n, int []book, int target){
        int left = 0;
        int right = n-1;

        Arrays.sort(book);

        while(left < right){
            int sum = book[left] + book[right];

            if ( sum == target) return "YES";
            else if (sum < target) left++;
            else right--;
        }
        return "NO";

    }
}

// Q.5) Sort the array of 0's, 1's and 2's

// :: A1 : Use simple brutforce of merge sort built in algorithm

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}

// :: A2 : Use simple method of counting the zeros, ones and two and then modify 
// the array.

class Solution {
    public void sortColors(int[] nums) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for(int i=0; i<nums.length; i++){
            if (nums[i] == 0 ) zeros++;
            else if (nums[i] == 1) ones++;
            else twos++;
        }

        int counter = 0;       
        for(int i=0; i<counter+zeros; i++){
            nums[i] = 0;
        }

        counter += zeros;
        for(int i=counter; i<counter+ones; i++){
            nums[i] = 1;
        }

        counter += ones;
        for(int i=counter; i<counter+twos; i++){
            nums[i] = 2;
        }
    }
}

// :: A3 : We use a Dutch National Flag Algorithm

class Solution {

    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    public void sortColors(int[] nums) {

        int low = 0, mid = 0, high = nums.length-1;

        while(mid <= high){
            if (nums[mid] == 0){
                swap(nums, mid, low);
                low++;
                mid++;
            }
            else if (nums[mid] == 1){
                mid++;
            }
            else{
                swap(nums, mid, high);
                high--;
            }
        }
    }
}

// Q.6) Majority element of the array

// :: A1 : Using Brutforce

class Solution {
    public int majorityElement(int[] nums) {
        
        int size = nums.length;
        for(int i=0; i<size; i++){
            int count = 0;
            for(int j=i; j<size; j++){
                if(nums[i] == nums[j]) count++;
            }
            if (count > size/2) return nums[i];
        }
        return -1;

    }
}

// :: A2 - Using hashmap

class Solution {
    public int majorityElement(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int halfSize = size / 2;
        for (int key : map.keySet()) {
            if (map.get(key) > halfSize) {
                return key;
            }
        }

        return -1;
    }
}

// :: A3 - Using Moore's algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int element = nums[0];

        for(int i=0; i<nums.length; i++){
            if (count == 0){
                count = 1;
                element = nums[i];
            }
            else if (nums[i] == element){
                count++;
            }
            else{
                count--;
            }
        }

        int counter = 0;
        for(int num : nums){
            if (num == element) counter++;
        }
        return counter > nums.length/2 ? element : -1;
    }
}

// :: Marks all the zeros   
