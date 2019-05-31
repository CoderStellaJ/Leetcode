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
