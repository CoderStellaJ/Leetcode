/*
Runtime: 256 ms, faster than 37.13% of C++ online submissions for Word Search.
Memory Usage: 127.2 MB, less than 36.76% of C++ online submissions for Word Search.

Algorithm 2:
Improved from algorithm 1.
We directly mark board to '#' as visited before going into the next recursion. 
After recursion, change back the letter at the current posisiton to avoid impact on other paths.

*/
/////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        //locate the staring point
        if(board.empty()) return false;
        if(word == "") return false;
        int row = board.size();
        int col = board[0].size();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {    //O(n^2)
                if(check(board,i, j, word, 0) == true) {
                    return true;
                }
            }
        }
      return false;
    }
  
    bool check(vector<vector<char>>& board, int i, int j, string word, int k) {
        bool found = false;
        if(k == word.length()-1) {
          //last letter in string
            if(board[i][j] == word[k]) return true;
            return false;
        }else if(k > word.length()) {
            return false;
        }else {
            if(board[i][j] == word[k]){
                board[i][j] = '#';
                //check the 4 directions 
                if(i-1 >= 0) {
                    if(check(board, i-1, j, word, k+1) == true) found = true;
                }
                if(j-1 >= 0 && found == false) {
                    if(check(board, i, j-1, word, k+1) == true)  found = true;
                }
                if(j+1 < board[0].size() && found == false) {
                    if(check(board, i, j+1, word, k+1) == true)  found = true;
                }
                if(i+1 < board.size() && found == false) {
                    if(check(board, i+1, j, word, k+1) == true)  found = true;
                }
                board[i][j] = word[k];
            } 
            return found;
        }
    }
};

//////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm 1: Recursion
Every step check current position then recursively check its 4 neighbors
Here, pass 2D array visited by value to each call, which takes lots of time to copy the array. 
*/
//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        //locate the staring point
        if(board.empty()) return false;
        if(word == "") return false;
        vector<vector<bool>> visited(board.size(), vector<bool>(board[0].size(), false));
        int row = board.size();
        int col = board[0].size();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {    //O(n^2)
                if(check(board, visited, i, j, word, 0) == true) {
                    return true;
                }
            }
        }
      return false;
    }
  
    bool check(vector<vector<char>>& board, vector<vector<bool>> visited, int i, int j, string word, int k) {
        if(k == word.length()-1) {
          //last letter in string
            if(visited[i][j] == false && board[i][j] == word[k]) return true;
            return false;
        }else if(k > word.length()) {
            return false;
        }else {
            if(visited[i][j] == false && board[i][j] == word[k]){
                visited[i][j] = true;
                //check the 4 directions 
                if(i-1 >= 0) {
                    if(check(board, visited, i-1, j, word, k+1) == true) return true;
                }
                if(j-1 >= 0) {
                    if(check(board, visited, i, j-1, word, k+1) == true) return true;
                }
                if(j+1 < board[0].size()) {
                    if(check(board, visited, i, j+1, word, k+1) == true) return true;
                }
                if(i+1 < board.size()) {
                    if(check(board, visited, i+1, j, word, k+1) == true) return true;
                }
            }
            return false;
        }
    }
};
