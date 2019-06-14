/*
Runtime: 1 ms, faster than 99.86% of Java online submissions for Insert Interval.
Memory Usage: 41.8 MB, less than 22.50% of Java online submissions for Insert Interval.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2: 1 List + 1 Array
1. insert and merge happen in the same list
    after finding the position of new interval, directly start the merging process
    
*/
///////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    //base case
    if(intervals.length == 0 || intervals[0].length == 0) return new int[][] {newInterval}; 
    if(newInterval.length == 0) return intervals;
    
    List<int[]> mylist = new ArrayList<>();
    int[][] result;
    //find the correct place to insert based on starting time
    int index = 0;
    for(int i = 0; i < intervals.length; i++) {
      if(intervals[i][0] > newInterval[0]) {
        index = i-1;
        break;
      }else{
        mylist.add(intervals[i]);
        index = i;
      }
    }

    //merge the intervals
    int end, newstart, newend;
    if(index < 0) {
      mylist.add(newInterval);
    }else{
      //merge the newInterval first
      end = mylist.get(index)[1];
      newstart = newInterval[0];
      newend = newInterval[1];
      if(newstart <= end){
        if(newend > end) mylist.get(index)[1] = newend;   
      }else{
        mylist.add(newInterval);
      }
    }
    
    for(int i = index+1; i < intervals.length; i++) {
      end = mylist.get(mylist.size()-1)[1];
      newstart = intervals[i][0];
      newend = intervals[i][1];
      if(newstart <= end){
        if(newend > end) mylist.get(mylist.size()-1)[1] = newend;   
      }else{
        mylist.add(intervals[i]);
      }
    }
    
    result = new int[mylist.size()][2];
    for(int i = 0; i < mylist.size(); i++) {
      result[i] = mylist.get(i);
    }
    return result;
  }
}

///////////////////////////////////////////////////////////////////////////////
/*
Runtime: 2 ms, faster than 65.06% of Java online submissions for Insert Interval.
Memory Usage: 41.3 MB, less than 29.27% of Java online submissions for Insert Interval.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1: 2 Lists + 1 Array
1. Insert to the right position
2. merge the intervals into another list
For the convenience of adding elements, we use List as the data structure to hold answers

Note: 
1. during insertion, at last check whether it's inserted

Syntax:
1. create a list
List<int[]> mylist = new ArrayList<>();

*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    //base case
    if(intervals.length == 0 || intervals[0].length == 0) return new int[][] {newInterval}; 
    if(newInterval.length == 0) return intervals;
    
    List<int[]> mylist = new ArrayList<>();
    List<int[]> ans = new ArrayList<>();
    boolean added = false;
    //find the correct place to insert based on starting time
    for(int i = 0; i < intervals.length; i++) {
      if(intervals[i][0] > newInterval[0] && added == false) {
        mylist.add(newInterval);
        mylist.add(intervals[i]);   //insert both original interval and the new one
        added = true;
      }else{
        mylist.add(intervals[i]);
      }
    }
    if(added == false) mylist.add(newInterval);   //very important!!!
    
    //merge the intervals
    ans.add(mylist.get(0));
    int end = mylist.get(0)[1], newstart, newend;
    for(int k = 1; k < mylist.size();k++){
      end = ans.get(ans.size()-1)[1];
      int[] arr = mylist.get(k);
      newstart = arr[0];
      newend = arr[1];
      if(newstart <= end){
        if(newend > end) {
          ans.get(ans.size()-1)[1] = newend;
        }
      }else{
        ans.add(mylist.get(k));
      }
    }
    
    int[][] result = new int[ans.size()][2];
    for(int j = 0; j < ans.size(); j++) {
      result[j] = ans.get(j);
    }
    return result;
  }
}
