/*
Runtime: 2 ms, faster than 98.16% of Java online submissions for Regular Expression Matching.
Memory Usage: 35.3 MB, less than 99.99% of Java online submissions for Regular Expression Matching.

Algorithm 2:
Recursion can be optimized using Dynamic Programming sometimes.
dp(i, j): does s[i:] and p[j:] match 
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean [s.length()+1][p.length()+1];    //the size is larger by 1 so that you can match the last char
        dp[s.length()][p.length()] = true;
        for(int i = s.length(); i >= 0; i--) {    
        // i start from s.length()
        // otherwise, case "aa" and "a*" fails
        // this helps to cover the case of "" and "" 
            for(int j = p.length()-1; j >= 0; j--) {
            //start from p.length()-1 to make sure dp[][j+1] is valid
                boolean firstMatch = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if(j < p.length()-1 && p.charAt(j+1) == '*') {
                    dp[i][j] = dp[i][j+2] || (firstMatch && dp[i+1][j]);
                }else {
                    dp[i][j] = firstMatch && dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 56 ms, faster than 24.47% of Java online submissions for Regular Expression Matching.
Memory Usage: 40 MB, less than 26.39% of Java online submissions for Regular Expression Matching.

Complexity:
https://leetcode.com/problems/regular-expression-matching/solution/

Algorithm 1: Recursion
For string matching questions, Recursion can help us to solve problem.
Every time we just consider part of the string and recursively solve the problem.
Without * sign, the solution should be straightforward
For * sign, there are 2 options:
1. remove this part of the pattern "s*"
2. keep using it to eliminate the next char in s

Syntax:
1. StringBuilder remove some characters
str.delete(4, 9);   //remove [4,9)
2. substring index
beginindex can be equal to string length, then substring returns an empty string

Corner Case:
1. pattern "a***" will return false. "*" cannot be followed by "*"
This is the default restriction of the question

*/
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        boolean firstMatch = (s.length() != 0)&& (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s,p.substring(2))) || (firstMatch && isMatch(s.substring(1), p));
        }else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
        
    }
}
