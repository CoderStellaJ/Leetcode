/*
Runtime: 12 ms, faster than 99.21% of C++ online submissions for Minimum Path Sum.
Memory Usage: 11.6 MB, less than 5.34% of C++ online submissions for Minimum Path Sum.

Complexity: O(N^2)

Algorithm: Dynamic programming

Syntax:
std::min(a, b);   //a and b should be the same type
*/
//////////////////////////////////////////////////////////////////////
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        long sum1, sum2;
        long value = 0;
        int row = grid.size();
        if(grid.empty()) return 0;
        int col = grid[0].size();
        for(int j = 0; j < col; j++) {
            value += grid[0][j];
        }
        for(int i = 1; i < row; i++) {
            value += grid[i][col-1];
        }
        vector<vector<long>> count(row, vector<long>(col, value));
        count[0][0] = grid[0][0];
        //initialize count
        for(int j = 1; j < col; j++) {
            count[0][j] = count[0][j-1] + grid[0][j];
        }
        for(int i = 1; i < row; i++) {
            count[i][0] = count[i-1][0] + grid[i][0];
        }
        //update dp
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                sum1 = count[i-1][j] + grid[i][j];
                sum2 = count[i][j-1] + grid[i][j];
                count[i][j] = std::min(std::min(sum1,sum2),count[i][j]);
            }
        }
	  return count[row-1][col-1];
    }
};
