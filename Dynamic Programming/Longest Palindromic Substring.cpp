class Solution {
public:
    string longestPalindrome(string s) {
        int len = s.length();
        int sublen = 1;
        if(len == 0) {
            return "";
        }
        int palin [len][len];
        int start;
        int end;
        string output = "";
        bool find = false;
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                palin[i][j] = 0;
            }
        }
        
        for(int i = 0;i < len; i ++) {
            palin[i][0] = 1;
        }
        for(int i = 0; i < len-1; i++) {
            if(s[i] == s[i+1]){
                palin[i][1] = 1;
            }else{
                palin[i][1] = 0;
            }
        }
        
        for(sublen = 2; sublen < len; sublen++) {
            for(int i = 0; i < len-sublen; i++) {
                if(s[i] == s[i+sublen] ){
                   
                    if(palin[i+1][sublen-2] == 1) {
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
