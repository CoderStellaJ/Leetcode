/*
Runtime: 2 ms, faster than 97.58% of Java online submissions for Intersection of Two Arrays.
Memory Usage: 37.4 MB, less than 56.16% of Java online submissions for Intersection of Two Arrays.

Algorithm:
Using hashset to check duplication

Syntax:
1. Iterate through a Set
Iterator<Integer> it = result.iterator();   //Iterator<> need to specify the type
while(it.hasNext()){
  it.next();    //.next() get the current element
}
*/
////////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] intersection(int[] nums1, int[] nums2) {
    if(nums1.length == 0 || nums2.length == 0) return new int[0];
    Set<Integer> myset = new HashSet<>();
    Set<Integer> result = new HashSet<>();
    
    for(int i = 0; i < nums1.length; i++) myset.add(nums1[i]);
    for(int j = 0; j < nums2.length; j++){
      if(myset.contains(nums2[j]) && !result.contains(nums2[j])) result.add(nums2[j]);
    }
    int[] ans = new int[result.size()];
    Iterator<Integer> it = result.iterator();
    int k = 0;
    while(it.hasNext()){
      ans[k] = (int)(it.next());
      k++;
    }
    return ans;
  }
}
