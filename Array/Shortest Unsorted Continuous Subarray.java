/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Shortest Unsorted Continuous Subarray.
Memory Usage: 40.7 MB, less than 96.15% of Java online submissions for Shortest Unsorted Continuous Subarray.

time complexity: O(N)
space: O(1)

find the max and min when the array is not sorted.
and determine the index whose element is right larger than the min and right smaller than the max

syntax:
1. max int and min int: Integer.MAX_VALUE, Integer.MIN_VALUE
2. boolean false lowercase
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, start = 0, end = 0;
        boolean isUnSorted = false;
        int len = nums.length;
        // first loop to find min and max
        for(int i = 0; i < len-1; i++) {
            int cur = nums[i];
            int right = nums[i+1];
            if(right < cur) {
                isUnSorted = true;
                if(right < min) {
                    min = right;
                }
                if(cur > max) {
                    max = cur;
                }
            }
        }
        
        //second loop, locate the index of min
        for(int i = 0; i < len; i++) {
            if(nums[i] > min) {
                start = i;
                break;
            }
        }
        
        //thrid loop, locate the index of max
        for(int i = len-1; i >= 0; i--) {
            if(nums[i] < max) {
                end = i;
                break;
            }
        }
        
        if(isUnSorted == false) {
            return 0;
        }else {
            return (end-start+1);
        }
    }
}



/*
sort the array and compare it with the original one

time complexity: O(nlogn)
space: O(1)

Runtime: 10 ms, faster than 24.66% of Java online submissions for Shortest Unsorted Continuous Subarray.
Memory Usage: 51.7 MB, less than 7.69% of Java online submissions for Shortest Unsorted Continuous Subarray.

syntax:
1. clone an array: arr.clone()
2. sort an array: Arrays.sort(myarr);
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = -1;
        int end = -1;
        
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        for(int i = 0; i < len; i++) {
           if(nums[i] != newNums[i]) {
               start = i;
               break;
           }
        }
        for(int i = len-1; i >= 0; i--) {
            if(nums[i] != newNums[i]) {
               end = i;
               break;
           }
        }
        if(start == -1) {
            return 0;
        }
        return end-start+1;
    }
}