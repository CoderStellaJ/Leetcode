/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Comments.
Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Remove Comments.

Complexity:
runtime: O(S)
space: O(S)

Algorithm:
We need to parse the source line by line. Our state is that we either are in a block comment or not.
1. If we start a block comment and we aren't in a block, 
then we will skip over the next two characters and change our state to be in a block.
2. If we end a block comment and we are in a block, 
then we will skip over the next two characters and change our state to be not in a block.
3. If we start a line comment and we aren't in a block, 
then we will ignore the rest of the line.
4. If we aren't in a block comment (and it wasn't the start of a comment), 
we will record the character we are at.
5. At the end of each line, if we aren't in a block, we will record the line.

Syntax:
1. mystr.trim();
2. string.toCharArray();
*/
////////////////////////////////////////////////////////////////
class Solution {
    public List<String> removeComments(String[] source) {
      List<String> ans = new ArrayList<String>();
      boolean inblock = false;    //use this boolean to represent the status
      StringBuilder newline = new StringBuilder();
      for(String line:source) {
        int i = 0;
        char[] chars = line.toCharArray();    //convert to char array
        if(!inblock) newline = new StringBuilder();
        while(i < line.length()) {
          if(!inblock && i+1 < line.length() && chars[i]=='/'&& chars[i+1]=='/') {
            // for "//"
            break;    //directly ignore the line
          }else if(!inblock && i+1 < line.length() && chars[i]=='/'&& chars[i+1]=='*') {
            // for "/*"
            inblock = true;
            i++;
          }else if(inblock && i+1 < line.length() && chars[i]=='*'&& chars[i+1]=='/') {
            inblock = false;
            i++;
          }else if(!inblock) {
            newline.append(chars[i]);
          }
          i++;
        }
        if(!inblock && newline.length() > 0) ans.add(newline.toString());   //when it's not empty
      }
      return ans;
    }
  
}
