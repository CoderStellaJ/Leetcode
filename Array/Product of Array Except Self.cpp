/*
Runtime: 44 ms, faster than 76.91% of C++ online submissions for Product of Array Except Self.
Memory Usage: 12.7 MB, less than 41.50% of C++ online submissions for Product of Array Except Self.

Complexity:
runtime: O(2*N)
space: O(N)

Algorithm:
To skip some number in the middle, it;s impossible to use 1 iteration to sequentially go from left to right.
So let's think about the solution from left to right and from right to left.
1. From left to right:
prod1 records the production of the previous i-1 numbers
2. From right to left:
prod2 records the production of the latter numbers.
3. prod1 * prod2 is the production of all numbers skipping the ith number.

Syntax:
for return type vector<int>, can't directly return NULL
need to return {} instead which is an empty vector
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int len = nums.size();
        if(len == 0) return {};
        vector<int> res(nums.size());
        int prod = 1;
        for(int i = 0; i < len; i++) {
            res[i] = prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i = len-1; i >= 0; i--) {
            res[i] *= prod;
            prod *= nums[i];
        }
        return res;
    }
};
