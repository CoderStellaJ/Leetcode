/*
For division overflow, case occurs only when dividend is INT_MIN and divisor is -1 because abs(INT_MAX)<abs(INT_MIN)
*/
///////////////////////////////////////////////////////////////////////
class Solution {
public:
    int divide(int dividend, int divisor) {
        if(dividend == INT_MIN && divisor == -1) {
            return INT_MAX;
        }
        int result = dividend/divisor;
        return result;
    }
};

