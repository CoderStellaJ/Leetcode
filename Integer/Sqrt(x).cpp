/*
Runtime: 8 ms, faster than 94.12% of C++ online submissions for Sqrt(x).
Memory Usage: 8.2 MB, less than 99.31% of C++ online submissions for Sqrt(x).

Complexity: O(logN)

Algorithm: binary search. When you want to find a number or answer, consider search algorithm

Syntax:
In recursion, you need to return something at the end of the function. 
Otherwise, there will be control reaches end error. 
*/
///////////////////////////////////////////////////////////////
class Solution {
public:
    int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        return findsqrt(1, x-1, x);
    }
    int findsqrt(int left, int right, int target) {
        if(left > right) return -1;   //remember to take care of base case
        long mid = (left + right)/2;
        long multi = mid*mid;
        if(multi == target) {
            return mid;
        }else if(multi < target) {
            if((mid+1)*(mid+1) > target) {
                return mid;
            }else if((mid+1)*(mid+1) == target) {
                return mid+1;
            }else{
                return findsqrt(mid+1, right, target);
            }
        }else{
            return findsqrt(left,mid,target);
        }
        return -1;
    }
};

///////////////////////////////////////////////////////////////
/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Sqrt(x).
Memory Usage: 8.1 MB, less than 99.83% of C++ online submissions for Sqrt(x).

Algorithm: use standard lib

Syntax: 
double sqrt(double x)
*/
/////////////////////////////////////////////////////////////////
class Solution {
public:
    int mySqrt(int x) {
        int a = sqrt(x);
	      return a;
    }
};
