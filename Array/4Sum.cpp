/*
Algorithm: O(n^3)

Runtime: 12 ms, faster than 88.15% of C++ online submissions for 4Sum.
Memory Usage: 790.5 KB, less than 41.10% of C++ online submissions for 4Sum.

Note:
you should push back nums.at(i) instead of i into solution

Syntax:
find(result.begin(),result.end(),solution)
*/
///////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        int left, right, mid;
        int sum;
        int subTarget;
        if(nums.size() < 4) return result;
        sort(nums.begin(),nums.end());
        for(int i = 0; i < nums.size()-3; i++) {
            subTarget = target - nums.at(i);
            for(left = i+1; left < nums.size()-2; left++) {
                mid = left+1;
                right = nums.size()-1;

                while(mid < right) {
                    sum = nums.at(left)+nums.at(mid) + nums.at(right);
                    while(sum < subTarget && mid < right) {
                        mid++;
                        sum = nums.at(left)+nums.at(mid) + nums.at(right);
                    }
                    while(sum > subTarget && mid < right) {
                        right--;
                        sum = nums.at(left) + nums.at(mid) + nums.at(right);
                    }
                    if(sum == subTarget && mid < right) {
                        vector<int> solution;
                        solution.push_back(nums.at(i));
                        solution.push_back(nums.at(left));
                        solution.push_back(nums.at(mid));
                        solution.push_back(nums.at(right));
                        if(find(result.begin(),result.end(),solution) == result.end()) {
                            result.push_back(solution);
                        }
                        
                        mid++;
                        right--;
                    }
                }
            }
        }
    return result;    
    }
};
