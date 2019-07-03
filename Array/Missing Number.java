/*
Runtime: 1 ms, faster than 41.92% of Java online submissions for Missing Number.
Memory Usage: 39.5 MB, less than 97.54% of Java online submissions for Missing Number.

Complexity:
runtime: O(N)
space: O(1)

Algorithm: swapping
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
  public int missingNumber(int[] nums) {
    int tmp = -1;
    for(int i = 0; i < nums.length; i++) {
      int k = nums[i];
      if(k == nums.length) {
        nums[i] = -1;
      }else if(k != -1 && k != i){
        tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
        i--;
      }
    }
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] == -1) return i;
    }
    return nums.length;
  }
}
