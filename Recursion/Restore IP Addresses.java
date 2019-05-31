/*
Runtime: 2 ms, faster than 86.96% of Java online submissions for Restore IP Addresses.
Memory Usage: 35.6 MB, less than 66.50% of Java online submissions for Restore IP Addresses.


Algorithm: Recursion
1. IP is divided into 4 sections, each section can only be number ranging from 0 to 255
2. Note that 005 is not allowed so the range of the value converted from string is also dependent on the string length!

*/
/////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public List<String> restoreIpAddresses(String s) {
        //recursion
        List<String> ans = new ArrayList<String>();
        if(s.length() > 12 || s.length() < 4) return ans;
        return helper(s,4);
    }
    public List<String> helper(String s, int sec){
      List<String> ans = new ArrayList<String>();
      //base case
      if(s.length() == 0) return ans;
      if(sec == 1){
        int val = Integer.parseInt(s);
        if((s.length()==3 && val >= 100 && val <= 255) || (s.length() == 2 && val >= 10 && val <= 255) || (s.length()==1)) ans.add(s);
        // the condition is also dependent on the string length
        return ans;	//empty means it fails
      }
      String str1,str2,str3;
      List<String> res1,res2,res3;
      //str1, take one char only
      str1 = s.substring(0,1)+".";
      res1 = helper(s.substring(1), sec-1);
      if(!res1.isEmpty()){
        for(String str:res1){
          ans.add(str1+str);
        }
      }
      if(s.length() >= 2 && Integer.parseInt(s.substring(0,2)) <= 255 && Integer.parseInt(s.substring(0,2)) >= 10){
        str2 = s.substring(0,2)+".";
        res2 = helper(s.substring(2), sec-1);
        if(!res2.isEmpty()){
          for(String str:res2){
            ans.add(str2+str);
          }
        }	
      }
      if(s.length() >= 3 && Integer.parseInt(s.substring(0,3)) <= 255 && Integer.parseInt(s.substring(0,3)) >= 100 ){
        str3 = s.substring(0,3)+".";
        res3 = helper(s.substring(3), sec-1);
        if(!res3.isEmpty()){
          for(String str:res3){
            ans.add(str3+str);
          }
        }	
      }
      return ans;
    }
}
