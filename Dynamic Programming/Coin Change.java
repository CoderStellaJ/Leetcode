/*
Runtime: 12 ms, faster than 66.00% of Java online submissions for Coin Change.
Memory Usage: 36.1 MB, less than 98.83% of Java online submissions for Coin Change.

Complexity:
runtime: O(MN)
space:O(N)

Algorithm: Dynamic Programming
consider each coin every time
*/
/////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    //initialization
    dp[0] = 0;
    for(int i = 1; i < dp.length; i++) {
      dp[i] = -1;
    }
    for(int i = 1; i < dp.length; i++) {
      for(int j = 0; j < coins.length; j++) {
        int money = coins[j];
        if(i - money >= 0) {
          int prev = dp[i-money];
          if(prev != -1){
            if(dp[i] == -1) dp[i] = prev+1;
            else dp[i] = Math.min(dp[i], prev+1);
          }
        }
      }
    }
    return dp[amount];
  }
}
