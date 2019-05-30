/*
Runtime: 15 ms, faster than 65.60% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 36.6 MB, less than 99.89% of Java online submissions for Subarray Sum Equals K.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 3: Hashmap
1. use hashmap to store sum[j] which is the sum up to the jth element in the array
2. If there exists another sum[i] which has the value of sum[j]-k, then the elements' sum in between is k
Note:
need to put (0,1) into the map for initialization.
for case [1,1,1] k = 2
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0, sum=0;
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        mymap.put(0,1);  //very important
        for(int i = 0; i < nums.length; i++) {
          sum += nums[i];
          result += mymap.getOrDefault(sum-k,0);
          mymap.put(sum, mymap.getOrDefault(sum,0)+1);
        }
        return result;
    }
}
///////////////////////////////////////////////////////////////////////////////
/*
Runtime: 126 ms, faster than 17.91% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 38.6 MB, less than 99.10% of Java online submissions for Subarray Sum Equals K.

Complexity:
runtime: O(N^2)
space: O(N)

Algorithm 3: Dynamic Programming
Improved from algorithm 2, we only use a 1D array to store [0,end] 
*/
///////////////////////////////////////////////////////////////////////////
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0, start=0, end=0, sum=0;
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];    //records [0,end] sum
        for(int i = 0; i < nums.length; i++){
          for(int j = i; j < nums.length; j++){       //this can cover single element
            if(i == 0) {
              if(j == 0) dp[0] = nums[0];
              else dp[j] = dp[j-1] + nums[j];   //process for initialization
              sum = dp[j];
            }
            else sum = dp[j]-dp[i-1];
            if(sum == k) result++;
          }
        }
        return result;
    }
}
/////////////////////////////////////////////////////////////////////////////
/*
Memory Limit Exceeded

Complexity:
runtime: O(N^2)
space: O(N^2)

Algorithm 2: dynamic programming
*/
////////////////////////////////////////////////////////////////////////
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, start=0, end=0, sum=0;
        if(nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];   //records [start,end] sum
        for(int i = 0; i < nums.length; i++){
          dp[i][i] = nums[i];
          if(nums[i] == k) result++;        //must check for a single element
        }
        for(int i = 0; i < nums.length; i++){
          for(int j = i+1; j < nums.length; j++){       
            if(i == 0) dp[i][j] = dp[i][j-1]+nums[j]; 
            else dp[i][j] = dp[i-1][j] - nums[i-1];   //nums[i-1] not index i
            if(dp[i][j] == k) result++;
          }
        }
        return result;
    }
}
/////////////////////////////////////////////////////////////////////////
/*
Runtime: 120 ms, faster than 25.57% of Java online submissions for Subarray Sum Equals K.
Memory Usage: 38.8 MB, less than 98.57% of Java online submissions for Subarray Sum Equals K.

Complexity:
runtime: O(N^2)
space: O(1)

Algorithm 1: brute force
calculate all the subarray sum

Note: Please read questions carefully
For array: consider:
1. Whether it can contain negative numbers
2. And you cannot sort in this case because it requires consecutive numbers and sorting changes the sequence!
*/
///////////////////////////////////////////////////////////
class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0, start=0, end=0, sum=0;
        if(nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++){
          sum = 0;
          for(int j = i; j < nums.length; j++){
            sum += nums[j];
            if(sum == k) result++;
          }
        }
        return result;
    }
}
