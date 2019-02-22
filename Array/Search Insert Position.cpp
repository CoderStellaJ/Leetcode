/*
Runtime: 8 ms, faster than 99.32% of C++ online submissions for Search Insert Position.
Memory Usage: 9.4 MB, less than 5.05% of C++ online submissions for Search Insert Position.

Complexity:O(logN)

Algorithm: 
similar to binary search. The only thing to take note is the base case.

*/
//////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
	    return search(nums, target, 0, nums.size()-1);
    }
    int search(vector<int>& nums, int target, int start, int end) {
        if(end < start) {return end+1;}
        int mid = (start+end)/2;
        if(target == nums.at(mid)){return mid;}
        else if(target > nums.at(mid)) {
            return search(nums, target, mid+1, end);
        }
        else{
            return search(nums, target, start, mid-1);
        }
    }
};
