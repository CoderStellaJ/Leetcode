/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Divide Two Integers.
Memory Usage: 32.7 MB, less than 63.24% of Java online submissions for Divide Two Integers.

Algorithm 2:
Keep increasing divisor to its multiples which saves the number of iterations
And use Recursion to take care of the rest of the value after deducting var
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int divide(int dividend, int divisor) {
      int quo = div((dividend > 0) ? -dividend: dividend, (divisor > 0)? -divisor: divisor);
      return ((dividend >=0 && divisor >0) || (dividend < 0 && divisor < 0)) ? (quo == Integer.MIN_VALUE ? Integer.MAX_VALUE: -quo) : quo;
    }
    public int div(int dividend, int divisor) {
      if(dividend < 0 ) {
        int var = divisor;
        int quo = (dividend - var  > 0)? 0 : -1;
        while(dividend - var <= var) {
          var += var;
          quo += quo;
        }
        return quo+div(dividend-var,divisor);
      }
      return 0;
    }
}
//////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm 1:
use while loop to deduct divisor in each iteration
which consumes lots of time

Syntax:
1. 10/3
dividend: 10; divisor: 3

2. int max and int value
Integer.MIN_VALUE
Integer.MAX_VALUE

3. XOR gate ^, so it's better to use XOR when both A and B are boolean
(decimal)    (binary)
     5     =  101
     6     =  110
------------------ xor
     3     =  011
     
4. left shift <<
A <<= 1, A left shift by 1
*/
/////////////////////////////////////////////////////////////////////
class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        int sign = -1;
        if((dividend >= 0 && divisor > 0) ||  (dividend < 0 && divisor < 0)) sign = 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1){     //take care of the out of integer bound case
          return Integer.MAX_VALUE;
        }
        if(dividend > 0) dividend = -dividend;      //convert all to negative values because the range is larger for -
        if(divisor > 0) divisor = -divisor;
        while(dividend <= 0) {
          dividend -= divisor;
          count++;
        }
        return sign*(count -1);
    }
}
