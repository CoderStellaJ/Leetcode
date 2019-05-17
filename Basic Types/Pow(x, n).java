/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Pow(x, n).
Memory Usage: 32.4 MB, less than 91.82% of Java online submissions for Pow(x, n).

Algorithm 2:
Recursion
and using half*half instead of multiplying x in each iteration can largely reduce the number of iterations and save time.
*/
//////////////////////////////////////////////////////////////////////////////////
class Solution {
    public double myPow(double x, int n) {
        return (n >= 0.0)? power(x,n):1/power(x,-n);
    }
    public double power(double x, int n){
        if(n == 0) return 1.0;    //base case
        double half = power(x, n/2);
        return (n % 2) == 0?  half*half: x*half*half;       
    }
}

/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 13 ms, faster than 5.15% of Java online submissions for Pow(x, n).
Memory Usage: 34.5 MB, less than 57.11% of Java online submissions for Pow(x, n).

Algorithm 1:
For loop iteration

Syntax:
1. Format a string
DecimalFormat df = new DecimalFormat();
df.setMaximumFractionDigits(2);
System.out.println(df.format(decimalNumber));
2. Format a double
(double)Math.round(value * 100000d) / 100000d
3. Absolute value
Math.abs(int a)

Corner case:
1. x == 0 and n < 0
2. x = 0.00001  n = 2147483647  Time Limit Exceeded
3. x = 1.00000  n = 2147483647  Time Limit Exceeded
4. x = -1.00000 n = 2147483647  Time Limit Exceeded

*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
    public double myPow(double x, int n) {
        double res = 1.0;     
        double old = 1.0;
        if( x == 1.0) return 1.0;
        if( x == -1.0) {
            if(n%2 == 0) return 1.0;
            else return -1.0;
        }
        for(int i = 0; i < n; i++) {
            old = res;
            res *= x;
            if(res - old == 0.0) break;
        }
        for(int i = n; i < 0; i++) {
            old = res;
            if(x != 0) res = res/x;
            if(old - res == 0) break;
        } 
        return res;
    }
}

