/*
corner cases:
haystack is "" 
    needle is ""  return 0;
    needle isn't "" return -1;

*/
///////////////////////////////////////////////////////
class Solution {
public:
    int strStr(string haystack, string needle) {
        return haystack.find(needle);
    }
};
