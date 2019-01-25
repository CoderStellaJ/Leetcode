class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int ind = 0;
        int numstr = strs.size();
        if(numstr == 0) {   //when variable is used as length of array, always check whether length is 0
            return "";
        }
        int len [numstr];
        int minlen;
        string result = "";
        char letter = '\0';
        for(int i = 0; i < numstr; i++) {
            len[i] = (strs.at(i)).length();
        }

        minlen = *std::min_element(len,len+numstr);
        //debug
        //cout<<minlen<<endl;
        
        for(ind = 0; ind < minlen; ind++) {
            letter = (strs.at(0))[ind];
            bool add = true;
            for(int j = 1; j < numstr; j++) {
                if((strs.at(j))[ind] != letter) {
                    add = false;
                    break;
                }
            }
            //debug
            //cout<< letter <<" "<<add << endl;
            if(add == true) {
                result = result + letter;
            } else {    //it's prefix, so break once add is false!!
                break;
            }			
        }
        return result;
    }
};
///////////////////////////////////////////////////////////////
/*

Complexity: O(n*m)
n is number of string, m is length of common prefix.

Algorithm:
Always rememebr to check whether the array length is 0. And especially when you use this length to create another array.

Syntax:
1. str.length()
2. initialization of char: you can't use '', this represents no char which is nonsense.
   You need to use '\0' to initialize
3. min element in an array
   #include <algorithm>
   *std::min_element(arr,arr+numelement)
   
Programming habit:
debugging statement: //debug
After debugging, simply comment it out without deleting it.
   
*/
