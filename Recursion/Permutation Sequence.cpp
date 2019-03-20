/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Permutation Sequence.
Memory Usage: 9.7 MB, less than 6.03% of C++ online submissions for Permutation Sequence.

Complexity: O(N)

Algorithm: Recursion
Every time we consider the ith digit in the number.
the ith digit is dependent on total number of permutations of the rest digits.
And we choose a vector to store all digits so that each used digit can be removed easily while keeping the ascending order

Note:
in recursive step, k - index*fac instead of k - fac

Syntax:
1. convert int to string: std::to_string()

*/
///////////////////////////////////////////////////////////////////////////////
int factorial(int n) {
	if(n == 1 || n == 0) return 1;
	else return n*factorial(n-1);
}

class Solution {
public:
    string getPermutation(int n, int k) {
        //create a vector to store the digits
        string ans = "";
        vector<int> nums;
        for(int i = 0; i < n; i++) {
            nums.push_back(i+1);
        }
        permute(n, k, ans, nums);
        return ans;
        }

    void permute(int n, int k, string& ans, vector<int>& nums) {
        int fac;
        int index;
        if(n <= 0) return;
        else if(n == 1) {
            ans = ans + to_string(nums[0]);
            return;
        }else {
            fac = factorial(n-1);
            index = (k-1)/fac;	
            ans = ans + to_string(nums[index]);
            nums.erase(nums.begin() + index);
            permute(n-1, k - index*fac, ans, nums);
        } 
    }

};
