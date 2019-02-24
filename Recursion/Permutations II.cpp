

///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1416 ms, faster than 5.11% of C++ online submissions for Permutations II.
Memory Usage: 83.2 MB, less than 5.26% of C++ online submissions for Permutations II.

Algorithm 1:
check whether there are any duplicates before inserting
*/
/////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;
        vector<int> cur;
        per(nums, cur, ans);
        return ans;       
    }

    void per(vector<int> nums, vector<int> cur, vector<vector<int>>& ans) {
        int number;
        if(nums.empty()) {
            if(ans.empty() || find(ans.begin(),ans.end(),cur) == ans.end()) {
	            ans.push_back(cur);
                return;
            }
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
