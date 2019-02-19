/*
Runtime: 20 ms, faster than 18.41% of C++ online submissions for Generate Parentheses.
Memory Usage: 17.2 MB, less than 100.00% of C++ online submissions for Generate Parentheses.

Algorithm:
Recursion!
1. write an auxiliary function to record ans, cur string, open and close. 
And here, ans should be reference type so that you can modify ans in the original field.
Record current string and modify it.
2. base case is when cur is of length 2n. 
3. condition for adding ")" is when close < open.

Syntax:
1. myvector.push_back(xxx)
2. c++ string type is : string

*/

////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        backtrack(ans, "", 0, 0, n);
        return ans;		
        }
    void backtrack(vector<string>& ans, string cur, int open, int close, int max) {
        if(cur.length() == max*2) {
            ans.push_back(cur);
            return;
        }
        if(open < max) {
            backtrack(ans, cur+"(", open+1, close, max);
        }
        if(close < open) {
            backtrack(ans, cur+")", open, close+1, max);
        }
    } 
};
