/*
Palindrome substring using 2D array to store the result of sub problem.

Algorithm: O(N^2)
1.写之前想清楚你的2D array里每一个dimension的含义，它要装什么。
row: start index; column: length of substring.
2.array initialization 去保证Index不越界也不会留default value.

Space: O(N^2)

Syntax:
1. length of string: s.length()
2. s[i] is directly the char of index i


Test cases:
string length is 0.

*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length();
        int sublen = 1;
        if(len == 0) {      //corner test case!
            return "";
        }
        int palin [len][len];
        int start;
        int end;
        string output = "";
        bool find = false;
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                if(j == 0) { 
                    palin[i][0] = 1;
                }else if(j == 1) {
                    if(i < len-1) {
                        if(s[i] == s[i+1]) {
                            plain[i][1] = 1;
                        }
                    }
                    palin[i][1] = 0;
                    
                }else {
                    palin[i][j] = 0;
                }
            }
        }
        
        for(sublen = 2; sublen < len; sublen++) {
            for(int i = 0; i < len-sublen; i++) {
                if(s[i] == s[i+sublen] ){
                    if(palin[i+1][sublen-2] == 1) {     //sublen-2 !
                        palin[i][sublen]=1;
                    }
                }
            }
        }
      
        
        for(int j = len-1; j >= 0 && find == false; j--) {
            for(int i = 0; i < len && find == false; i++) {
                if(palin[i][j] == 1) {
                    start = i;
                    end = i+j;
                    find = true;
                }
            }
        }
        
        for(int i = start; i <= end; i++) {
            output = output + s[i];
        }
        return output;
        
    }
};
