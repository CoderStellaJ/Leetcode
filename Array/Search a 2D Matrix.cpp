/*
Runtime: 12 ms, faster than 98.45% of C++ online submissions for Search a 2D Matrix.
Memory Usage: 9.7 MB, less than 100.00% of C++ online submissions for Search a 2D Matrix.

Algorithm:
compare each row's first element with target to determine which row it belongs to
and use binary search to search in the row

Syntax:
1. About vector size:
vector<vector<int>> matrix
[] : matrix.empty() is true
[[]] : matrix.empty() is false, rowsize = 1, colsize = 0

Habit:
always try to initialize a variable when it's declared.
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if(matrix.empty()) return false;
        int rowsize = matrix.size();
        int colsize = matrix[0].size();
        if(colsize == 0) return false;
        int row = rowsize-1;    //row may not go into if() part, need initialization.
        for(int i = 0; i < rowsize; i++) {
          if(matrix[i][0] > target) {
           //we should search in i-1 th row
            if(i-1 < 0) return false;
            row = i-1;
            break;
          }
        }
        if(matrix[row][colsize-1] >= target) {
          return bisearch(matrix[row], target, 0, colsize-1); 
        }
        return false;
    }
  //binary search target value
    bool bisearch(vector<int>& myrow, int target, int left, int right) {
        if(left > right) return false;
        int mid = (left + right)/2;
        if(myrow[mid] == target) return true;
        else if(myrow[mid] < target) {
            return bisearch(myrow, target, mid+1,right); 
        }else {
            return bisearch(myrow, target, left, mid-1); 
        }
        return false;
    }
};
