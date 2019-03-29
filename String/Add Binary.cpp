/*
Runtime: 8 ms, faster than 68.20% of C++ online submissions for Add Binary.
Memory Usage: 9.4 MB, less than 5.57% of C++ online submissions for Add Binary.

Algorithm: addition operation
Note:
when you are changing string length/vector size by adding or removing, you can't make it as the condition of loop
And digit needs to be added in front of the ans string 

Syntax:
1. convert string to int
str - '0'

Corner case:
both strings are empty, ans is "", then return "0"
*/
////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string addBinary(string a, string b) {
        int add = 0;
        int lena = a.length();
        int lenb = b.length();
        if(a.length() < b.length()) {
            for(int m = 0; m < lenb - lena; m++) {  //must use lena and lenb to represent original string length. lengths change in loop
                a = "0" + a;
            }
        }else if(a.length() > b.length()) {
            for(int m = 0; m < lena - lenb; m++) {
                b = "0" + b;
            }
        }
        int sum;
        int num1, num2;
        string ans = "";
        for(int i = a.length()-1; i >= 0; i--) {
            num1 = a[i] - '0';    
            num2 = b[i] - '0';
            sum = num1 + num2 + add;
	          if(sum == 0) {
		            add = 0;
                ans = "0" + ans;    // new digit add in front
	          }else if(sum == 1) {
                add = 0;
                ans = "1" + ans;
            }else if(sum == 2) {
                add = 1;
                ans = "0" + ans;
            }else if(sum == 3) {
		            add = 1;
                ans = "1" + ans;
            }
        }
        if(add == 1) {
            ans = "1" + ans;
        }
        if(ans == "") {
            return "0";
        }
	  return ans;
    }
};
