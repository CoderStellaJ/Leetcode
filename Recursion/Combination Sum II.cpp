/*
Runtime: 32 ms, faster than 25.69% of C++ online submissions for Combination Sum II.
Memory Usage: 12.3 MB, less than 34.24% of C++ online submissions for Combination Sum II.

Algorithm:
almost the same as Combination Sum question.
The difference is that there may be duplicate numbers in the array.
So you need to check before pushing back

Syntax:
1. find(myv.begin(),myv.end(),target) == myv.end()
2. sort(myv.begin(),myv.end())

*/
////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> cur;
        sort(candidates.begin(),candidates.end());
        comb(candidates, target, 0, cur, ans);
        return ans;
    }
    
    void comb(vector<int>& candidates, int target, int start, vector<int> cur, vector<vector<int>>& ans){
        if(target == 0){
            if(ans.empty()){ans.push_back(cur);}
            else if (find(ans.begin(),ans.end(),cur) == ans.end()) {
                ans.push_back(cur);
            }
        }else if(target > 0) {
            for(int i = start; i < candidates.size(); i++) {
                if(target - candidates.at(i) < 0) break;
                else{
                    cur.push_back(candidates.at(i));
                    comb(candidates,target-candidates.at(i),i+1,cur,ans);
                    cur.pop_back();
                }
            }
        }
        
    }
};
