/*
Runtime: 1 ms, faster than 60.71% of Java online submissions for Find the Duplicate Number.
Memory Usage: 37.1 MB, less than 80.22% of Java online submissions for Find the Duplicate Number.

Complexity:
runtime: O(N)
space: O(1)

Algorithm:
given the condition that the elements have a specified range, we can try to put the numbers into correct index
after these swappings, we will be able to find the duplication
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int findDuplicate(int[] nums) {
    int tmp = 0;
    for(int i = 0; i < nums.length; i++) {
      if(nums[i] != i+1){
        tmp = nums[nums[i]-1];
        if(tmp == nums[i]) return tmp;
        nums[nums[i]-1] = nums[i];
        nums[i] = tmp;
        i--;
      }
    }
    return -1;
  }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 3 ms, faster than 47.89% of Java online submissions for Find the Duplicate Number.
Memory Usage: 38.4 MB, less than 25.83% of Java online submissions for Find the Duplicate Number.

Complexity:
runtime: O(nlogn)
space: O(1)

Algorithm: sorting
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int findDuplicate(int[] nums) {
    Arrays.sort(nums);    //O(nlogn)
    for(int i = 1; i < nums.length; i++) {
      if(nums[i] == nums[i-1]) return nums[i];
    }
    return -1;
  }
}
