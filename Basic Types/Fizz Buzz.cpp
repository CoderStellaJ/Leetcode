/*
Runtime: 8 ms, faster than 99.22% of C++ online submissions for Fizz Buzz.
Memory Usage: 10.5 MB, less than 31.46% of C++ online submissions for Fizz Buzz.

Complexity: O(N)
% modulo operation complexity in C++: O(1) operation

Syntax:
1. convert int to string
to_string(myint);
2. Note the type of elements in vector.
Don't directly push i or index into vector
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<string> fizzBuzz(int n) {
        vector<string> res;
        for(int i = 1; i <= n; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                res.push_back("FizzBuzz");
            }else if(i%3 == 0) {
                res.push_back("Fizz");
            }else if(i%5 == 0) {
                res.push_back("Buzz");
            }else {
                res.push_back(to_string(i));    // don't push i, push string type!!!
            }
        }
      return res;
    }
};
