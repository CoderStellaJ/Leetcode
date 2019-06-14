/*
Runtime: 9 ms, faster than 99.35% of Java online submissions for Exclusive Time of Functions.
Memory Usage: 37.6 MB, less than 99.48% of Java online submissions for Exclusive Time of Functions.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: Stack
1. prev: used to record the last event to calculate exclusive time
2. increment the answer everytime you find some exclusive part instead of trying to deduct the interval all at once.

Corner case:
1. no overlapping
2
["0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7"]

2. same task
1
["0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
*/
/////////////////////////////////////////////////////////////////////////
class Solution {
  public int[] exclusiveTime(int n, List<String> logs) {
    Stack<Integer> mystack = new Stack<>();
    int[] ans = new int[n];
    int prev = 0, maxend = -1;
    //initialization
    String s =  logs.get(0);
    int index1 = s.indexOf(":"), index2 = s.lastIndexOf(":");
    int num = Integer.parseInt(s.substring(0,index1)), time = Integer.parseInt(s.substring(index2+1));
    mystack.push(num);
    
    for(int i = 1; i < logs.size(); i++) {
      s =  logs.get(i);
      index1 = s.indexOf(":");
      index2 = s.lastIndexOf(":");
      String flg = s.substring(index1+1, index2);
      //task number
      num = Integer.parseInt(s.substring(0,index1));
      time = Integer.parseInt(s.substring(index2+1));
      if(flg.equals("start"))  {
        if(!mystack.isEmpty()) ans[mystack.peek()] += (time-prev);
        mystack.push(num);
        prev = time;
      }else{
        mystack.pop();
        ans[num] += (time-prev+1);
        prev = time+1;
      }
    }
    return ans;
  }
}
