/*
Runtime: 11 ms, faster than 69.61% of Java online submissions for Wildcard Matching.
Memory Usage: 38.2 MB, less than 89.42% of Java online submissions for Wildcard Matching.

Complexity:
runtime: O(MN)
space: O(MN)

Algorithm 4: 
The hard point is finding this relationship for '*'
dp[i][j] = (dp[i-1][j] || dp[i][j-1]);    //dp[i-1][j] for maping more than 1 char; dp[i][j-1] for matching empty string
Now, we don't need the inner loop of k and judge whether dp is false before updating
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for(int j = 0; j < p.length(); j++) {
      if(p.charAt(j) == '*') dp[0][j+1] = true;
      else break;
    }
    
    for(int i = 1; i <= s.length(); i++) {
      for(int j = 1; j <= p.length(); j++) {
        char cs = s.charAt(i-1); 
        char cp = p.charAt(j-1);
        if(cp == '?' || cp == cs){
          dp[i][j] = dp[i-1][j-1];
        }else if(cp == '*'){
          dp[i][j] = (dp[i-1][j] || dp[i][j-1]);   
        }
      }
    }
    // for(int i = 0; i <= s.length(); i++) {
    //   for(int j = 0; j <= p.length(); j++) {
    //     System.out.print(" "+dp[i][j]);
    //   }
    //   System.out.println();
    // }
    return dp[s.length()][p.length()];
  }
}
///////////////////////////////////////////////////////////////////////////////
/*
Runtime: 246 ms, faster than 5.02% of Java online submissions for Wildcard Matching.
Memory Usage: 36.9 MB, less than 99.96% of Java online submissions for Wildcard Matching.

Complexity:
runtime :O(M(N^2))
space: O(MN)

Algorithm 3:
use dp to record whether s[0,i] matches with s[0,j]
Note:
update dp[i][j] only when it's false 
Because * matches the ones in latter part

Algorithm 3: DP
use array to record whether s[0,i] can match p[0,j]
*/
//////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
    dp[0][0] = true;
    for(int j = 0; j < p.length(); j++) {
      if(p.charAt(j) == '*') dp[0][j+1] = true;
      else break;
    }
    for(int i = 1; i <= s.length(); i++) {
      for(int j = 1; j <= p.length(); j++) {
        char cp = p.charAt(j-1);
        char cs = s.charAt(i-1);  
        if(cp == '?'){
          if(dp[i][j] == false) dp[i][j] = dp[i-1][j-1];
        }else if(cp == '*'){
          for(int k = i; k <= s.length(); k++){
            if(dp[k][j] == false) dp[k][j] = (dp[i-1][j-1] || dp[i][j-1]);
          }
        }else{
          if(cp == cs) {
            if(dp[i][j] == false) dp[i][j] = dp[i-1][j-1];
          }
          else dp[i][j] = false;
        }
      }
    }
    // for(int i = 0; i <= s.length(); i++) {
    //   for(int j = 0; j <= p.length(); j++) {
    //     System.out.print(" "+dp[i][j]);
    //   }
    //   System.out.println();
    // }
    return dp[s.length()][p.length()];
  }
}
//////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded
"abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbabab
ababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb"
"**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"

Algorithm 2: Recursion
For consecutive '*', consider them as a whole
*/
//////////////////////////////////////////////////////////////
class Solution {
  public boolean isMatch(String s, String p) {
    if(p.length() == 0) {
      if(s.length() == 0) return true;
      else return false;
    }else if(s.length() == 0) {
      for(int i = 0; i < p.length(); i++) {
        if(p.charAt(i) != '*') return false;
      }
      return true;
    }
    
    return match(s,0,p,0);
    
  }
  
  private boolean match(String s, int inds, String p, int indp) {
    //base cases
    if(inds == s.length() && indp == p.length()) return true;
    if(inds == s.length() && indp != p.length()) {
      for(int i = indp; i < p.length(); i++) {
        if(p.charAt(i) != '*') return false;
      }
      return true;
    }
    if(inds != s.length() && indp == p.length()) return false;
    
    char cs = s.charAt(inds), cp = p.charAt(indp);
    if(cp == '?'){
      return match(s, inds+1, p, indp+1);
    }else if(cp == '*'){
      int indexp = indp;
      for(int j = indp; j < p.length(); j++) {
        if(p.charAt(j) == '*') indexp = j;
        else break;
      }
      //empty or >= 1
      for(int i = 0; i <= s.length()-inds; i++) {
        if(match(s, inds+i, p, indexp+1)) return true;
      }
    }else {
      if(cp == cs) {
        return match(s, inds+1, p, indp+1);
      }else return false;
    }
    return false;
  }
}
///////////////////////////////////////////////////////////////
/*
Time Limit Exceeded
"aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba"
"a*******b"

Complexity:
runtime: O(N^2)
space: O(1)

Algorithm 1: Recursion

Corner case:
1. s = "a", p = "a*"
*/
/////////////////////////////////////////////////////////////
class Solution {
  public boolean isMatch(String s, String p) {
    if(p.length() == 0) {
      if(s.length() == 0) return true;
      else return false;
    }else if(s.length() == 0) {
      for(int i = 0; i < p.length(); i++) {
        if(p.charAt(i) != '*') return false;
      }
      return true;
    }
    return match(s,0,p,0);
  }
  
  private boolean match(String s, int inds, String p, int indp) {
    //base cases
    if(inds == s.length() && indp == p.length()) return true;
    if(inds == s.length() && indp != p.length()) {
      for(int i = indp; i < p.length(); i++) {    //for corner case
        if(p.charAt(i) != '*') return false;
      }
      return true;
    }
    if(inds != s.length() && indp == p.length()) return false;
    
    char cs = s.charAt(inds), cp = p.charAt(indp);
    if(cp == '?'){
      return match(s, inds+1, p, indp+1);
    }else if(cp == '*'){
      //empty or >= 1
      for(int i = 0; i <= s.length()-inds; i++) {
        if(match(s, inds+i, p, indp+1)) return true;
      }
    }else {
      if(cp == cs) {
        return match(s, inds+1, p, indp+1);
      }else return false;
    }
    return false;
  }
  
  public static void main(String[] args) {
    Solution sol = new Solution();
    String s = "a";
    String p = "a*";
    boolean ans = sol.isMatch(s, p);
    System.out.println(ans);
  }
}
