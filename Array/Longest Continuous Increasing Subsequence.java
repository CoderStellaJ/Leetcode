/*
Runtime: 1 ms, faster than 99.88% of Java online submissions for Longest Continuous Increasing Subsequence.
Memory Usage: 37.1 MB, less than 99.91% of Java online submissions for Longest Continuous Increasing Subsequence.

Algorithm: simple loop through

Corner case:
[] -> 0
maxlen should be 0 and if array is not empty it changes to 1

Array test case:
1. empty
2. 1 element
3. >1 element
*/
///////////////////////////////////////////////////////////////////
import java.util.*;

class Solution {
    public int findLengthOfLCIS(int[] nums) {
      int count=1, maxlen=0;
      for(int i = 0; i < nums.length; i++) {
        if(i == 0) {
            maxlen=1;
            continue;
        }
        if(nums[i] > nums[i-1]) {
          count++;
          if(count > maxlen) maxlen = count;
        }else {
          count = 1;
        }
      }
      return maxlen;
    }
  
    public static void main(String[] args) {
      Solution mysol = new Solution();
      int[] words1 = {1,3,5,4,7};
      int[] words2 = {2,2,2};
      int[] words3 = {1};
      int ans1= mysol.findLengthOfLCIS(words1);
      System.out.println(ans1);
      int ans2= mysol.findLengthOfLCIS(words2);
      System.out.println(ans2);
      int ans3= mysol.findLengthOfLCIS(words3);
      System.out.println(ans3);
    }
  
}
