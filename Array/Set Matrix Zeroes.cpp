/*
Runtime: 48 ms, faster than 99.43% of C++ online submissions for Set Matrix Zeroes.
Memory Usage: 11.4 MB, less than 86.35% of C++ online submissions for Set Matrix Zeroes.

Complexity: O(N^2)

Algorithm:
You scan through the whole 2D array, can't change the whole row/col to 0 once you find a 0.
Because there are other elements in the same row/col that affect other rows and cols.
So you can only use a vector to store zero rows and cols during scanning.

Syntax:
for(int k:myvec)
*/
///////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
      //matrix is empty, do nothing
        if(matrix.empty()) return;
        int row = matrix.size();
        int col = matrix[0].size();
        vector<int> zerorow;
        vector<int> zerocol;
        bool iszero = false;
        for(int i = 0; i < row; i++) {
          iszero = false;
          for(int j = 0; j < col; j++) {
            if(matrix[i][j] == 0) {
              iszero = true;
              if(find(zerocol.begin(), zerocol.end(), j) == zerocol.end())
                zerocol.push_back(j);
            }
          }
          if(iszero == true){
            zerrow.push_back(i);
          }
        }
      //change rows to 0
        for(int k:zerorow) {
          for(int j = 0; j < col; j++) {
            matrix[k][j] = 0;
          }
        }
      //change cols to 0
        for(int m:zerocol) {
          for(int i = 0; i < row; i++) {
            matrix[i][m] = 0;
          }
        }
    }
};
