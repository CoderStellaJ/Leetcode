/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Climbing Stairs.
Memory Usage: 8.5 MB, less than 60.96% of C++ online submissions for Climbing Stairs.

Algorithm: dynamic programming, similar to Fibonacci number

Note:
when you create vector based on size n, note whether n is large enough for element initialization
*/
////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int climbStairs(int n) {
    	vector<int> dp(n);
        if(n == 1) return 1;
        else if(n == 2) return 2;
        dp[0] = 1;
        dp[1] = 2;    //exists only when n >= 2
        for(int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }
};
