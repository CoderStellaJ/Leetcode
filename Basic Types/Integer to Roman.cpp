/*
Runtime: 20 ms, faster than 76.49% of C++ online submissions for Integer to Roman.
Memory Usage: 11 MB, less than 98.00% of C++ online submissions for Integer to Roman.

Complexity: 
Runtime: O(N)
Space: O(1)

Syntax:
1. num*char
will give you an int because it converts char to int
2. char + (char + string)
need the () to operate latter + first
otherwise it converts the first 2 char to int and do int + first
3. switch
case 1: case 2: case 3:
1 line for multiple cases
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    string intToRoman(int num) {
        std::map<double,char> mydict;
        string res = "";
        //initialize the dictionary
        mydict[1] = 'I';
        mydict[5] = 'V';
        mydict[10] = 'X';
        mydict[50] = 'L';
        mydict[100] = 'C';
        mydict[500] = 'D';
        mydict[1000] = 'M';
        int count = 0;
        int tmp = num;
        int curnum;
        int digit;

        while(num > 0) {
            digit = num%10;
            if(digit != 0){
                curnum = digit*pow(10,count);
                switch(digit){
                    case 1: case 2: case 3:
                        for(int i = 0; i < digit; i++) {
                            res = mydict[pow(10,count)]+ res;
                        }
                        break;
                    case 4:
                        res = mydict[pow(10,count)] + (mydict[5*pow(10,count)] +res);
                        break;
                    case 5:
                        res = mydict[5*pow(10,count)] +res;
                        break;
                    case 6: case 7: case 8:
                        for(int i = 0; i < digit-5; i++) {
                            res = mydict[pow(10,count)] + res;    
                        }
                        res = mydict[5*pow(10,count)] + res;
                        break;
                    case 9:
                        res = mydict[pow(10,count)] + (mydict[pow(10,count+1)] + res);
                        break;
                }
                
            }
            num/=10;
            count++;
        }
        return res;   
    }
};
