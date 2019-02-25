/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Rotate Image.
Memory Usage: 9.3 MB, less than 16.97% of C++ online submissions for Rotate Image.

Algorithm:
note the boundary of i and j to avoid duplicate rotations. j <= (n-2)/2
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void rotate(vector<vector<int>>& matrix) {
        int tmp;
        int n = matrix.size();
        for(int i = 0; i <= (n-1)/2; i++) {
            for(int j = 0; j <= (n-2)/2;j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = tmp;	
            }
        }
    }
};
