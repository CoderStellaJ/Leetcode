/*
Runtime Error

Algorithm:
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