/*


Algorithm 4: HashMap + Recursion
The key part to save time is to avoid solving the same subproblem over and over again.
The best way is to store each subarray it has solved into a hashmap
So that in the next case, you can retrieve the answer immediately

Syntax:
1. mystr.startsWith(mystr);
*/
////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded:

Complexity:
runtime: O(N^2)
space: O(N)

Algorithm 3: HashSet
Checking the wordDict one by one is time-consuming. A better way is using a hashset and check based on what s has.
*/
///////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      HashSet<String> myset = new HashSet<String>();
      List<List<String>> ans = new ArrayList<List<String>>();
      //list[i] subproblem from 0 to i
      for(int i = 0; i < wordDict.size(); i++) {
        myset.add(wordDict.get(i));
      }
      for(int i = 0; i < s.length(); i++) {
        ans.add(new ArrayList<String>());
      }
      int len = 0;
      for(int i = 0; i < s.length(); i++) {
        for(int j = 0; j < i+1; j++) {
          //consider each stirng in the dict
          String cur = s.substring(j,i+1);
          if(myset.contains(cur)){
            if(j == 0) ans.get(i).add(cur);
            else{
              for(int k = 0; k < ans.get(j-1).size(); k++) {
                ans.get(i).add(ans.get(j-1).get(k) + " " + cur);
              }
            }
          }
        }
      }
      return ans.get(ans.size()-1);
    }
}
//////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorothm 2: Dynamic Programming

Syntax:
1. array: "You cannot create arrays of parameterized types"
*/
//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
      List<List<String>> ans = new ArrayList<List<String>>();
      //list[i] subproblem from 0 to i
      for(int i = 0; i < s.length(); i++) {
        ans.add(new ArrayList<String>());
      }
      int len = 0;
      for(int i = 0; i < s.length(); i++) {
        for(int j = 0; j < wordDict.size(); j++) {
          //consider each stirng in the dict
          String cur = wordDict.get(j);
          len = cur.length();
          if(i-len >= -1 && s.substring(i+1-len, i+1).equals(cur)){
            if(i-len == -1) ans.get(i).add(cur);
            else{
              for(int k = 0; k < ans.get(i-len).size(); k++) {
                ans.get(i).add(ans.get(i-len).get(k) + " " + cur);    //cur at the back
              }
            }
          }
        }
      }
      return ans.get(ans.size()-1);
    }
}
//////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm 1: Recursion
use a helper function to solve subproblems
*/
////////////////////////////////////////////////////////////////////////////////////////////
import java.util.*;


class Solution {
    static int i = 0;
    public List<String> wordBreak(String s, List<String> wordDict) {
      return helper(s, wordDict, 0);
    }
  
    public List<String> helper (String s, List<String> mydict, int start) {
      List<String> ans = new ArrayList<String>();
      //stores the answer which is a list of strings
      int len = 0;
      if(start >= s.length()) return ans;  //empty
      for(int i = 0; i < mydict.size(); i++) {
        String cur = mydict.get(i);
        len = cur.length();
        if(start+len <= s.length() && s.substring(start,start+len).equals(cur)) {
          if(start+len < s.length()){
            List<String> sub = helper(s, mydict, start+len);
            for(int j = 0; j < sub.size(); j++) {
              ans.add(cur+" "+sub.get(j));
            }
          }else { 
            //at the end
            ans.add(cur);
          }
          
        }
      }
      return ans;
    }
  
    public static void main(String[] args) {
      Solution mysol = new Solution();
      String s1 = "catsanddog";
      String s2 = "pineapplepenapple";
      List<String> mydict1 = new ArrayList<String>(List.of("cat", "cats", "and", "sand", "dog"));
      List<String> mydict2 = new ArrayList<String>(List.of("apple", "pen", "applepen", "pine", "pineapple"));
      //System.out.println(mydict1);
      List<String> ans1 = mysol.wordBreak(s1, mydict1);
      System.out.println("ans 1");
      System.out.println(ans1);
      
      List<String> ans2 = mysol.wordBreak(s2, mydict2);
      System.out.println("ans 2");
      System.out.println(ans2);
    }
  
}
