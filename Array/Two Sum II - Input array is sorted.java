/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 37.4 MB, less than 62.55% of Java online submissions for Two Sum II - Input array is sorted.

Complexity:
runtime: O(logN)  worst:O(N)
space: O(1)

Algorithm 3: Iterative method. Recursion takes lots of space
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int start=0, end=numbers.length-1, mid;
    while(start < end) {
      mid = (start+end)/2;
      if(numbers[start]+numbers[end] < target) {
        if(numbers[mid] + numbers[end] < target) start = mid+1;
        else start = start+1;
      }else if(numbers[start]+numbers[end] > target){
        if(numbers[mid] + numbers[start] > target) end = mid-1;
        else end = end-1;
      }else{
        return new int[]{start+1,end+1};
      }
    }
    return new int[]{-1,-1};
  }
}
////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 38.7 MB, less than 11.45% of Java online submissions for Two Sum II - Input array is sorted.

Complexity:
runtime: O(logN)  worst:O(N)
space: O(1)

Algorithm 2: partial binary search
Take a leap when condition is loose
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] twoSum(int[] numbers, int target) {
    return helper(numbers, target, 0, numbers.length-1);
  }
  
  public int[] helper(int[] numbers, int target, int start, int end) {
    if(start >= end) return new int[]{-1,-1};
    int mid = (start+end)/2;
    if(numbers[start]+numbers[end] < target) {
      if(numbers[mid] + numbers[end] < target) return helper(numbers,target,mid+1,end);
      else return helper(numbers,target,start+1,end);
    }else if(numbers[start]+numbers[end] > target){
      if(numbers[mid] + numbers[start] > target) return helper(numbers,target,start,mid-1);
      else return helper(numbers,target,start,end-1);
    }else{
      return new int[]{start+1,end+1};
    }
  }
}
////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1 ms, faster than 56.84% of Java online submissions for Two Sum II - Input array is sorted.
Memory Usage: 37.8 MB, less than 62.04% of Java online submissions for Two Sum II - Input array is sorted.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 1:
move start and end one by one
*/
//////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    int start=0, end=numbers.length-1;
    while(start < end){
      if(numbers[start]+numbers[end] == target) break;
      if(numbers[start]+numbers[end] > target) {
        end--;
      }else{
        start++;
      }
    }
    return new int[]{start+1,end+1};
    
  }
}
