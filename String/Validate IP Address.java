/*
Runtime: 1 ms, faster than 98.36% of Java online submissions for Validate IP Address.
Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Validate IP Address.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: class structure building
1. ipv4:
1) group:4
2) each group check length/digit/range

2. ipv6
1) group: 8
2) each group check length/digit or char/

Syntax:
1. check whether a char is digit or alphabetic letter
Character.isDigit(c);
Character.isAlphabetic(c);

Corner case:
1. 
"1.0.1." each group can't be empty

*/
////////////////////////////////////////////////////////////////////////////
class Solution {
  public String validIPAddress(String IP) {
    //check whether it's ipv4 or ipv6
    int indexdot = IP.indexOf(".");
    int indexcol = IP.indexOf(":");
    if(indexdot == -1 && indexcol == -1) return "Neither";
    else if(indexdot != -1 && indexcol != -1) return "Neither";
    else if(indexdot != -1 && checkipv4(IP) == true) return "IPv4";
    else if(indexcol != -1 && checkipv6(IP) == true) return "IPv6";
    return "Neither";
  }
  
  
  private boolean checkipv4(String IP) {
    int ind = IP.indexOf("."), count = 0, start = 0;
    
    while(((ind != -1 && count != 3) || (count == 3)) && count <= 3) {
      String str = "";
      if(count == 3) ind = IP.length();
      str = IP.substring(start, ind);
      int len = ind-start;
      if(len < 1 || len > 3) return false;
      //check whether it only contains digits
      for(int i = start; i < ind; i++) {
        char c = str.charAt(i-start);
        if(!Character.isDigit(c)) return false;
      }
      int range = Integer.parseInt(str);
      // System.out.println("len is "+len);
      // System.out.println("range is "+range);
      // System.out.println("count is "+count);
      if(len == 1) {
        if(range < 0 || range > 9) return false; 
      }else if(len == 2){
        if(range < 10 || range > 99) return false;
      }else if(len == 3) {
        if(range < 100 || range > 255) return false;
      }
      start = ind+1;
      ind = IP.indexOf(".", start);
      count++;
    }
    if(count == 4) return true;
    else return false;
  }
  
  
  private boolean checkipv6(String IP) {
    int ind = IP.indexOf(":"), count = 0, start = 0;
    
    while(((ind != -1 && count != 7)||count == 7) && count <= 7) {
      String str = "";
      if(count == 7) ind = IP.length();
      str = IP.substring(start, ind);
      //check whether each char is valid
      for(int i = start; i < ind; i++) {
        char c  =str.charAt(i-start);
        int diff = Character.toLowerCase(c) - 'a';
        if(!(Character.isDigit(c)||(Character.isAlphabetic(c) && diff >= 0 && diff <= 5))) return false;
      }
      int len = ind-start;
      if(len == 0 || len > 4) return false;
      start = ind+1;
      ind = IP.indexOf(":",start);
      count++;
    }
    if(count == 8) return true;
    return false;
  }
}
