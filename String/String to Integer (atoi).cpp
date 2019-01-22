class Solution {
public:
    int myAtoi(string s) {
        int len = s.length();
        int start = 0;
        int end = 0;
        bool sign = false;
        int numsign = 1;
        bool numstart = false;
        int result = 0;
        
        for(int i = 0; i < len; i++) {
            if(s[i] == ' ') {
                if(numstart == true){
                    end = i-1;
                    break;
                }
            }else if(s[i] == '+' || s[i] == '-') {
                if(numstart == false) {
                    numstart = true;
                    start = i;
                    sign = true;
                }else {
                    end = i-1;
                    break;
                }
            }else if(isdigit(s[i])) {
                if(numstart == false) {
                    numstart = true;
                    start = i;
                }else {
                    end = i;
                }
            }else {
                if(numstart == false) {
                    return 0;
                }else {
                    end = i-1;
                    break;
                }

            }
        } 
        
        if(numstart == false) {
            return 0;
        }
        
        if(sign == true) {
            if(s[start] == '-') {
                numsign = -1;
            }
            if(end == start) {
                return 0;
            }
            start = start +1;
        }

        //cout<<start<<" "<<end<<endl;
        
        for(int j = start; j <= end; j++) {
            if(s[j] == '0') {
                start ++;
            }else{
                break;
            }
        }
        
        //cout<<start<<" "<<end<<endl;
        
        for(int j = start; j <= end; j++) {
            if(numsign > 0) {
                if(result > INT_MAX/10) {
                    return INT_MAX; 
                }else {
                    if((int)(s[j]-'0') > 7 && result == INT_MAX/10){
                        return INT_MAX;
                    }
                }
            }else {
                if(result*numsign < INT_MIN/10) {
                    return INT_MIN;
                }else if(result*numsign == INT_MIN/10 && (int)(s[j]-'0') > 8) {
                    return INT_MIN;
                }
            }
            
            result =result*10 + (int)(s[j] - '0');
            
        }
        
        return result*numsign;
    }
};
