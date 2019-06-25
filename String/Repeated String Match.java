/*
Runtime: 154 ms, faster than 25.11% of Java online submissions for Repeated String Match.
Memory Usage: 37.1 MB, less than 98.27% of Java online submissions for Repeated String Match.

Complexity:
runtime: O(N∗(N+M)), where M, N are the lengths of strings A, B
sb can be M+N length, and checking whether it's a substring takes N*(M+N)
space: O(M+N)

Algorithm:
increment the number of repeatitions of string A and check whether B is a substring
*/
/////////////////////////////////////////////////////////////////
class Solution {
  public int repeatedStringMatch(String A, String B) {
    StringBuilder sb = new StringBuilder();
    int i = 1;
    while(sb.length() < A.length() + B.length()) {
      sb.append(A);
      if(sb.indexOf(B) != -1) return i;
      i++;
    }
    return -1;
    
  }
}
