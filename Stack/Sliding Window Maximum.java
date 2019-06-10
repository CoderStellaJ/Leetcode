/*
Runtime: 10 ms, faster than 74.42% of Java online submissions for Sliding Window Maximum.
Memory Usage: 41.2 MB, less than 79.54% of Java online submissions for Sliding Window Maximum.

Complexity:
runtime: O(N) (average)
space: O(N)

Algorithm 2: Deque
The time-consuming part is Math.max() part. To optimize the algorithm, we need to find a more efficient way to keep larger numbers.
So, we use Deque to replace it.

Before inserting an element in the deque, we check if the last element in the deque is smaller than the current element or not. 
If it is smaller, then we remove the last element.
At any point, we want to remove all elements from the end which are smaller than the current element which is being inserted.
We will remove elements from the start of the deque if it doesn't belong to the window.
We print the maximum element from the start of the window for the current sliding window.

Syntax:
1. Deque:
Deque<Integer> que = new LinkedList<>();    //on the right of = no need to specify the type again
addFirst()
addLast()
removeFirst()
removeLast()
peekFirst()
peekLast()
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
    if(k == 0 || nums.length < k) return new int[0];
    int[] result = new int[nums.length-k+1];
    Deque<Integer> que = new LinkedList<>();    //only store the index
    for(int i = 0; i < nums.length; i++) {
      while(!que.isEmpty() && nums[que.peekLast()] < nums[i]){
        que.removeLast();
      }
      int start = i-k+1;
      if(!que.isEmpty() && que.peekFirst() < start) que.removeFirst();    //!empty() is the first condition
      que.addLast(i);
      if(i >= k-1) result[i-k+1] = nums[que.peekFirst()];     //not nums[i]
    }
    return result;
  }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 28 ms, faster than 28.16% of Java online submissions for Sliding Window Maximum.
Memory Usage: 41 MB, less than 82.51% of Java online submissions for Sliding Window Maximum.

Complexity:
runtime: O(kN) worst case for [6,5,4,3,2,1]
space: O(1)

Algorithm 1:
find the max in the window

Syntax:
1. print an array 
System.out.println(Arrays.toString(array));
2. create an empty array
int[] ans = new int[0];   //the size can be 0
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if(nums.length == 0) return new int[0];
    int[] ans = new int[nums.length-k+1];
    int max = getmax(nums, 0, k-1);
    ans[0] = max;
    for(int i = k; i < nums.length; i++) {
      if(nums[i] > ans[i-k]) ans[i-k+1] = nums[i];
      else ans[i-k+1] = getmax(nums,i-k+1,i);
    }
    return ans;
  }
  public int getmax(int[] nums, int start, int end) {
    int max = Integer.MIN_VALUE;
    for(int i = start; i <= end; i++) {
      max = Math.max(max,nums[i]);
    }
    return (start>end)? 0 : max;
  }
}
