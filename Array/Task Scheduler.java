/*
Runtime: 2 ms, faster than 100.00% of Java online submissions for Task Scheduler.
Memory Usage: 38.4 MB, less than 92.85% of Java online submissions for Task Scheduler.

Algorithm: Calculating Idle slots
https://leetcode.com/problems/task-scheduler/solution/
determine the number of idle slots, we can find out the time required to execute all the tasks as 
idle_slots + Total Number Of Tasks. 
1. When the max_val formed intervals are not able to hold all the tasks,
You can simply insert extra tasks in each intervals
2. When there are extra spaces in the interval, get the idle slots

Corner case:
More than 1 tasks occur max_time
*/
////////////////////////////////////////////////////////////////////////
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char c:tasks){
          map[c-'A']++;
        }
        Arrays.sort(map);
        int max_time = map[25], intervals = (max_time-1)*n;
        for(int i = 24; i >= 0; i--) {
          intervals -= Math.min(max_time-1, map[i]);    
          //for the case that map[24] occurs the same time as max_time
          //the intervals only count the ones between max_time tasks
          if(intervals < 0) break;
        }
        return (intervals > 0)? intervals+tasks.length : tasks.length;
    }
}
