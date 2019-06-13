/*
Runtime: 3 ms, faster than 61.12% of Java online submissions for Add Strings.
Memory Usage: 36.2 MB, less than 99.89% of Java online submissions for Add Strings.

Algorithm:
basic addition algorithm
Note:
1. when result < 10, change add to 0
2. At the end of the calculation, if add == 1, add one more digit at the beginning of the string
3. In while loop, remember to i--, j--. Otherwise, dead loop

Syntax:
1. '0'+intvalue will convert '0' to integer and then return the integer result
*/
//////////////////////////////////////////////////////////////
class Solution {
  public String addStrings(String num1, String num2) {
    int add = 0;
    int i=num1.length()-1, j=num2.length()-1;
    StringBuilder sb = new StringBuilder();
    while(i >= 0 && j >= 0) {
      int value1 = num1.charAt(i)-'0';
      int value2 = num2.charAt(j)-'0';
      int result = value1+value2+add;
      if(result >= 10) {
        add = 1;
        result -= 10;
      }else add = 0;
      sb.insert(0, Integer.toString(result));
      i--;
      j--;
    }
    
    while(i >= 0) {
      int value1 = num1.charAt(i)-'0';
      int result = value1+add;
      if(result >= 10) {
        add = 1;
        result -= 10;
      }else add = 0;
      sb.insert(0, Integer.toString(result));
      i--;
    }
    
    while(j >= 0) {
      int value2 = num2.charAt(j)-'0';
      int result = value2+add;
      if(result >= 10) {
        add = 1;
        result -= 10;
      }else add = 0;
      sb.insert(0, Integer.toString(result));
      j--;
    }
    
    if(add == 1){
      sb.insert(0,"1");
    }
    return sb.toString();
  }
  
}
