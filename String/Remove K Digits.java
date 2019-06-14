/*
Runtime: 3 ms, faster than 91.48% of Java online submissions for Remove K Digits.
Memory Usage: 36.5 MB, less than 99.95% of Java online submissions for Remove K Digits.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: 1 iteration
After observation, we find that the optimal solution is to delete the digit larger than the one on its right
because they will fall onto the same position after deletion, and the smaller digit is wanted.
Note:
for this question, there are several corner cases and some details to take note of.

Corner case:
1. "112" k=2  -> "11"
2. "1234567890" k=9  -> "0"
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
  public String removeKdigits(String num, int k) {
    StringBuilder sb = new StringBuilder(num);
    if(k >= num.length()) return "0";
    int i = 0;
    while(k > 0 && i < sb.length()-1) {
      if(sb.charAt(i) > sb.charAt(i+1)) {   //without =, for corner case 1
        sb.delete(i,i+1);
        k--;
        if(i > 0) i--;    //move i backward for 1 step for corner case 2 because now the neighbor changes
      }else i++;
    }
    //remove the rest chars
    while(k > 0){
      sb.delete(sb.length()-1,sb.length());
      k--;
    }
    //remove leading 0s
    while(sb.length() >= 2 && sb.charAt(0) == '0'){
      sb.delete(0,1);
    }
    return sb.toString();
  }
}
