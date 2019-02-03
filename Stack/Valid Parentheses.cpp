/*
Algorithm: O(n)

Runtime: 0 ms, faster than 100.00% of C++ online submissions for Valid Parentheses.
Memory Usage: 794.6 KB, less than 58.82% of C++ online submissions for Valid Parentheses.

Note:
看清input的variable name!

Syntax:
1. str[i] gives you a char
2. character comparison: can directly use ==
3. stack:
    stack<char> mystack;
    mystack.push(xxx);
    mystack.pop();
    mystack.top();  //without poping out the element at the top
    mystack.empty();    //return true or false

*/
////////////////////////////////////////////////////////////////
class Solution {
public:
    bool isValid(string s) {
        stack<char> mystack;
        for(int i = 0; i < s.length(); i++) {
            if(mystack.empty()) {
                mystack.push(s[i]);
            }else {
                if(s[i] == ')' || s[i] == ']' || s[i] == '}') {
                    if(s[i] == ')' && mystack.top()=='(') {
                        mystack.pop();
                        continue;
                    }else if(s[i] == ']' && mystack.top() == '['){
                        mystack.pop();
                        continue;
                    }else if(s[i] == '}' && mystack.top() == '{'){
                        mystack.pop();
                        continue;
                    }else{
                        mystack.push(s[i]);
                    }
                }else {
                    mystack.push(s[i]);
                }
            }
        }
	    return mystack.empty();
    }
};
