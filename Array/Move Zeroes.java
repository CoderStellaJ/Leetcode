/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
Memory Usage: 37 MB, less than 96.52% of Java online submissions for Move Zeroes.

Complexity:
Runtime: O(N)
Space: O(1)

Algorithm:
iterate thru the array and use an index to record the index of next non-zero number
Note:
index checking should be placed before && and using it

Syntax:
1. array length:
myarr.length
*/
///////////////////////////////////////////////////////////////////////////////
class Solution {
    public void moveZeroes(int[] nums) {
      int tmp;
      int j = 0;  //record the next integer's index
      for(int i = 0; i < nums.length; i++, j++) {
        if(nums[i] == 0) {
          while(j < nums.length && nums[j] == 0){
            j++;
          }
          if(j >= nums.length) return;``//check which condition is violated before accessing the element
          tmp = nums[j];
          nums[j] = nums[i];
          nums[i] = tmp;
        }
      }
    }
}
