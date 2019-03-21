/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Unique Paths.
Memory Usage: 8.5 MB, less than 48.25% of C++ online submissions for Unique Paths

Complexity: O(N^2)

Algorithm 1:
Math calculations: (m+n-2)!/((m-1)!*(n-1)!). Problem: integer exceeds range

Algorithm 2:
Recursion: recursive relationship: ans[n][m] = ans[n][m-1] + ans[n-1][m]; Problem: Time limit exceeded

Algorithm 3:
Dynamic programming to avoid duplicate calculations in recursion
*/
///////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> dp(n, vector<int>(m));	
        for(int i = 0; i < n; i++) {
            dp[i][0] = 1; 
        }
        for(int j = 0; j < m; j++) {
            dp[0][j] = 1;
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j]; 
            } 
        }
        return dp[n-1][m-1];
    }

};
