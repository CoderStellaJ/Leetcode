/*
Runtime: 6 ms, faster than 91.30% of Java online submissions for Find All Duplicates in an Array.
Memory Usage: 47.3 MB, less than 96.31% of Java online submissions for Find All Duplicates in an Array.

Complexity:
runtime: O(N)
space: O(1)

Algorithm:
This type of problem: the elements have certain range

You can solve it by swapping inside the array without using extra space
*/
////////////////////////////////////////////////////////////////////////
class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int tmp = 0, num = 0;
    List<Integer> ans = new ArrayList<>();
    for(int i = 0 ; i < nums.length; i++) {
      num = nums[i];
      if(num != i+1 && num != 0) {
        tmp = nums[num-1];
        if(tmp == num){
          ans.add(num);
          nums[i] = 0;
        }else {
          nums[num-1] = num;
          nums[i] = tmp;
          i--;
        }
      }
    }
    return ans;
  }
}
