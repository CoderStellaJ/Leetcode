/*
Complexity:
runtime: O(|S|+|T|)
space: O(|S|+|T|)

Algorithm 3:
Improved from algorithm 2
remove all the chars in s that are not in t

*/  
////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 26 ms, faster than 26.80% of Java online submissions for Minimum Window Substring.
Memory Usage: 38.9 MB, less than 62.55% of Java online submissions for Minimum Window Substring.

Copmlexity:
runtime: O(|S|+|T|)
containsKey() is normally O(1), but in worst case, it can be O(N) in the worst case
space: O(|S|+|T|)

Algorithm 2:
use hashmap to count and check whether all letters are contained
And counting characters helps because this can cover the case not covered in Algorithm 1
1. dictT HashMap records all characters and their counting in string t
2. windows HashMap records the characters in window
3. formed records how many characters conditions are met.
4. loop through s while right < s.length()
    keep checking right in window and see whether formed condition is met
       if met, try to truncate the window by moving left to right
       if not met, keep moving right to right

Syntax:
1. java.util.HashMap getOrDefault()
Basically this method is to return a default value 
whenever the value was not found using the key specified on the HashMap. 
2. put something into a hashmap
mymap.put(A, B)
And this will replace the value of existing key in the map
3. size of hashmap
mymap.size()
4. Difference between Map and Hashmap
Map is an interface, i.e. an abstract "thing" that defines how something can be used. 
HashMap is an implementation of that interface.
5. Types cannot be primitive types
Map<Character, Integer> dictT = new HashMap<Character, Integer>();
6. Check whether the map contains a key
mydict.containsKey()
7. array in java
int[] ans = {-1, 0, 0};     //use {} to initialize array
8. Get value from map using key
mymap.get(mykey)
9. use chatAt(index) to get a char from string
*/
////////////////////////////////////////////////////////////////////
class Solution {
    public String minWindow(String s, String t) {
        if(s.length() == 0 || t.length() == 0) return "";
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        // ans list of the form (window length, left, right)
        int[] ans = {-1,0,0};    
        //use array to record the set of results instead of using 3 variables
        //records the number occurrences of each char in t
        for(int i = 0; i < t.length(); i++) {           //O(|T|)
            int count = dictT.getOrDefault(t.charAt(i),0);
            dictT.put(t.charAt(i),count+1);
        }
        int number = dictT.size();
        Map<Character, Integer> windows =  new HashMap<Character, Integer>();
        //count the number of unique characters in the window and count 
        int left = 0;
        int right = 0;
        int formed = 0;    //to keep track of how many chars meet requirement of frequency
        while(right < s.length()) {     //O(|S|)
            //update the frequency in windows map
            char c = s.charAt(right);
            int count = windows.getOrDefault(c,0);
            windows.put(c,count+1);
            //check whether window [left, right] contains all chars
            if(dictT.containsKey(c) && dictT.get(c).intValue() == windows.get(c).intValue()) formed++;
            while(left <= right && formed == number) {    //truncate the window
                if(ans[0] == -1 || right-left+1 < ans[0]){
                    ans[0] = right-left+1;
                    ans[1] = left;
                    ans[2] = right;
                }
                char leftchar = s.charAt(left);
                windows.put(leftchar, windows.get(leftchar)-1);
                if(dictT.containsKey(leftchar) && windows.get(leftchar).intValue() < dictT.get(leftchar).intValue()) formed--;
                left++;              
            }
            right++;
        }
        return ans[0] == -1? "":s.substring(ans[1],ans[2]+1);
    }
}
////////////////////////////////////////////////////////////////////
/*
Runtime Error

Algorithm 1:
problem: doesn't consider the following case:
"aaflslflsldkalskaaa"
"aaa"

Syntax:
1. string length
mystr.length()
2. substring in java
mystr.substring(begin, end)   //[begin,end)
3. string contains a char
mystr.contains(Character.toString(mychar))
4. get char from string using index
mystr.charAt(myindex)
5. avoid using do while
*/
/////////////////////////////////////////////////////////////////
class Solution {
    public String minWindow(String s, String t) {
      int start = 0;
      int end = -1;
      String res = ""; 
      int minlen = -1;
      int startind = 0;
      int endind = 0;
      while(start < s.length()){
          //System.out.println("start: "+start);
          //System.out.println("end: "+end);
          if(!t.contains(Character.toString(s.charAt(start)))){
              //System.out.println("find start: "+start);
              start++;
          }else {
              //System.out.println("start correct: "+start);
              if(end < start) end = start;  //condition is end < start
              Boolean containsall = false;
              String sub = "";
              while(end<s.length() && containsall == false){    //use while instead of do while
                  containsall = true;
                  //System.out.println("start in loop: "+start);
                  //System.out.println("end in loop: "+end);
                  sub = s.substring(start,end+1);
                  for(int j = 0; j < t.length(); j++){
                      char tchar = t.charAt(j);
                      if(sub.contains(Character.toString(tchar)) == false) {
                          containsall = false;
                          end++;
                          break;
                      }
                  }
              }
              if(containsall != false) {
                  if(minlen == -1 || sub.length()<minlen){
                      minlen = sub.length();
                      startind = start;
                      endind = end;
                      //System.out.println("minlen : "+minlen);
                      //System.out.println("startind : "+startind);
                      //System.out.println("endind : "+endind);
                  }
              }
              start++;    //for both containsall = false and containsall = true
          }
      }
      //System.out.println("minlen : "+minlen);
      //System.out.println("startind : "+startind);
      //System.out.println("endind : "+endind);
      return minlen == -1? "":s.substring(startind,endind+1);
    }
}
