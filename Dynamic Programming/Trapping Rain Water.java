
///////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 6 ms, faster than 55.81% of Java online submissions for Trapping Rain Water.
Memory Usage: 37.2 MB, less than 99.40% of Java online submissions for Trapping Rain Water.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 3: Stack
It's also common to transform DP to Stack problem
Instead of storing the largest bar upto an index as in Algorithm 2, 
we can use stack to keep track of the bars that are bounded by longer bars and hence, may store water. 

1. We add the index of the bar to the stack if bar is smaller than or equal to the bar at top of stack, 
which means that the current bar is bounded by the previous bar in the stack. 
2. If we found a bar longer than that at the top, 
we are sure that the bar at the top of the stack is bounded by the current bar and a previous bar in the stack, 
hence, we can pop it and add resulting trapped water to ans.
3. In this case, we should push index into stack instead of the value.
Because the value can be easily retrieved from index 

In the stack: longer than top bar , max_left
Outside the bar and larger than top bar , max_right

Syntax:
1. Generic type: List<T>, T is Generic type
And when initializing a List, we have to use boxed type e.g. Integer
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int trap(int[] height) {
      int ans = 0;
      Stack<Integer> mystack = new Stack<Integer>();
      int bar = 0;
      for(int i = 0; i < height.length; i++) {
        int cur = height[i];
        while(!mystack.isEmpty() && cur > height[mystack.peek()]){
          bar = height[mystack.pop()];
          if(mystack.isEmpty()) break;
          int distance = i - mystack.peek() -1;
          ans += (Math.min(cur, height[mystack.peek()]) - bar) * distance;
        }
        mystack.push(i);
      }
      return ans; 
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1 ms, faster than 99.77% of Java online submissions for Trapping Rain Water.
Memory Usage: 36.3 MB, less than 99.79% of Java online submissions for Trapping Rain Water.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2: Dynamic Programming
To prevent iterating over the array in every iteration, a better way is to record it down into an array
And this is the core of dynamic programming

The key point of this question is that :
DO NOT consider the whole area bounded by 2 bars.
INSTEAD, only consider the area above each bar
In this way, you can decompose the question to subproblems and no need to record index
*/
//////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int trap(int[] height) {
      int ans = 0;
      int[] dp_left = new int[height.length];
      int[] dp_right = new int[height.length];
      for(int i = 0; i < height.length; i++){
        if(i == 0) dp_left[i] = height[0];
        else dp_left[i] = Math.max(dp_left[i-1], height[i]);
      }
      for(int i = height.length-1; i >= 0; i--) {
        if(i == height.length-1) dp_right[i] = height[i];
        else dp_right[i] = Math.max(dp_right[i+1],height[i]);
      }
      for(int i = 0; i < height.length; i++) {
        ans += Math.min(dp_left[i],dp_right[i])-height[i];
      }
      return ans; 
    }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 59 ms, faster than 7.11% of Java online submissions for Trapping Rain Water.
Memory Usage: 39.5 MB, less than 48.79% of Java online submissions for Trapping Rain Water.

Complexity: 
runtime: O(N^2)
space: O(1)

Algorithm 1: Brute force
For each current height, find its max_left and max_right
And no need to record index because we only consider the space above current height

The key of this problem is finding the max heights on its right and left
*/
//////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int trap(int[] height) {
      int max_left = 0;
      int max_right = 0;
      int ans = 0;
      for(int i = 0; i < height.length; i++) {
        max_left = 0;
        max_right = 0;
        for(int j = i; j >= 0; j--) {   //index start from i to do initialization
          max_left = Math.max(max_left, height[j]);
        }
        for(int k = i; k < height.length; k++) {
          max_right = Math.max(max_right,height[k]);
        }
        ans += (Math.min(max_right, max_left) - height[i]) ;
      }
      return ans;
        
    }
}
