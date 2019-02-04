/*
corner cases:
haystack is "" 
    needle is ""  return 0;
    needle isn't "" return -1;
    
syntax:
str.find(needle);   //return the index in str of the first char in needle

*/
///////////////////////////////////////////////////////
class Solution {
public:
    int strStr(string haystack, string needle) {
        return haystack.find(needle);
    }
};
