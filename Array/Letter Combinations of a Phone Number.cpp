/*
Runtime: 4 ms, faster than 98.69% of C++ online submissions for Letter Combinations of a Phone Number.
Memory Usage: 8.7 MB, less than 67.00% of C++ online submissions for Letter Combinations of a Phone Number.
Algorithm:
by using hashmap to store corresponding string
the algorithm is the same as Subsets question
Syntax:
1. str.length()
2. myvec.erase(myvec.begin() + k)
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<string> letterCombinations(string digits) {
      std::map<char, string> mydict;
      mydict['2'] = "abc";
      mydict['3'] = "def";
      mydict['4'] = "ghi";
      mydict['5'] = "jkl";
      mydict['6'] = "mno";
      mydict['7'] = "pqrs";
      mydict['8'] = "tuv";
      mydict['9'] = "wxyz";
      if(digits.length() == 0) return {};
      vector<string> res = {""};
      for(int i = 0; i < digits.length(); i++) {
        vector<string> temp;
        for(int k = 0; k < res.size(); ) {  //iterate thru all strings in vector
          string s = res[k];
          res.erase(res.begin()+k);
          for(int j = 0; j < mydict[digits[i]].length(); j++) {
            //add all possible chars in dict into vector
            string newstr = s + mydict[digits[i]][j];
            temp.push_back(newstr);
          }
        }
        for(string str:temp) {
          res.push_back(str);
        }
      }
      return res;     
    }
};
