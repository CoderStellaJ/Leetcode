/*
Runtime: 21 ms, faster than 18.16% of Java online submissions for Palindromic Substrings.
Memory Usage: 48.6 MB, less than 5.07% of Java online submissions for Palindromic Substrings.
*/

class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        if(len <= 1) {
            return len;
        }
        int[][] dp = new int[len][len];
        int res = 0;
        
        //initialization, for substrings of length 1 and 2
        for(int i = 0; i <= len-2; i++) {
            dp[i][i] = 1;
            res += 1;
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                res += 1;
            }
        }
        dp[len-1][len-1] = 1;
        res += 1;
        
        //starts from length 3 substrings
        for(int k = 3; k <= len; k++) {
            for(int i = 0; i <= len-k; i++) {
                if(s.charAt(i) == s.charAt(i+k-1) && dp[i+1][i+k-2] == 1) {
                    dp[i][i+k-1] = 1;
                    res += 1;
                }
            }
        }
        return res;
    }
}