// :: Binary Search Questions

// # Why Binary Search is called Binary : Becuase we divide the array into two parts, search in 
// one of those two area and again divide so, we are divide into two always so thats why it is
// called as binary search

// Q.1) Simple Binary Search in sorted array

public class BinarySearch{

    public int binarySearch(int[] arr, int target){

        int size = arr.length;
        int left = 0;
        int right = size - 1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target) return mid;
            else if (target < arr[mid] ) right = mid - 1;
            else left = mid + 1;
        }

        return -1;
    }
}

// Q.2) Search in reverse sorted array

public class BinarySearchInReverseSorted{

    public int binarySearch(int[] arr, int target){

        int size = arr.length;
        int left = 0;
        int right = size - 1;

        while(left <= right ){
            int mid = start + (end-start)/2;

            if (arr[mid] == target) return mid;
            else if (target < arr[mid]) left = mid + 1;
            else right = mid - 1;
        }

        return -1;
    }
}

// Q.3) Find element in array, where sorted order is not given

public class AgnosticBinarySearch{

    public int binarySearch(int[] arr, int target, boolean isReversed){

        int size = arr.length;
        int left = 0;
        int right = size - 1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target) return mid;
            if (isReversed){
                if(target < arr[mid]) left = mid + 1;
                else right = mid - 1;
            }
            else{
                if(target < arr[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
    }

    public int agnosticBinarySearch(int[] arr, int target){
        if (arr.length >= 1 && arr[0] < arr[arr.length - 1]) return binarySearch(arr, target, false);
        return binarySearch(arr, target, true);
    }
}

// Q.4) First and Last Occurence of element

public class FirstAndLastOccurence{

    public int bSForFirstOccurence(int[] arr, int target){
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int firstOccurence = -1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                 firstOccurence = mid;
                 right = mid - 1;
            }
            else if (target < arr[mid] ) right = mid - 1;
            else left = mid + 1;
        }

        return firstOccurence;
    }

    public int bSForLastOccurence(int[] arr, int target){
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int lastOccurence = -1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                 lastOccurence = mid;
                 left = mid + 1;
            }
            else if (target < arr[mid] ) right = mid - 1;
            else left = mid + 1;
        }

        return lastOccurence;
    }

    public int[] firstAndLastOccurence(int[] arr, int target){
        int firstOccurence = bSForFirstOccurence(arr, target);
        int lastOccurence = bSForLastOccurence(arr, target);

        return new int[]{firstOccurence, lastOccurence};
    }
}

// Q.5) Count of target element in array 

public class CountOfTarget{

    public int bSForFirstOccurence(int[] arr, int target){
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int firstOccurence = -1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                 firstOccurence = mid;
                 right = mid - 1;
            }
            else if (target < arr[mid] ) right = mid - 1;
            else left = mid + 1;
        }

        return firstOccurence;
    }

    public int bSForLastOccurence(int[] arr, int target){
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int lastOccurence = -1;

        while(left <= right){
            int mid = start + (end-start)/2;

            if (arr[mid] == target){
                 lastOccurence = mid;
                 left = mid + 1;
            }
            else if (target < arr[mid] ) right = mid - 1;
            else left = mid + 1;
        }

        return lastOccurence;
    }

    public int[] countOfTarget(int[] arr, int target){
        int firstOccurence = bSForFirstOccurence(arr, target);
        int lastOccurence = bSForLastOccurence(arr, target);

        return (lastOccurence - firstOccurence + 1);
    }
}

// Q.6) Number of times array is sorted

public class NumberOfTimesArraySorted{

    public int numberOfTimesArraySorted(int[] arr){
        // For array find index of minimum element that answer
        int size = arr.length;
        int left = 0;
        int right = size - 1;

        int minIndex = -1;

        if (size == 1) return 0;

        while(left <= right){
            int mid = left + (right-left)/2;
            int prev = (mid+1)%size;
            int next = (mid-1+size)%size;

            if (arr[mid] < arr[prev] && arr[next] > arr[mid]){
                 minIndex = mid;
                 break;
            }
            else if (arr[mid] < arr[right]) right = mid - 1;
            else left = mid + 1;
        }

        return minIndex;
    }
}

// Q.7) Search in the Rotated array

class SearchInRotatedArray{
    
    public int numberOfTimesArraySorted(int[] arr){
        // For array find index of minimum element that answer
        int size = arr.length;
        int left = 0;
        int right = size - 1;

        int minIndex = -1;

        if (size == 1) return 0;

        while(left <= right){
            int mid = left + (right-left)/2;
            int prev = (mid+1)%size;
            int next = (mid-1+size)%size;

            if (arr[mid] < arr[prev] && arr[next] > arr[mid]){
                 minIndex = mid;
                 break;
            }
            else if (arr[mid] < arr[right]) right = mid - 1;
            else left = mid + 1;
        }

        return minIndex;
    }

    public int binarySearch(int[] arr, int left, int right, int target){
        if (left <= right) {
            int mid = left + (right-left)/2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) return binarySearch(arr, left, mid-1, target);
            else return binarySearch(arr, mid+1, right, target);
        }
        return -1;
    }

    public int search(int[] arr, int target) {
        int minIndex = numberOfTimesArraySorted(arr);
        System.out.println(minIndex);
        int index1 = binarySearch(arr, 0, minIndex-1, target);
        int index2 = binarySearch(arr, minIndex, arr.length-1, target);

        if (index1 == -1) return index2;
        return index1;
    }
}

// Q.8)  Searching in a nearly sorted array

public class SearchInNearlySorted{

    public int searchInNearlySorted(int[] arr, int target){

        int size = arr.length;
        int left = 0;
        int right = size - 1;

        while(left <= right){
            int mid = start + (end-start)/2;
            int prev = (mid - 1 + size)%size;
            int next = (mid + 1 )%size;

            if (arr[mid] == target || arr[mid] == arr[prev] || arr[mid] == arr[next] ) return mid;
            else if (target <= arr[mid-2] ) right = mid - 2;
            else left = mid + 2;
        }

        return -1;
    }
}

// Q.9) Finding the floor of the number
class FloorOfNumber{

    public int getFloorOfNumber(int[] arr, int target){
        
        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int floorIndex = -1;

        while(left <= right){
            int mid = start + (end - start)/2;

            if (arr[mid] == target){
                floorIndex = mid;
                return floorIndex;
            }
            else if (arr[mid] < target){
                floorIndex = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return floorIndex;
    }
}

// Q.10) Finding the floor of the number
class CeilOfNumber {

    public int getCeilOfNumber(int[] arr, int target) {

        int size = arr.length;
        int left = 0;
        int right = size - 1;
        int ceilIndex = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                ceilIndex = mid;
                return ceilIndex;
            } 
            else if (arr[mid] > target) {
                ceilIndex = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return ceilIndex;
    }
}


// Q.11) Next Character 
class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        char result=letters[0];
        int start=0;
        int end=letters.length-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(letters[mid]==target){
                start=mid+1;
            }
            else if(target>letters[mid]){
                start=mid+1;
            }
            else{
                result=letters[mid];
                end=mid-1;
            }
        }
        return result;
    }
}

// Q. 12) Find the position of the element in infinite sorted array
class FindElementInInfiteSorted {
    
    public int findPositionOfElement(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while (arr[end] < target) {
            start = end + 1;
            end = end * 2;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) 
                return mid;
            else if (arr[mid] < target) 
                start = mid + 1;
            else 
                end = mid - 1;
        }

        return -1;
    }
}

// Q. 13) Find index of 1 in infinite binary sorted array
class FindElementInBinaryInfiteSorted{
    
    public int findPositionOfElement(int[] arr, int target) {
        int start = 0;
        int end = 1;
        int firstIndex = -1;

        while(arr[end] != 1){
            start = end+1;
            end = end*2;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target){
                firstIndex = mid;
                end = mid - 1;
            }
            else if (arr[mid] < target){
                start = mid + 1;
            }
            else{
                end = mid-1;
            }
        }

        return firstIndex;
    }
}

// Q. 14) Find the minimum difference element in the array

class MinimumDifferenceElement {
    
    public int getMinimumDifferenceElement(int[] arr, int target) {
        int size = arr.length;
        int left = 0;
        int right = size - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return arr[mid];
            else if (target < arr[mid])
                right = mid - 1;
            else
                left = mid + 1;
        }

        // If the target element is not found, return the element with the minimum difference
        int firstDiff = Math.abs(arr[left] - target);
        int secondDiff = Math.abs(arr[right] - target);

        return (firstDiff < secondDiff ? arr[left] : arr[right]);
    }
}

// Q. 15) Find the maximum element in bitonic array
class MaximumInBitonicArray {

    public int getMaximumInBitonicArray(int[] arr) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid > 0 && arr[mid - 1] < arr[mid] && mid < size - 1 && arr[mid] > arr[mid + 1])
                return arr[mid];
            else if (mid > 0 && arr[mid - 1] < arr[mid] && mid < size - 1 && arr[mid] < arr[mid + 1])
                start = mid + 1;
            else
                end = mid - 1;
        }

        // Return -1 if the maximum element is not found (optional)
        return -1;
    }
}


// Q. 16) Search in Bitonic array
class SearchInBitonicArray {

    public int searchInBitonicArray(int[] arr, int target) {
        int peakIndex = findPeakIndex(arr);

        int leftResult = binarySearchAscending(arr, 0, peakIndex, target);
        int rightResult = binarySearchDescending(arr, peakIndex + 1, arr.length - 1, target);

        if (leftResult != -1) {
            return leftResult;
        } else if (rightResult != -1) {
            return rightResult;
        } else {
            return -1;
        }
    }

    private int findPeakIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private int binarySearchAscending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private int binarySearchDescending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
