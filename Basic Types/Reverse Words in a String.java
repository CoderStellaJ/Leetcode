/*
Runtime: 9 ms, faster than 25.17% of Java online submissions for Reverse Words in a String.
Memory Usage: 37.3 MB, less than 99.08% of Java online submissions for Reverse Words in a String.

Algorithm: same as .cpp algo, but using a stringbuilder makes it faster without creating new strings.
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
  public String reverseWords(String s) {
    s = s.trim();
    int len = s.length();
    if(len == 0) return s;
    StringBuilder sb = new StringBuilder();
    StringBuilder word = new StringBuilder();
    for(int i = 0; i < len; i++) {
      if(s.charAt(i) == ' ') {
        if(word.length() != 0) {
          if(sb.length() != 0) sb.insert(0," ");
          sb.insert(0, word);
          word = new StringBuilder();
        }
      }else{
        word.append(s.charAt(i));
      }
    }
    if(sb.length() != 0) sb.insert(0," ");
    sb.insert(0, word);
    return sb.toString();
  }
}
