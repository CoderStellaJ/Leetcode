/*
Runtime: 28 ms, faster than 28.16% of Java online submissions for Sliding Window Maximum.
Memory Usage: 41 MB, less than 82.51% of Java online submissions for Sliding Window Maximum.

Complexity:
runtime: O(kN) worst case for [6,5,4,3,2,1]
space: O(N)

Algorithm 1:
find the max in the window

Syntax:
1. print an array 
System.out.println(Arrays.toString(array));
2. create an empty array
int[] ans = new int[0];   //the size can be 0
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0) return new int[0];
    int[] ans = new int[nums.length-k+1];
    int max = getmax(nums, 0, k-1);
    ans[0] = max;
    for(int i = k; i < nums.length; i++) {
      if(nums[i] > ans[i-k]) ans[i-k+1] = nums[i];
      else ans[i-k+1] = getmax(nums,i-k+1,i);
    }
    return ans;
  }
  public int getmax(int[] nums, int start, int end) {
    int max = Integer.MIN_VALUE;
    for(int i = start; i <= end; i++) {
      max = Math.max(max,nums[i]);
    }
    return (start>end)? 0 : max;
  }
}
