/*
Runtime: 12 ms, faster than 98.47% of C++ online submissions for Find First and Last Position of Element in Sorted Array.
Memory Usage: 11.1 MB, less than 9.48% of C++ online submissions for Find First and Last Position of Element in Sorted Array.

Complexity: O(logN)

Algorithm: 
2 auxiliary functions: one for start and one for end

*/
//////////////////////////////////////////////////////////////////////////////////

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;
        int start;
        int end;
        start = searchStart(nums,target,0,nums.size()-1);
        end = searchEnd(nums, target, 0, nums.size()-1);
        ans.push_back(start);
        ans.push_back(end);
        return ans;
    }
  
    int searchStart(vector<int>& nums, int target, int start, int end) {
        if(end < start) return -1;
        int mid = (start + end)/2;
        if(target < nums.at(mid)) {
            return searchStart(nums, target, start, mid-1);
        }else if(target > nums.at(mid)) {
            return searchStart(nums, target, mid+1, end);
        }else {
            if(mid == start) {
                //either one element or 2 element
                return mid;
            }else{
                //at least 3 elements
                if(target <= nums.at(mid-1)) {
                    return searchStart(nums, target, start, mid-1);
                }else {
                    return mid;
                }
            }
        }
    }

    int searchEnd(vector<int>& nums, int target, int start, int end) {
        if(end < start) return -1;
        int mid = (start + end)/2;
        if(target < nums.at(mid)) {
            return searchEnd(nums, target, start, mid-1);
        }else if(target > nums.at(mid)) {
            return searchEnd(nums, target, mid+1, end);
        }else {
            if(mid == end) {
                return mid;
            }else {
                if(target < nums.at(mid+1)){
                    return mid;
                }else {
                    return searchEnd(nums,target,mid+1,end);
                }
            }
        }

    }

};
