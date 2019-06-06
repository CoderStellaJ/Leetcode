/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for House Robber.
Memory Usage: 34.2 MB, less than 99.96% of Java online submissions for House Robber.

Algorithm: Dynamic Programming
Note: not adjacent means after choosing i, it's not necessary to choose i+2
dp[i] records the max amount it can rob up to ith element in nums
if choose i, dp[i] = dp[i-2]+nums[i]
if not choose i, dp[i] = dp[i-1]
Then assign it the maximum value between 2 choices
*/
///////////////////////////////////////////////////////////////////////////////
class Solution {
      public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);   //this is important:choose max value
        for(int i = 2; i < nums.length; i++){
          int choose = nums[i]+dp[i-2];
          int not = dp[i-1];
          dp[i] = Math.max(choose, not);
        }
        return dp[nums.length-1];
      }
}
