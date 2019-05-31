/*
Runtime: 24 ms, faster than 71.16% of Java online submissions for Frog Jump.
Memory Usage: 39.9 MB, less than 83.01% of Java online submissions for Frog Jump.

Complexity:
runtime: O(N^2)
space: O(N^2)

Algorithm 2: Dynamic Programming
  dp[i][k] means we can jump k places from the ith stone. So ,basically, 
  we can reach the ith stone from any jth stone(j<i) when dp[j][distance between i & j] is true.
  and WHEN that happens,for that particular j&i pair, we can say that dp[i][distance between i & j], 
  dp[i][distance between i & j + 1], dp[i][distance between i & j - 1] are true.
  so the 2d array will essentially hold the information of all possible combinations of i & j (j<i)
  along with the respective jumps it can make from there

Syntax:
1. Pair in java
import javafx.util.Pair;
*/
////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean canCross(int[] stones) {
        //Dynamic Programming 
        boolean[][] dp = new boolean[stones.length+1][stones.length+1];
        //dp[i][distance]
        //length+1 as size because of distance+1
        dp[0][1] = true;	//from 0 jump 1 unit
        for(int i = 1; i < stones.length; i++) {
        	for(int j = 0; j < i; j++) {
        		//consider any pair from j to i
        		int distance = stones[i]-stones[j]; 
        		if(distance > 0 && distance < stones.length && dp[j][distance] == true){		
	        		//note the range of the distance
	        		//distance < stones.length because the gap between numbers is at most n-1 
        			dp[i][distance-1] = true;
        			dp[i][distance] = true;
        			dp[i][distance+1] = true;
        		}
        	}
        }
        for(int k = 0; k <= stones.length; k++) {
        	if(dp[stones.length-1][k] == true) return true;
        }
        return false;
    }
}
/////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm: Recursion
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean canCross(int[] stones) {
        //Recursion ? 
        if(stones.length == 1) return true;
    	if(stones[1] == 1) return helper(stones,1,1);
    	return false;
    }

    public boolean helper(int[] stones, int ind, int step) {
    	//pos marks the current position and step is the lst jump units
    	//base case
    	int cur = stones[ind];		//position it is at
    	boolean res1=false,res2=false,res3=false;
    	if(ind == stones.length-1) return true;	
    	if(step == 0) return false;
    	for(int i = ind+1; i < stones.length; i++){
    		int distance = stones[i]-cur;
    		if(distance < step-1) continue;
    		else if(distance > step+1) break;
    		else if(distance == step-1 ) res1 = helper(stones,i,step-1);
    		else if(distance == step) res2 = helper(stones,i,step);
    		else if(distance == step+1) res3 = helper(stones,i,step+1);
    		if(res1||res2||res3 == true) return true;
    	}
    	return false;
    }
}
