/*
Runtime: 23 ms, faster than 53.31% of Java online submissions for Maximal Rectangle.
Memory Usage: 104.7 MB, less than 5.01% of Java online submissions for Maximal Rectangle.

Complexity:
runtime: O(N^3)
space: O(N^3)

Algorithm: Dynamic Programming
1. dp(i,j,r)  is the length of the rectangle whose bottom right is in (i,j) and width is r
2. width: y axis; length: x axis;
3. Every time you are trying to determine the max length of (i,j) for specific width r.
So, to extend length, you need to check (i, j-1) for width r
4. dp(i,j,r) = dp(i, j, r) + 1
*/
///////////////////////////////////////////////////////////////////////////////
class Solution {
   public int maximalRectangle(char[][] matrix) {
    //corner case
    if(matrix.length == 0 || matrix[0].length == 0) return 0;  
    int row = matrix.length, col = matrix[0].length, ans=0;
    int[][][] dp = new int[row][col][row+1];
    //row+1 for width because it ranges from 0 to number of columns
    //by default, initialized to 0 for the whole array
    for(int i = 0; i < row; i++) {
      for(int j = 0; j < col; j++) {
        if(matrix[i][j] == '0') continue;     //check whether itself is '1'
        for(int r = 1; r <= i+1; r++) {
          //the width starts from 1 for the rectangle
          if(matrix[i-r+1][j] == '0') break;    //check '1' in the y axis direction to make sure this col can be extended for length
          dp[i][j][r] = (j > 0)? dp[i][j-1][r]+1:1; 
          ans = Math.max(ans, dp[i][j][r]*r);
        }
      }
    }
    return ans;
  }
}
