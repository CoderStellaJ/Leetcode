/////////////////////////////////////////////////////////////////////////
/*
Runtime: 0 ms, faster than 100.00% of C++ online submissions for Jewels and Stones.
Memory Usage: 8.6 MB, less than 98.47% of C++ online submissions for Jewels and Stones.

Syntax:
1. string length
str.length()

2. find key value in map
auto itr = mp.find(mykeyvalue)
itr->first: key
itr-> second: value

if ( m.find(mykeyvalue) == m.end() ) {
  // not found
} else {
  // found
}
*/
////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int numJewelsInStones(string J, string S) {
        std::map<char, int> mymap;
        int count = 0;
        int k = 0;
        for(int i = 0; i < J.length(); i++) {
            mymap[J[i]] = k;
            k++;
        }
        for(int j = 0; j < S.length(); j++) {
            if(mymap.find(S[j]) != mymap.end()) {
                count++;
            }
        }
        return count;
    }
};
