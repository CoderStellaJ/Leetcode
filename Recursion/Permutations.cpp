/*
Runtime: 16 ms, faster than 98.29% of C++ online submissions for Permutations.
Memory Usage: 10.3 MB, less than 18.30% of C++ online submissions for Permutations.

Algorithm:
Recursion

Syntax:
1. remove an element at an index: myv.erase(myv.begin()+i);
2. insert an element at index in vector: myvec.insert(myvec.begin()+i, element); 
*/
//////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> cur;
        per(nums, cur, ans);
        return ans;       
    }

    void per(vector<int> nums, vector<int> cur, vector<vector<int>>& ans) {
        int number;
        if(nums.empty()) {
            ans.push_back(cur);
        }
        for(int i = 0; i < nums.size(); i++) {
            number = nums.at(i);
            cur.push_back(number);
            nums.erase(nums.begin()+i);
            per(nums,cur,ans);
            cur.pop_back();
            nums.insert(nums.begin()+i,number);
        }
    }
};


