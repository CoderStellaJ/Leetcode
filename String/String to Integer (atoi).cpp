class Solution {
public:
    int myAtoi(string s) {
        int len = s.length();
        int start = 0;
        int end = -1;       //initialized to an invalid value
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
                    end = i;        //update end once the num starts!
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
        
        if(numstart == false) {     //corner test case!
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
                start ++;       //skip first 0s
            }else{
                break;      //break!
            }
        }
        
        //cout<<start<<" "<<end<<endl;
        
        for(int j = start; j <= end; j++) {
            if(numsign > 0) {
                if(result > INT_MAX/10) {       
                    return INT_MAX; 
                }else {
                    if((s[j]-'0') > 7 && result == INT_MAX/10){        //important algorithm on judging whether out of integer range!
                        return INT_MAX;
                    }
                }
            }else {
                if(result*numsign < INT_MIN/10) {
                    return INT_MIN;
                }else if(result*numsign == INT_MIN/10 && (s[j]-'0') > 8) {
                    return INT_MIN;
                }
            }
            
            result =result*10 + (s[j] - '0');      //s[j] - '0' to convert number char to int
            
        }
        
        return result*numsign;
    }
};

///////////////////////////////////////////////////////////////////////////////////////////////
/*
Complexity:  8 ms, faster than 99.14% of C++ online submissions for String to Integer 

Algorithm:
1. determine whether there is sign
2. determine whether there is number, whether it's valid
    spaicla cases:
    invalid case:
        numstart = false
    valid case:
        start = end and s[start] is sign -> return 0
3. determine actual start and end of the number by skipping sign and first 0s
4. calculate the int from string
    result = result*10 + s[j] - '0';
5. condition for out of integer bound: 	-2,147,483,648 to +2,147,483,647  负8正7


Syntax:
1. max and min of integer: INT_MIN, INT_MAX
2. convert char to int: s[j] - '0'


*/
