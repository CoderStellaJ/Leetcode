/*
Runtime: 2 ms, faster than 84.39% of Java online submissions for Coin Change 2.
Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Coin Change 2.

Complexity: 
runtime: O(N^2)
space: O(N)

Algorithm 3: Dynamic Programming (Simplified)
You use a 2D array to avoid duplication that some coin[j] is not used.
We can actually reduce it to 1D array and make sure every large coin is used to avoid duplication.
What's the process?
1. the most outer loop is coins
   so, actually before any update, the previous array stores the situation that only previous coins are used
2. after the update, each amount is refreshed to the result that current coin may also be used.

Thus, we don't need the dimension to keep track of the coin
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int change(int amount, int[] coins) {
    int[] dp = new int[amount+1];
    //the amount using up to jth coin
    dp[0] = 1;
    for(int coin:coins){
      for(int i = 1; i <= amount; i++) {
        if(i >= coin) dp[i] += dp[i-coin];
      }
    }
    
    return dp[amount];
  }
}
///////////////////////////////////////////////////////////////////////////////
/*
Runtime: 142 ms, faster than 5.06% of Java online submissions for Coin Change 2.
Memory Usage: 40.5 MB, less than 22.54% of Java online submissions for Coin Change 2.

Complexity:
runtime: O(N^3)
space: O(MN)

Algorithm 2: DP
dp[amount][j] = SUM(dp[amount-k*coin[j]][j-1])  (k >= 0)
*/
///////////////////////////////////////////////////////////////////////////////
class Solution {
  public int change(int amount, int[] coins) {
    int[][] dp = new int[amount+1][coins.length+1];
    //the amount using up to jth coin
    for(int j = 0; j <= coins.length; j++) dp[0][j] = 1;
      
    for(int i = 1; i <= amount; i++){
      for(int j = 1; j <= coins.length; j++) {
        for(int k = 0; k <= i/coins[j-1]; k++) {
          dp[i][j] += dp[i-k*coins[j-1]][j-1];
        }
      }
    }
    return dp[amount][coins.length];
  }
}

///////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Complexity:
runtime: O(N^3)
space: O(1)

Algorithm 1: Recursion
For each coin, consider how many to choose and then proceed to the next coin
*/
//////////////////////////////////////////////////////
class Solution {
  public int change(int amount, int[] coins) {
    return helper(amount, 0, coins);
  }
  
  public int helper(int amount, int start, int[] coins) {
    if(amount == 0) return 1;   //note: success, means there is 1 way to make it work
    if(start >= coins.length) return 0;
    int ans=0;
    //amount > 0 and i < coins.length
    for(int i = 0; i <= amount/coins[start]; i++) {
      int sub = helper(amount-i*coins[start], start+1, coins);
      ans += sub;
    }
    return ans;
  }
}
