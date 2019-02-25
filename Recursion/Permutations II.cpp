/*
Runtime: 24 ms, faster than 100.00% of C++ online submissions for Permutations II.
Memory Usage: 10.6 MB, less than 45.32% of C++ online submissions for Permutations II.

Algorithm 2:
How to avoid checking duplicates every time?
1. generate permutations by swapping: the condition for swapping is important.
2. sort the array before passing it into auxiliary function, during swapping, only larger numbers will be swapped.
Otherwise, take [3,0,3,3] as example: after swapping, it becomes [0,3,3,3]. 
But in the next iteration, there will be another swapping which changes it back to [3,0,3,3]

Note:
sorting is an important way to avoid duplication.

Syntax: 
std::swap(a, b);	//built-in function for swapping
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        vector<vector<int>> ans;
        sort(nums.begin(), nums.end());
        per(nums, 0, nums.size()-1, ans);
        return ans;       
    }

    void per(vector<int> nums, int start, int end, vector<vector<int>>& ans) {
        if(start == end) {
            ans.push_back(nums);
            return;
        }
        for(int i = start; i <= end; i++) {
            if(i != start && nums.at(i) == nums.at(start)) continue;	
		//condition is important, i!= start to preseve the original sequence as a permutation
            else{
                swap(nums.at(i),nums.at(start));
                per(nums,start+1,end,ans);
            }
        }
    }
};

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
