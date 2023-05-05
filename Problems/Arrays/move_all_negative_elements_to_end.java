// # Link : https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1
// # Algorithm -  Without extra space
/*
    1. Iterate over the array for every element from idx 1
    2. Check is it positive or negative
    3. If the current one is positive and prev one negative
        then I'll swap them, again same until I found prev is 
        positive or its 0th index (Maintain one pointer)
*/

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        // Iterate over array
        for(int i=1; i<n; i++){

            // Check for positive element
            if(arr[i] >=0 ){
								// Store curr and prev element and swap them if 
								// prev is -ve and curr is +ve
                int curr = i;
                int prev = curr-1;
                while(prev >=0 && arr[prev] < 0){
                    int temp = arr[curr];
                    arr[curr] = arr[prev];
                    arr[prev] = temp;
                    
                    curr = curr - 1;
                    prev = curr - 1;
                }
            }
            else continue;
        }
    }
}