/*
Runtime: 7 ms, faster than 34.84% of Java online submissions for Edit Distance.
Memory Usage: 36.4 MB, less than 66.02% of Java online submissions for Edit Distance.

Complexity:
runtime: O(MN)
space: O(MN)

Algorithm: Dynamic Programming
1. if word1[i-1] == word2[j-1], no changes made: dp[i][j] = dp[i-1][j-1]
2. else:
    add word1[i] mapped to word2[j-1], add one char to word1 to match word2[j]
    delete word1[i-1] mapped to word2[j], delete word1[i]
    replace word1[i] to word2[j]
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
  public int minDistance(String word1, String word2) {
    int row = word1.length(), col = word2.length();
    int[][] dp = new int[row+1][col+1];
    //initialization
    for(int i = 0; i < row+1; i++) dp[i][0] = i;
    for(int j = 0; j < col+1; j++) dp[0][j] = j;
    //dp
    for(int i = 1; i < row+1; i++) {
      for(int j = 1; j < col+1; j++) {
        if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp [i-1][j-1];
        else{
          int add = dp[i][j-1]+1;
          int delete = dp[i-1][j] + 1;
          int rep = dp[i-1][j-1] + 1;
          dp[i][j] = Math.min(Math.min(add,delete),rep);
        }
      }
    }
    return dp[row][col];
  }
}
