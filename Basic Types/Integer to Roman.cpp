/*
Runtime: 8 ms, faster than 99.41% of C++ online submissions for Integer to Roman.
Memory Usage: 8.6 MB, less than 98.57% of C++ online submissions for Integer to Roman.

Algorithm 2:
group the numbers in this way:
1235678/4/9
And improve space complexity by using vector instead

Syntax:
1. std::string s(5, 'a'); // s == "aaaaa"
*/
/////////////////////////////////////////////////////////////////////////////////
/*
mydict[1] = 'I';
mydict[5] = 'V';
mydict[10] = 'X';
mydict[50] = 'L';
mydict[100] = 'C';
mydict[500] = 'D';
mydict[1000] = 'M';
*/
class Solution {
public:
    string intToRoman(int num) {
        string res = "";
        //initialize the dictionary
        vector<char> mydict = {'I','V','X','L','C','D','M' };
        int count = 0;
        int digit;

        while(num > 0) {
            digit = num%10;
            if(digit != 0){
                switch(digit){
                    case 4:
                        res = mydict[2*count] + (mydict[2*count+1] +res);
                        break;
                    case 9:
                        res = mydict[2*count] + (mydict[2*count+2] + res);
                        break;
                    default:
                        if(digit >= 5) {
                            res = mydict[2*count+1] + string(digit-5, mydict[2*count]) + res;
                        }else {
                            res = string(digit, mydict[2*count]) + res;
                        }
                }
            }
            num/=10;
            count++;
        }
        return res;   
    }
};

//////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 20 ms, faster than 76.49% of C++ online submissions for Integer to Roman.
Memory Usage: 11 MB, less than 98.00% of C++ online submissions for Integer to Roman.

Complexity: 
Runtime: O(N)
Space: O(1)

Algorithm 1:
group the numbers according to their naming conventions
123/4/5/678/9

Syntax:
1. num*char
will give you an int because it converts char to int
2. char + (char + string)
need the () to operate latter + first
otherwise it converts the first 2 char to int and do int + first
3. switch
case 1: case 2: case 3:
one line for multiple cases
4. string += char
append char to the end of the string
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
