/*
Runtime: 1 ms, faster than 90.06% of Java online submissions for Decode Ways.
Memory Usage: 34 MB, less than 86.07% of Java online submissions for Decode Ways.

Complexity:
runtime: O(N)
space: O(1)

Note:
For Dynamic programming, space can be improved to O(1) if only constant number of history data is needed.
You can directly use variables to record them instead of storing all into an array

Algorithm 3:
To optimize space utilities in algorithm 2
Can try to use O(1) to accumulate ans
ans2 ans1 ans align in this way and keep moving forward 

Syntax:
1. in java, string.charAt() is used to get char. The index way doesn't work
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int numDecodings(String s) {
      int ans1 = 0, ans2 = 0, ans = 0;
      for(int i = 0; i < s.length(); i++) {
        ans = 0;
        if(i == 0){
          if(s.charAt(0) != '0') ans2 = 1;
          ans = ans2;
        }else if(i == 1) {
          if(s.charAt(i) != '0') ans1 = ans2;
          int value = Integer.parseInt(s.substring(i-1, i+1));
          if(value >= 10 && value <= 26) ans1 += 1;
          ans = ans1;
        }else {
          if(s.charAt(i) != '0') ans += ans1;
          int value = Integer.parseInt(s.substring(i-1, i+1));
          if(value >= 10 && value <= 26) ans += ans2;
          if(ans1 == 0 && ans2 == 0) return ans;
          int tmp = ans1;
          ans1 = ans;
          ans2 = tmp;
        }
      }
      return ans;
    }
}
///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 4 ms, faster than 16.37% of Java online submissions for Decode Ways.
Memory Usage: 33.8 MB, less than 86.16% of Java online submissions for Decode Ways.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2:
Dynamic Programming
In Algorithm 1, the time-consuming part is there is intersection between subproblem of ans1 and ans2
And we can use DP to solve this problem

Note:
add one more element in dp array, then you should take care of the index when retrieving from dp array
*/
///////////////////////////////////////////////////////////////////
class Solution {
    public int numDecodings(String s) {
      int ans1 = 0, ans2 = 0;
      int[] dp = new int[s.length()+1];   //after adding one more into the array, pls take note of the index for the array
      dp[0] = 1;    
      dp[1] = (s.charAt(0) == '0')?0:1;
      for(int i = 1; i < s.length(); i++) {
        ans1 = (s.charAt(i) == '0')? 0:dp[i];
        int value = Integer.parseInt(s.substring(i-1,i+1));   //for string, the index is ok
        ans2 = (value <= 26 && value >= 10)? dp[i-1]:0;   
        dp[i+1] = ans1 + ans2;    //the index for dp array should +1
        if(dp[i+1] == 0) return 0;
      }
      return dp[s.length()];
    }
}
////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded	
"1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"

Complexity:
T(n) = T(n-1)+T(n-2)
runtime: Ω(2^(n/2))
space: O(N)

Algorithm 1:
Solve subproblems by using recursion

Syntax:
convert string to int
Integer.parseInt(mystr)
*/
/////////////////////////////////////////////////////////////////////
class Solution {
    public int numDecodings(String s) {
        int ans1 = 0, ans2 = 0;
        if(s.length() == 0) return 1;   //should be 1 given the question it won't take an empty string
        if(s.length() == 1){
          if(s.charAt(0) == '0') return 0;
          else return 1;
        }
        ans1 = (s.charAt(0) == '0')? 0:numDecodings(s.substring(1));
        int value = Integer.parseInt(s.substring(0,2));
        ans2 = ( value <= 26 && value >= 10)? numDecodings(s.substring(2)): 0;
        return ans1+ans2;
    }
}
