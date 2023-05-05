// Link : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//  # Algorithm : 
/*
      1. Maintaing two pointers left and right and unique counter
      2. Iterating over array search for unique element and place in correct
      position using the left pointer
      3. Return unique
*/

class Solution {

      public int removeDuplicates(int[] nums) {
            int l = 1;
            int r = 1;
            int unique = 1;

            while(r < nums.length){
                  if (nums[r-1] != nums[r]) {
                        unique++;
                        nums[l] = nums[r];
                        l++;
                        r++;
                  }
                  else r++;
            }
            return unique;
      }
}