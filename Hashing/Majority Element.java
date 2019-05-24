/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Majority Element.
Memory Usage: 41.7 MB, less than 48.98% of Java online submissions for Majority Element.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 3:  Boyer-Moore Voting Algorithm
If we had some way of counting instances of the majority element as +1 
and instances of any other element as -1, 
summing them would make it obvious that the majority element is indeed the majority element.
*/
///////////////////////////////////////////////////////////////////////
class Solution {
    public int majorityElement(int[] nums) {
      int count = 0, ans = 0;
      for(int num:nums){
        if(count == 0) ans = num;
        count += (num == ans)? 1: -1;
      }
      return ans;
    }
}
//////////////////////////////////////////////////////////////////////////
/*
Complexity:
runtime: O(NlogN)
space: O(1) or O(N)

Algorithm 2: Sorting
*/
////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 11 ms, faster than 39.73% of Java online submissions for Majority Element.
Memory Usage: 39.5 MB, less than 98.57% of Java online submissions for Majority Element.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1: HashMap
use a hashmap to store the count of each element

Syntax:
1. hashmap add key and value
mapA.put("key1", "element 1")
2. iterate through a map
for (Object value : map.values()) {
    // ...
}
for (Map.Entry<String, Object> entry : map.entrySet()) {
    String key = entry.getKey();
    Object value = entry.getValue();
    // ...
}
*/
///////////////////////////////////////////////////////////////////////////
class Solution {
    public int majorityElement(int[] nums) {
      int n = nums.length;
      Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
      for(int i = 0; i < n; i++) {
        int count = mymap.getOrDefault(nums[i], 0);
        count++;
        mymap.put(nums[i], count);
      }
      for(Map.Entry<Integer, Integer> myentry : mymap.entrySet()){
        if(myentry.getValue() > nums.length/2) return myentry.getKey();
      }
      return 0;
    }
}
