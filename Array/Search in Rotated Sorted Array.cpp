/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Search in Rotated Sorted Array.
Memory Usage: 9.9 MB, less than 46.81% of C++ online submissions for Search in Rotated Sorted Array.

Complexity: O(logN)

Algorithm:
Recursion: find target is in which part of the array.
Comparisons:
beginNum, endNum: know whether the array is still rotated
target, beginNum, endNum: know target is in which part
mid, beginNum, endNum: know mid is in which part
mid, taget: know which part should be reduced to achieve O(logN)

*/
///////////////////////////////////////////////////////////////////
class Solution {
public:
    int searchTarget(vector<int>& nums, int target, int begin, int end) {
        if(end < begin){return -1;}

        int mid = (begin + end)/2;
        int beginNum = nums.at(begin);
        int endNum = nums.at(end);
        
        if(endNum >= beginNum) {
        //in the same ascending array
            if(target > endNum || target < beginNum) {
                return -1;
            }else {
                if(target == nums.at(mid)) {
                    return mid;
                }else if(target > nums.at(mid)) {
                    return searchTarget(nums,target,mid+1,end);
                }else{
                    return searchTarget(nums,target,begin,mid-1);
                }
            }
        }else {
        //in different parts, pivot is between them
            if(target > beginNum) {
            //in the first half (maybe)
                if(nums.at(mid) >= beginNum) {
                //mid is in first half
                    if(target == nums.at(mid)){
                        return mid;
                    }else if(target > nums.at(mid)) {
                        return searchTarget(nums,target,mid+1,end);
                    }else{
                        return searchTarget(nums,target,begin+1,mid-1);
                    }
                }else {
                //mid is in the second half
                    return searchTarget(nums,target,begin+1,mid-1);
                }
            }else if(target == beginNum) {
                return begin;
            }else if(target  < endNum) {
            //in the second half (maybe)
                if(nums.at(mid) <= endNum) {
                //mid is in the second half
                    if(target == nums.at(mid)) {
                        return mid;
                    }else if(target < nums.at(mid)){
                        return searchTarget(nums,target,begin,mid-1);
                    }else {
                        return searchTarget(nums,target,mid+1,end-1);
                    }
                }else {
                //mid is in the first half
                    return searchTarget(nums,target,mid+1,end-1);	
                }		
            }else if(target == endNum) {
                return end;
            }else{
                return -1;
            }
        }
	
    }
    
    int search(vector<int>& nums, int target) {
	    return searchTarget(nums, target, 0, nums.size()-1);
    }
    
};
