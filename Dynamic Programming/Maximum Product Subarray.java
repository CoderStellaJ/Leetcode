/*
Runtime: 2 ms, faster than 53.99% of Java online submissions for Maximum Product Subarray.
Memory Usage: 39.2 MB, less than 7.32% of Java online submissions for Maximum Product Subarray.

Complexity:
runtime:O(N)
space: O(N)

Algorithm 2:
For products, two negatives multiplied could be the max. 
So we need dp1[i] = max product ending at i, dp2[i]=min product ending at i. 
The reason we need dp2 is because if the current number is negative, product of dp2[i-1] and nums[i] could be the max we are looking for.
Please note that dp2[i] could be dp1[i-1] * nums[i] (may be dp1[i-1] could be positive and nums[i] is negative, we do not know)
*/
////////////////////////////////////////////////////////////////////
class Solution {
  public int maxProduct(int[] nums) {
    if(nums.length == 0) return 0;
    int max = nums[0];
    int n = nums.length;
    int[] mindp = new int[n];
    int[] maxdp = new int[n];
    mindp[0] = nums[0];
    maxdp[0] = nums[0];
    for(int i = 1; i < nums.length; i++) {
      mindp[i] = Math.min(Math.min(nums[i]*mindp[i-1], nums[i]*maxdp[i-1]),nums[i]);
      maxdp[i] = Math.max(Math.max(nums[i]*mindp[i-1], nums[i]*maxdp[i-1]),nums[i]);
      max = Math.max(max,maxdp[i]);
    }
    return max;
  }
}
/////////////////////////////////////////////////////////////////////
/*
Memory Limit Exceeded

Complexity:
runtime: O(N^2)
space: O(N^2)

Algorithm 1:
dp[i][j] denotes the multiplication result of subarray [i,j]
Note: 
1. can't use dp[j] for [0, j] and get subarray by using dp[j]/dp[i]
because once dp[i] is 0, the rest of the information is lost.
2. can't use the same algo as max subarray sum because a negative number doesn't mean the end of the subarray
as there may be more negative numbers in the latter part.

Corner case:
1. [-2,0,-1]
once 0 is encountered, the rest production information is lost and the result will always be 0
*/
//////////////////////////////////////////////////////////////////////
class Solution {
  public int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    int prod = 1;
    
    int[][] dp = new int[nums.length][nums.length];
    for(int i = 0; i < nums.length; i++) {
      dp[i][i] = nums[i];
      max = Math.max(max, dp[i][i]);
    }
    
    for(int i = 0; i < nums.length; i++) {
      for(int j = i+1; j < nums.length; j++) {
        dp[i][j] = dp[i][j-1]*nums[j];
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }
}
