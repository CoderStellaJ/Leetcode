/*
Runtime: 5 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix II.
Memory Usage: 43 MB, less than 99.98% of Java online submissions for Search a 2D Matrix II.

Complexity: 
runtime: O(m+n)
space: O(1)

Algorithm:
We need to find some keypoints/rules to help us move in the matrix when met with some conditions

This matrix has the following proprety:
Looking from top-right to bottom-left, 
the numbers on its right are larger than current num
and the numbers on its top are smaller than current number

i : starting row;  j: ending col.  These are the bounds for searching area
1. target == matrix[i][j]  true
2. target < matrix[i][j]  j--
3. target > matrix[i][j]  i++
*/
//////////////////////////////////////////////////////////////
class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0) return false;
    int row=0, col=matrix[0].length-1;
    while(row < matrix.length && col >= 0) {
      if(target == matrix[row][col]) return true;
      if(target < matrix[row][col]) col--;
      else row++;
    }
    return false;
  }
}
