class Solution {
public:
    bool isPalindrome(int x) {
        int numlen = 0;
        if(x < 0) return false;
        if(x == 0) return true;
        int num = x;
        while(num > 0) {
            num/=10;
            numlen++;

        }
        int digit[numlen];
        int k = numlen-1;
        while(x > 0) {
            digit[k] = x%10;
            x/=10;
            k--;
        }
        for(int j = 0; j <= numlen/2; j++) {
            if(digit[j] != digit[numlen-j-1]) {   //[numlen-1-j], take noteice of the index
                return false;
            }
        }
        return true;
    }
};
