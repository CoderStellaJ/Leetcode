/*
Runtime: 6 ms, faster than 76.38% of Java online submissions for Sudoku Solver.
Memory Usage: 39.7 MB, less than 18.35% of Java online submissions for Sudoku Solver.

Algorithm: DFS
For each empty cell, check whether it fulfills requirement for row, col and box
*/
//////////////////////////////////////////////////////////////////////
class Solution {
  private boolean usedRow(char[][] board, int row, char num) {
    for(int i=0; i<board[0].length; i++) if(board[row][i] == num) return true;
    return false;
  }
  
  private boolean usedCol(char[][] board, int col, char num) {
    for(int i = 0; i < board.length; i++) if(board[i][col] == num) return true;
    return false;
  }
  
  private boolean usedBox(char[][] board, int startRow, int startCol, char num) {
    for(int i = 0; i < 3; i++) {
      for(int j = 0; j < 3; j++) {
        if(board[i+startRow][j+startCol] == num) return true;
      }
    }
    return false;
  }
  
  private boolean isSafe(char[][] board, int row, int col, char num) {
    return !usedRow(board, row, num) && !usedCol(board, col, num) && !usedBox(board, row-row%3, col-col%3, num) && board[row][col] == '.'; 
  }
  
  private int[] getNext(char[][] board) {   //return the next empty position
    for(int i = 0; i < board.length; i++) {
      for(int j = 0; j < board[0].length; j++) {
        if(board[i][j] == '.') return new int[]{i,j};
      }
    }
    return null;
  }
  
  private boolean solve(char[][] board) {
    int[] next = getNext(board);
    if(next == null) return true;
    int row = next[0], col = next[1];
    for(char c = '1'; c <= '9'; c++) {
      if(isSafe(board, row, col, c)) {
        board[row][col] = c;
        if(solve(board)) return true;   //go into depth to solve the problem
        else board[row][col] = '.';     //if it doesn't satisfy the requirement, change it back to empty
      }
    }
    return false;
  }
  
  public void solveSudoku(char[][] board) {
    if(solve(board));      
  }
}
