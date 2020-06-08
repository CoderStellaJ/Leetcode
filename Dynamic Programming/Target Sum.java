/*
1D DP array, dp[sum] 
Because we only access i-1 in the first dimension, so we can refresh the data and simplify the array to 1D

time: O(S)
space: O(n), because of Java garbage collection

*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[2001];    //index 0 is -1000, index 2000 is 1000, index 1000 is 0
        
        //initialization
        dp[1000 + nums[0]]++;
        dp[1000-nums[0]]++;    

        //dp
        for(int i = 1; i < len; i++) {
            int[] next = new int[2001];     //use a new dp array
            for(int sum = nums[i]; sum <= 2000-nums[i]; sum++) {
                int oldValue = dp[sum];
                if(oldValue != 0) {
                    next[sum+nums[i]] += oldValue;
                    next[sum-nums[i]] += oldValue;    
                }
            }
            dp = next;
        }
        if(S+1000 > 2000 || S+1000 < 0) {   //prevent index out of bound
            return 0;
        }else {
            return dp[S + 1000];    
        }
    }
}


/*
2D DP array for memorization. 
dp[len][2001], first dimension is index, second dimension is the sum

time: O(nS)
space: O(nS)

Runtime: 9 ms, faster than 77.64% of Java online submissions for Target Sum.
Memory Usage: 39.3 MB, less than 10.00% of Java online submissions for Target Sum.
*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if(nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[len][2001];    //index 0 is -1000, index 2000 is 1000, index 1000 is 0
        
        //initialization
        dp[0][1000 + nums[0]]++;
        dp[0][1000-nums[0]]++;    

        //dp
        for(int i = 1; i < len; i++) {
            for(int sum = nums[i]; sum <= 2000-nums[i]; sum++) {    //sum cannot start from 0!
                if(dp[i-1][sum] != 0) {
                    dp[i][sum+nums[i]] += dp[i-1][sum];
                    dp[i][sum-nums[i]] += dp[i-1][sum];
                }
            }
        }
        if(S+1000 > 2000 || S+1000 < 0) {   //prevent index out of bound
            return 0;
        }else {
            return dp[len-1][S + 1000];    
        }
    }
    
}


/*
recursion

Runtime: 286 ms, faster than 38.25% of Java online submissions for Target Sum.
Memory Usage: 37.3 MB, less than 50.00% of Java online submissions for Target Sum.

time complexity: O(2^n)
space: O(1)

detail: when S = 0 and nums[i] = 0, should return 2 instead of 1

*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if(nums.length == 0) {
            return 0;
        }
        return auxFunc(nums, 0, S);
    }
    
    public int auxFunc(int[] nums, int index, int S) {
        int len = nums.length;
        //base case
        if(index == len-1) {
            if(nums[len-1] == S && nums[len-1] == -S) {
                return 2;   //+0 or -0
            }else if(nums[len-1] == S || nums[len-1] == -S) {
                return 1;
            }else {
                return 0;
            }
        }
        //recursive relationship

        int resPlus = auxFunc(nums, index+1, S-nums[index]);
        int resMinus = auxFunc(nums, index+1, S+nums[index]);
        return resPlus + resMinus;   

    }
}