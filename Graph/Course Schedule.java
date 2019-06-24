/*
Runtime: 7 ms, faster than 57.86% of Java online submissions for Course Schedule.
Memory Usage: 44.6 MB, less than 91.98% of Java online submissions for Course Schedule.

Algorithm:
For each prerequisite condition i, check whether its prerequisites' prerequisites contain itself with the help of check function. 

Syntax:
1. HashMap
Map<xxx> mymap = new HashMap<>();
Set<xxx> set = new HashSet<>();
mymap.put(k,v);
*/
/////////////////////////////////////////////////////////////////
class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(numCourses <= 1) return true;
    int len = prerequisites.length;
    Map<Integer, Set<Integer>> mymap = new HashMap<>();
    for(int i = 1; i < len; i++) {
      int k = prerequisites[i-1][0];
      int v = prerequisites[i-1][1];
      if(!mymap.containsKey(k)) mymap.put(k, new HashSet<Integer>());
      mymap.get(k).add(v);
      if(check(mymap, prerequisites[i][1], prerequisites[i][0]) == false) return false;
    }
    return true;
  }
  
  public boolean check(Map<Integer, Set<Integer>> mymap, int k, int v) {
    Set<Integer> myset = mymap.get(k);
    if(myset == null) return true;
    if(myset.contains(v)) return false;
    for(Integer i:myset) {
      if(check(mymap, i, v) == false) return false;
    }
    return true;
  }
}
