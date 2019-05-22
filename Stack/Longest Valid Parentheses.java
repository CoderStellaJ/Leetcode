/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
Memory Usage: 35.9 MB, less than 97.22% of Java online submissions for Longest Valid Parentheses.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 4:
from left to right
from right to left
use the number of '(' or ')' to determine whether it's valid
*/
////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestValidParentheses(String s) {
      int left = 0, right = 0;
      int maxlen = 0;
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == '(') left++;
        else right++;
        if(left == right) maxlen = Math.max(maxlen, right*2);
        else if(right > left) {
          right = 0;
          left = 0;
        }
      }
      left = 0;   //remember to reset to 0 !!!
      right = 0;
      for(int i = s.length()-1; i >= 0; i--) {
        char c = s.charAt(i);
        if(c == '(') left++;
        else right++;
        if(left == right) maxlen = Math.max(maxlen,left*2);
        else if(left > right){
          left = 0;
          right = 0;
        }
      }
      return maxlen;
    }
}
/////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 44.82% of Java online submissions for Longest Valid Parentheses.
Memory Usage: 36.7 MB, less than 93.34% of Java online submissions for Longest Valid Parentheses.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 3: Pure Stack
After observation, we find that the remaining indices in the stack help to seperate out valid substrings
so we just need to count the length between left indices in stack
*/
////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestValidParentheses(String s) {
      if(s.length() == 0) return 0;
      Stack<Integer> mystack = new Stack<Integer>();
      int maxlen = 0;
      for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if(c == '(') mystack.push(i);
        else if(c == ')'){
          if(!mystack.isEmpty() && s.charAt(mystack.peek()) == '(') mystack.pop();
          else mystack.push(i);
        }
      }
      int end = s.length();
      int value = 0;
      while(!mystack.isEmpty()){
        value = mystack.pop();
        if(end-value-1 > maxlen) maxlen = end-value-1;
        end = value;
      }
      if(end > maxlen) maxlen = end;
      return maxlen;  
    }
}
///////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Complexity:
runtime: O(N^3)
space: O(N^3)

Algorithm 2: Dynamic Programming
Partially improved from Algorithm 1 by recording down subproblem result
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestValidParentheses(String s) {
      if(s.length() == 0) return 0;
      int len = s.length();
      boolean[][] dp = new boolean[len][len];
      int maxlen = 0;
      for(int k = 2; k <= len; k+=2) {
        //consider the even length of the substring
        for(int i = 0; i <= len-k; i++) {
          int j = i+k-1;
          if(k == 2) dp[i][j] = (isvalid(s,i,j) == true);
          else{
            if(dp[i+1][j-1] == true) {
              if(s.charAt(i) == '(' && s.charAt(j) == ')') {
                dp[i][j] = true;
                maxlen = k;
              }else dp[i][j] = false;
            }else {
              dp[i][j] = (isvalid(s,i,j) == true);
              if(dp[i][j] == true) maxlen = k;
            }
          }
        }
      }
      return maxlen;  
    }
  
    public boolean isvalid(String s, int start, int end){
      Stack<Character> mystack = new Stack<Character>();
      for(int i = start; i <= end; i++) {
        char c = s.charAt(i);
        if(c == '(') mystack.push(c);
        else if(c == ')'){
          if(!mystack.isEmpty() && mystack.peek() == '(') mystack.pop();
          else mystack.push(c);
        }
      }
      return mystack.isEmpty() ? true:false;
    }
}
//////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Complexity:
runtime: O(N^3)
space: O(N^3)

Algorithm 1: brute force
check substring one by one with the help of an extra function
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestValidParentheses(String s) {
      if(s.length() == 0) return 0;
      int len = s.length();
      int maxlen = 0;
      for(int i = 0; i < len; i++) {
        for(int j = 0; j < i; j++) {
          if(isvalid(s,j,i) == true){
            if(i-j+1 > maxlen) maxlen = i-j+1;
          }
        }
      }
      return maxlen;  
    }
  
    public boolean isvalid(String s, int start, int end){
      Stack<Character> mystack = new Stack<Character>();
      for(int i = start; i <= end; i++) {
        char c = s.charAt(i);
        if(c == '(') mystack.push(c);
        else if(c == ')'){
          if(!mystack.isEmpty() && mystack.peek() == '(') mystack.pop();
          else mystack.push(c);
        }
      }
      return mystack.isEmpty() ? true:false;
    }
}
