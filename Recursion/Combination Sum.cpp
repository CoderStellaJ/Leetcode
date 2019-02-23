/*
Runtime: 24 ms, faster than 55.04% of C++ online submissions for Combination Sum.
Memory Usage: 11.7 MB, less than 49.14% of C++ online submissions for Combination Sum.

Complexity:

Algorithm:
use start and end(end can be omitted) to restrict the numbers you use to avoid duplication.

Note:
1. use less return; can save a lot of time
2. judge whether target >= 0 before entering another round of recursion -> less stack

Syntax: 
1.myvec.pop_back()

*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> cur;
        comb(candidates, target, 0, cur,ans);
        return ans;
    }
    void comb(vector<int>& candidates, int target, int start, vector<int> cur, vector<vector<int>>& ans){
        if(target == 0){
            ans.push_back(cur);
        }else if(target > 0){
            for(int i = start; i < candidates.size(); i++) {
                if(target-candidates.at(i) >= 0){
                    cur.push_back(candidates.at(i));
                    comb(candidates, target-candidates.at(i), i, cur,ans);
                    cur.pop_back();
                }
            }
        }
        return;
    }
};
