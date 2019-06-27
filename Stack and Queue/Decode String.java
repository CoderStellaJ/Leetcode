/*
Runtime: 1 ms, faster than 73.78% of Java online submissions for Decode String.
Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Decode String.

Complexity:
runtime: O(N)
space: O(N)

Algorithm:
use a stack to store the chars
Note:
1. when the number has more than 1 digit

Corner case:
"100[leetcode]"
When you process string containing int value, always consider the case that the number contains more than 1 digit
*/
/////////////////////////////////////////////////////////////////
class Solution {
  public String decodeString(String s) {
    Stack<String> mystack = new Stack<>();
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      String str = Character.toString(c);
      //System.out.println("current char "+c);
      if(Character.isDigit(c)){
        StringBuilder times = new StringBuilder();
        while(Character.isDigit(s.charAt(i))) {
          times.append(s.charAt(i));
          i++;
        }
        i--;
        mystack.push(times.toString());
      }else if(c == ']') {
        StringBuilder newstr = new StringBuilder();
        while(!mystack.peek().equals("[")) {
          newstr.insert(0,mystack.pop());
        }
        mystack.pop();
        int count = Integer.parseInt(mystack.pop());
        String part = newstr.toString();    
        for(int j = 1; j < count; j++) {
          newstr.append(part);      //append part instead of the newstr!! as newstr keeps changing
        }
        //System.out.println(newstr.toString());
        mystack.push(newstr.toString());
      }else {
        mystack.push(str);
      } 
    }
    StringBuilder ans = new StringBuilder();
    while(!mystack.isEmpty()){        //concat all the strings in the stack
      ans.insert(0,mystack.pop());
    }
    return ans.toString();
  }
}
