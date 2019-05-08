/*
Runtime: 48 ms, faster than 98.70% of C++ online submissions for Reverse String.
Memory Usage: 15.4 MB, less than 97.54% of C++ online submissions for Reverse String.
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void reverseString(vector<char>& s) {
        int len = s.size();
        char tmp;
        for(int i = 0; i < len/2; i++) {
            tmp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = tmp;
        }
    }
};
