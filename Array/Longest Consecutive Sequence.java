/*
Runtime: 7 ms, faster than 57.29% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 36.5 MB, less than 68.64% of Java online submissions for Longest Consecutive Sequence.

Complexity:
runtime: O(N)
space: O(N)
Although the time complexity appears to be quadratic due to the while loop nested within the for loop, 
closer inspection reveals it to be linear. 
Because the while loop is reached only when currentNum marks the beginning of a sequence 
(i.e. currentNum-1 is not present in nums), 
the while loop can only run for nn iterations throughout the entire runtime of the algorithm. 
This means that despite looking like O(n⋅n) complexity, the nested loops actually run in O(n + n) time. 
All other computations occur in constant time, so the overall runtime is linear.

Algorithm 2: Hashset
use hashset to store and lookup numbers to determine whether there is a sequence

Syntax:
1. create a hashset:
Set<Integer> num_set = new HashSet<Integer>();
2. add into hashset
myset.add(num);
3. remove from hashset
myset.remove(num);
4. check whether contains
myset.contains(num)
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length == 0) return 0;
      int maxlen=1;
      Set<Integer> myset = new HashSet<Integer>();
      for(int num:nums) myset.add(num);
      for(int num:nums){
        if(!myset.contains(num-1)){
          int count = 1;
          int value = num;
          while(myset.contains(value+1)){
            count++;
            value = value+1;
          }
          if(count > maxlen) maxlen = count;
        }
      }
      return maxlen;
    }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 4 ms, faster than 93.39% of Java online submissions for Longest Consecutive Sequence.
Memory Usage: 35.8 MB, less than 77.86% of Java online submissions for Longest Consecutive Sequence.

Complexity:
runtime: O(nlogn)
space: O(1)

Algorithm 1:
1. sort
2. count the length of the sequence
Note: the case that there are duplicate numbers

Syntax:
1. Arrays.sort(array);
Note:
[0] the output should be 0

Corner case:
1. empty array[]
2. array with only 1 element [1]
3. duplicate numbers [0,1,1,2]
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
    public int longestConsecutive(int[] nums) {
      if(nums.length == 0) return 0;    //corner case, empty array
      Arrays.sort(nums);
      int count=1,maxlen=1;   //maxlen initialized to 1 instead of 0!
      for(int i = 0; i < nums.length-1; i++) {
        if(nums[i+1] == nums[i]+1) {
          count++;
          if(count > maxlen) maxlen = count;
        }else if(nums[i+1] != nums[i]){   //avoid duplicate numbers
          count = 1;
        }
      }
      return maxlen;
    }
}
