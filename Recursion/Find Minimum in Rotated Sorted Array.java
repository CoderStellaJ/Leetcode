/*
Question: confirm with the interviewer whether there is duplication in the array

Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
Memory Usage: 38.6 MB, less than 45.04% of Java online submissions for Find Minimum in Rotated Sorted Array.

Complexity:
runtime: O(logN)
space: O(1)   //don't consider recursion stack memory, just the variables

Algorithm: binary search + recursion
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int findMin(int[] nums) {
    return helper(nums,0,nums.length-1); 
  }
  public int helper(int[] nums, int start, int end){
    if(start > end) return -1;
    if(start == end) return nums[start];
    if(end == start+1) return Math.min(nums[start],nums[end]);
    //check whether it's really rotated
    // size >= 3
    if(nums[start] < nums[end]) return nums[start];
    int mid = (start+end)/2;
    int val = nums[mid];
    if(val > nums[start]) return helper(nums, mid+1,end);
    else {
      if(val < nums[mid-1]) return val;
      else return helper(nums,start+1,mid-1);
    }
  }
}
