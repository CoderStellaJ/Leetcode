/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
Memory Usage: 36.5 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.

use an array to store the subproblem results
*/

class Solution {
    public int numTrees(int n) {
        if(n <= 1) {
            return 1;
        }
        
        //base case
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            for(int j = 0; j <= i-1; j++) {
                dp[i] += dp[j] * dp[i-1-j];
            }    
        }
        
        return dp[n];

    }
}


/*
Runtime: 973 ms, faster than 8.51% of Java online submissions for Unique Binary Search Trees.
Memory Usage: 35.7 MB, less than 5.55% of Java online submissions for Unique Binary Search Trees.

Recursion: slow, lots of recomputations
*/
class Solution {
    public int numTrees(int n) {
        // base case
        if(n == 0) {
            return 1;
        }
        if(n <= 2) {
            return n;
        } 
        
        int res = 0;
        for(int i = 0; i <= n-1; i++) {
            // i is number of elements in the left branch
            res += numTrees(i) * numTrees(n-i-1);
        }
        
        return res;
    }
}