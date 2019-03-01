/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Spiral Matrix.
Memory Usage: 8.9 MB, less than 14.80% of C++ online submissions for Spiral Matrix.

Algorithm: use Recursion to create the spiral matrix from outer to inner part

Note:
1. check whether a matrix is empty or not before accessing any of its element
2. The base cases are:
  the suibmatrix is empty
  submatrix is just one row
  submatrix is just one column
  submatrix is only one element
*/
////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> ans;
        if(matrix.empty()) return ans;    //check whether it's empty first
        spiral(matrix, 0, matrix.size()-1, 0, matrix[0].size()-1, ans);
     	  return ans;   
    }
    void spiral(vector<vector<int>>& matrix, int rowStart, int rowEnd,int colStart,int colEnd, vector<int>& ans) {
        if(rowEnd < rowStart || colEnd < colStart) {
          return;
        }
        if(rowStart == rowEnd && colStart == colEnd) {
          ans.push_back(matrix[rowStart][rowEnd]);
          return;
        }
        if(rowStart == rowEnd) {
          for(int j = colStart; j <= colEnd; j++ ) {
            ans.push_back(matrix[rowStart][j]);
          }
          return;
        }
        if(colStart == colEnd) {
          for(int i = rowStart; i <= rowEnd; i++) {
            ans.push_back(matrix[i][colEnd]);
          }
          return;
        }
        for(int j = colStart; j <= colEnd; j++ ) {
          ans.push_back(matrix[rowStart][j]);
        }
        for(int i = rowStart+1; i <= rowEnd; i++) {
          ans.push_back(matrix[i][colEnd]);
        }
        for(int j = colEnd-1; j >= colStart; j--) {
          ans.push_back(matrix[rowEnd][j]);
        }
        for(int i = rowEnd-1; i > rowStart; i--){
          ans.push_back(matrix[i][colStart]);
        }
        spiral(matrix, rowStart+1,rowEnd-1,colStart+1,colEnd-1,ans);
    }
};
