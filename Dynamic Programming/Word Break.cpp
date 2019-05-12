/*
Runtime: 0 ms, faster than 100.00% of C++ online submissions for Word Break.
Memory Usage: 8.9 MB, less than 96.83% of C++ online submissions for Word Break.

Complexity:
Runtime: O(NM), N is length of string, M is size of wordDict
Space: O(N)

Algorithm 3:
1. String length N may be very large, can also try to compare from wirdDict perspective
2. Because we don't need to look up the key in set, can directly use vector instead of creating a set

Syntax:
can only use iterator to loop through a set in c++
*/
////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
      std::unordered_set<string> mydict;

      vector<bool> res(s.length()+1,false);    //records result of substring(0:i)
      res[0] = true;
      for(int i = 0; i < s.length(); i++) {
        for(int j = 0; j < wordDict.size(); j++) {
          int len = wordDict[j].length();
          if(i-len+1 >= 0 && res[i-len+1] == true){   //make sure the index is valid
            if(s.substr(i-len+1,len) == wordDict[j]){   //substr(index, len), here index shouldn't be i as i is the ending index
              res[i+1] = true;
              break;
            }
          }
          
        }
      }
      return res[s.length()];     //s.length()
    }
};

///////////////////////////////////////////////////////////////////////////////////////
/*
Complexity:
Runtime: O(N^2), N is length of string, M is size of wordDict
Space: O(N)

Algorithm 2:
1. Checking substr(0,k) is time-consuming. A better way is to set res as s.length()+1 and set [0] as true
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
      std::unordered_set<string> mydict;
      for(int i = 0; i < wordDict.size(); i++) {
        mydict.insert(wordDict[i]);
      }
      vector<bool> res(s.length()+1,false);    //records result of substring(0:i)
      res[0] = true;
      for(int i = 0; i < s.length(); i++) {
        for(int j = 0; j <= i; j++) {
          if(res[j] == true){
            if(mydict.find(s.substr(j,i-j+1)) != mydict.end()) {
              res[i+1] = true;
              break;
            }
          }
        }
      }
      return res[s.length()];  
    }
};
////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 16 ms, faster than 61.35% of C++ online submissions for Word Break.
Memory Usage: 14.6 MB, less than 36.24% of C++ online submissions for Word Break.

Complexity:
Runtime: O(N^2), N is length of string
Space: O(N)

Algorithm 1:
DP
Note: finding the first true for substr(0,k) is important

Syntax:
1. unordered_set
unordered_set<string> stringSet; 
it's implemented based on hash table and all operations take O(1)
myset.insert(myval);
2. to_string(myvar) to cast any type to string
3. substr(pos,len)
[pos, pos+len)
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
      std::unordered_set<string> mydict;
      for(int i = 0; i < wordDict.size(); i++) {
        mydict.insert(wordDict[i]);
      }
      if(s.length() == 0) return true;
      vector<bool> res(s.length(),false);    //records result of substring(0:i)
      
      for(int i = 0; i < s.length(); i++) {
        if(mydict.find(s.substr(0,i+1)) != mydict.end()){
          res[i] = true;
          continue;
        }
        for(int j = 0; j < i; j++) {
          if(res[j] == true){
            if(mydict.find(s.substr(j+1,i-j)) != mydict.end()) {
              res[i] = true;
              break;
            }
          }
        }
      }
      return res[res.size()-1];  
    }
};
