/*
1D dynamic programming. keep dp[sum] because we only access the previoud element's result
time: O(SN)
space: O(S)

Runtime: 26 ms, faster than 53.64% of Java online submissions for Partition Equal Subset Sum.
Memory Usage: 39.1 MB, less than 6.35% of Java online submissions for Partition Equal Subset Sum.

*/
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return false;
        }
        int totalSum = 0;
        for(int i = 0; i < len; i++) {
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) {
            return false;
        }
        int subsetSum = totalSum/2;
        return findSubset(nums, subsetSum);
    }
    
    public boolean findSubset(int[] nums, int sum) {
        int len = nums.length;
        if(sum > 10000) {
            return false;
        }
        boolean[] dp = new boolean[sum+1];
        
        //initialization
        if(nums[0] <= sum) {
            dp[nums[0]] = true;  
            dp[0] = true;    
        }
        
        //dp
        for(int i = 1 ; i < len; i++) {
            boolean[] next = new boolean[sum+1];
            for(int j = 0; j <= sum; j++) {
                if(dp[j] == true) {
                    next[j] = true;    
                    if(j+nums[i] <= sum) {
                        next[j+nums[i]] = true;    
                    }
                }
            }
            dp = next;
        }
        return dp[sum];
    }
}

/*
2D dynamic programming. keep dp[index][sum], transform the question to finding a subset with the sum.
time: O(SN) where S is sum and N is length
space: O(SN)

Runtime: 36 ms, faster than 35.47% of Java online submissions for Partition Equal Subset Sum.
Memory Usage: 39.5 MB, less than 6.35% of Java online submissions for Partition Equal Subset Sum.
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return false;
        }
        int totalSum = 0;
        for(int i = 0; i < len; i++) {
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) {
            return false;
        }
        int subsetSum = totalSum/2;
        return findSubset(nums, subsetSum);
        
    }
    
    public boolean findSubset(int[] nums, int sum) {
        int len = nums.length;
        if(sum > 10000) {
            return false;
        }
        boolean[][] dp = new boolean [len][sum+1];
        
        //initialization
        for(int i = 0; i < len; i++) {
            if(nums[i] <= sum) {
                dp[i][nums[i]] = true;  //take the element
                dp[i][0] = true;    //abandon the element
            }
        }
        
        //dp
        for(int i = 1 ; i < len; i++) {
            for(int j = 0; j <= sum; j++) {
                
                if(dp[i-1][j] == true) {
                    dp[i][j] = true;    // abandon the ith element
                    if(j+nums[i] <= sum) {
                        dp[i][j+nums[i]] = true;    //keep the ith element
                    }
                }
            }
        }
        
        return dp[len-1][sum];
    }
}


/*
recursion
exceed time limit
time: O(2^n)
space: O(1)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if(len == 1) {
            return false;
        }
        int totalSum = 0;
        for(int i = 0; i < len; i++) {
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1) {
            return false;
        }
        int subsetSum = totalSum/2;
        return findSubset(nums, 0, subsetSum);
        
    }
    
    public boolean findSubset(int[] nums, int index, int sum) {
        //base case
        if(index == nums.length-1) {
            if(nums[index] == sum) {
                return true;
            }else {
                return false;
            }
        }
        
        //recursive relationship
        //if taken
        boolean res1 = findSubset(nums, index+1, sum-nums[index]);
        // if not taken
        boolean res2 = findSubset(nums, index+1, sum);
        
        return res1 || res2;
    }
}