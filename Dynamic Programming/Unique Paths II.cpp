/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Unique Paths II.
Memory Usage: 9.4 MB, less than 20.17% of C++ online submissions for Unique Paths II.

Complexity:O(N^2)

Algorithm: Dynamic programming.
Note: Compared to Unique Paths problem, the specialty is once there is an obstacle in the first col or row, 
you cannot reach the next position in that col/row.

Syntax:
1. for problems involving large numbers, change int to long type.

Corner case:
there is an obstacle at [0][0]
*/
/////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        //size of the grid
        if(obstacleGrid.empty()) return 0;
        //size of the grid
        int row = obstacleGrid.size(), col = obstacleGrid[0].size();
            vector<vector<long>> dp(row,vector<long>(col,1));
        
        //initialize dp
        for(int j = 0; j < col; j++) {
            if(obstacleGrid[0][j] == 1) {
                for(int k = j; k < col; k++) {
                    dp[0][k] = 0;
                }
                break;
            }
        }
        for(int i = 0; i < row; i++) {    //also need to start from 0 if [0][0] is an obstacle
            if(obstacleGrid[i][0] == 1) {
                for(int k = i; k < row; k++) {
                    dp[k][0] = 0;
                }
                break;
            }
        }
        //update dp
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
};
