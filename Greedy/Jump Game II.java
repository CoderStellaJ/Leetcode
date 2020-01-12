/*
Runtime: 2 ms, faster than 67.44% of Java online submissions for Jump Game II.
Memory Usage: 39.8 MB, less than 87.40% of Java online submissions for Jump Game II.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2: Greedy algorithm
the positions nearer to start will always have smaller or equal steps to reach
so we just need to consider the position that can not be reached by positions on the left

Thus, in this algorithm:
1. no comparison before updating the #step for each node
2. no duplication, each position is assigned value for once
3. no initialization
*/
//////////////////////////////////////////////////////////////////
class Solution {
    public int jump(int[] nums) {
      int len = nums.length;
      if(len == 0 || len == 1) return 0;
      int[] dp = new int[len];
      //initialization
      dp[0] = 0;
      int k = 0;  //the farest updated position
      for(int i = 0; i < len-1; i++) {
        int maxjump = nums[i];
        int jump = dp[i]+1;
        for(int j = k+1-i; j <= maxjump && (i+j)<len; j++) {
          dp[i+j] = jump;
          k = i+j;
          if(k == len-1) return dp[len-1];
        }
      }
      return dp[len-1];
    }
}

///////////////////////////////////////////////////////////////////
/*
Runtime: 269 ms, faster than 16.96% of Java online submissions for Jump Game II.
Memory Usage: 41.1 MB, less than 29.68% of Java online submissions for Jump Game II.

Complexity:
runtime:O(N^2)
space: O(N)

Algorithm 1: Dynamic Programming + Brute force
Loop through each element once
*/
/////////////////////////////////////////////////////////////////////
class Solution {
public int jump(int[] nums) {
      int len = nums.length;
      if(len == 0 || len == 1) return 0;
      int[] dp = new int[len];
      //initialization
      dp[0] = 0;
      for(int i = 1; i < len; i++) dp[i] = i;
      for(int i = 0; i < len-1; i++) {
        int maxjump = nums[i];
        int jump = dp[i]+1;
        for(int j = 1; j <= maxjump && (i+j)<len; j++) {
          dp[i+j] = (jump < dp[i+j])? jump:dp[i+j];
        }
      }
      return dp[len-1];
    }
}
