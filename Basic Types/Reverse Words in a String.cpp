/*
Runtime: 44 ms, faster than 12.65% of C++ online submissions for Reverse Words in a String.
Memory Usage: 80.5 MB, less than 7.77% of C++ online submissions for Reverse Words in a String.

Complexity:
Runtime: O(N)
Space: O(N)

Algorithm 1:
Deal with all the edge cases with all if-else conditions
*/
/////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string reverseWords(string s) {
      string res = "";
      string word = "";
      bool isword = false;
      for(int i = 0; i < s.length(); i++) {
        if(s[i] != ' '){
          isword = true;
          word = word+s[i];
        }else {
          if(isword == true){
            if(res == "") res = word+res;
            else res = word+" "+res;
            word = "";
          }
          isword = false;
        }
      }
      if(isword == true){
        if(res == "") res = word+res;
        else res = word+" "+res;
      }
      return res;
    }
};
