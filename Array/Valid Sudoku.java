/*
Runtime: 4 ms, faster than 63.11% of Java online submissions for Valid Sudoku.
Memory Usage: 44.5 MB, less than 74.63% of Java online submissions for Valid Sudoku.

Complexity:
runtime: O(N^2)
space: O(N^2)

Algorithm 2: 1 iteration
Create a hashmap with value as a set.

Syntax:
1. Map<Integer, Set<Integer>> col = new HashMap<>();
here, Set<> with the bracket containing type it stores.

*/
/////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isValidSudoku(char[][] board) {
    //brute force
    Set<Integer> row = new HashSet<>();
    Map<Integer, Set<Integer>> col = new HashMap<>();
    Map<Integer, Set<Integer>> block = new HashMap<>();
    int len = board.length;
    
    for(int i = 0; i < len; i++) {
      row = new HashSet<>();
      for(int j = 0; j < len; j++) {
        if(board[i][j] != '.'){
          int num = board[i][j]-'0';
          //check row
          if(row.contains(num)) return false;
          else row.add(num);
          //check col
          if(col.containsKey(j) && col.get(j).contains(num)) return false;
          else {
            if(!col.containsKey(j)) col.put(j, new HashSet<Integer>());   //if doesn't exist, add the entry into map
            col.get(j).add(num);    //remember to add the current number into the set
          }
          //check block
          int blocknum = 3*(i/3)+(j/3+1);   //encoding i and j into the blocknum
          if(block.containsKey(blocknum) && block.get(blocknum).contains(num)) return false;
          else {
            if(!block.containsKey(blocknum)) block.put(blocknum, new HashSet<Integer>());
            block.get(blocknum).add(num);
          }
        }
      }
    }
    return true;
  }
}

//////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 3 ms, faster than 79.95% of Java online submissions for Valid Sudoku.
Memory Usage: 44.3 MB, less than 77.35% of Java online submissions for Valid Sudoku.

Complexity: 
runtime: O(N^2)
space: O(N^2)

Algorithm 1: brute force: 3 iterations
Use a hashset to store the values to check duplication

*/
//////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isValidSudoku(char[][] board) {
    //brute force
    //check row
    HashSet<Integer> myset = new HashSet<>();
    int len = board.length;
    for(int i = 0; i < len; i++) {
      myset = new HashSet<>();
      for(int j = 0; j < len; j++) {
        if(board[i][j] != '.'){
          int num = board[i][j]-'0';
          if(myset.contains(num)) return false;
          else myset.add(num);
        }
      }
    }
    //check column
    for(int j = 0; j < len; j++) {
      myset = new HashSet<>();
      for(int i = 0; i < len; i++) {
        if(board[i][j] != '.'){
          int num = board[i][j]-'0';
          if(myset.contains(num)) {
            //System.out.println("false: "+i+" "+j);
            return false;
          }
          else myset.add(num);
        }
      }
    }
    //check 3*3 block
    for(int i = 0; i < len; i+=3) {
      for(int j = 0; j < len; j+=3) {
        //the block top-left corner is [i][j]
        myset = new HashSet<>();
        for(int m = i; m < i+3; m++) {
          for(int n = j; n < j+3; n++) {
            if(board[m][n] != '.'){
              int num = board[m][n]-'0';
              if(myset.contains(num)) return false;
              else myset.add(num);
            }
          }
        }
      }
    }
    return true;
  }
}
