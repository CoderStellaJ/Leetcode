/*
time: O(N)
space: O(1)

leverage the info that numbers are in [1, n]
change the sign of the element at index i if i+1 is in the array
and finally loop through the array and add j+1 to list if element at index j is positive

initially my thought was using -1 to replace the element, but this will lose information during iteration.
so adding - for the element is the best way to mark it

Runtime: 5 ms, faster than 82.53% of Java online submissions for Find All Numbers Disappeared in an Array.
Memory Usage: 48.2 MB, less than 37.74% of Java online submissions for Find All Numbers Disappeared in an Array.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int len = nums.length;
        
        for(int i = 0; i < len; i++) {
            int cur = nums[i];
            int oldValue = nums[Math.abs(cur)-1];   //use abs here!
            if(oldValue > 0) {
                nums[Math.abs(cur)-1] = -oldValue;
            }
        }
        
        for(int i = 0; i < len; i++) {
            if(nums[i] > 0) {
                res.add(i+1);
            }    
        }
        
        return res;
        
    }
}