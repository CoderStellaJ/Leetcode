/*
Runtime: 4 ms, faster than 80.79% of Java online submissions for Valid Palindrome.
Memory Usage: 38 MB, less than 59.85% of Java online submissions for Valid Palindrome.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 2: 2 Pointers
Loop thorough once and combine the replacement with iteration
Note: 
in small while loop add i < j condition to avoid outofbound 
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isPalindrome(String s) {
    int i = 0, j = s.length()-1;
    while(i < j) {
      char a = s.charAt(i);
      char b = s.charAt(j);
      while(i < j && !(Character.isAlphabetic(a) || Character.isDigit(a))) {    //i<j condition!!
        i++;
        a = s.charAt(i);
      }
      while(i < j && !(Character.isAlphabetic(b) || Character.isDigit(b))) {
        j--;
        b = s.charAt(j);
      }
      if(Character.toUpperCase(a) != Character.toUpperCase(b)) return false;
      else {
        i++;
        j--;
      }
    }
    return true;
  }
}
/////////////////////////////////////////////////////////////////////////
/*
Runtime: 21 ms, faster than 13.03% of Java online submissions for Valid Palindrome.
Memory Usage: 37.6 MB, less than 67.11% of Java online submissions for Valid Palindrome.

Complexity: 
runtime: O(N)
space: O(1)

Algorithm 1:
remove all the non-alphanumberic chars in the string and then 

Syntax:
1. remove all non-alphanumeric chars in a string
s = s.replaceAll("[^A-Za-z0-9]","");
regular expression: [^]: matches a single character that is not contained in bracket
2. compare string ignoring the case
str1.equalsIgnoreCase(str2)
3. Character.toUpperCase(mychar) doesn't change mychar itself but return a new char
myobj.method() changes myobject itself
method(myobj) normally just return a new object after the operation
*/
///////////////////////////////////////////////////////////////////////
class Solution {
    public boolean isPalindrome(String s) {
    s = s.replaceAll("[^A-Za-z0-9]","");
    //System.out.println(s);
    int len = s.length();
    for(int i = 0; i < len/2; i++) {
      if(Character.toUpperCase(s.charAt(i))!=Character.toUpperCase(s.charAt(len-1-i))) return false;
    }
    return true;
  }
}
