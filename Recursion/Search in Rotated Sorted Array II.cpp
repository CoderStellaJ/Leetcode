/*
Runtime: 12 ms, faster than 21.84% of C++ online submissions for Search in Rotated Sorted Array II.
Memory Usage: 9 MB, less than 8.25% of C++ online submissions for Search in Rotated Sorted Array II.

Complexity: O(N)

Algorithm 2: Improved from algorithm 1, merge common cases
1. compare nums[mid] and nums[start] to locate which part nums[mid] is in
2. compare nums[mid] and target
3. compare target and nums[start] to locate which part target is in
Note:
The right part is not garanteed to exist e.g.[0,1,1,3,5]
Thus, it's safer to compare target with nums[start] to locate it instead of comparing with nums[end]

Syntax: 
You must always return something at the end of the function even though your if-else structure has covered all possible cases.

Corner case:
If you choose to compare target with nums[end], the corner case is:
[0,1,1,3,5]
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool search(vector<int>& nums, int target) {
        //brute force : O(N)
        //binary search : O(logN)
        if(nums.empty()) return false;
        return bi(nums, target, 0, nums.size()-1);
    }
    bool bi(vector<int>& nums, int target, int start, int end) {
        //base cases
        if(start > end) return false;
        
        int mid = (start+end)/2;
        if(nums[mid] == target) return true;
        if(nums[mid] == nums[start]) return bi(nums, target, start, mid-1) || bi(nums, target, mid+1, end);
        if(nums[mid] > nums[start]) {
            //mid is in left part
            if(target > nums[mid])  return bi(nums,target,mid+1,end);
            else if(target >= nums[start]) return  bi(nums,target,start,mid-1);
            else return  bi(nums,target,mid+1,end);
              
        }else if(nums[mid] < nums[start]) {
            //mid is in right part  
            if(target < nums[mid]) return bi(nums,target,start+1,mid-1);
            else if(target <= nums[end]) return bi(nums,target,mid+1,end);
            else if(target > nums[end]) return bi(nums, target, start, mid-1);
        }
        
        return false;
    }
};
///////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 99.55% of C++ online submissions for Search in Rotated Sorted Array II.
Memory Usage: 8.9 MB, less than 8.74% of C++ online submissions for Search in Rotated Sorted Array II.

Complexity: O(N)

Algorithm 1: Recursion
1. compare nums[mid] and target
2. compare nums[mid] and nums[start] to locate which part nums[mid] is in
3. compare target and nums[start] to locate which part target is in

Corner case:
when nums[mid] == nums[start]
case 1:
[2,0,1,2,2,2,2]
case 2: 
[2,2,2,2,0,1,2]
[2,2,2,2,0,1,1]
So, in this case, need to call 2 recursive steps to do a O(N) search
*/
///////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool search(vector<int>& nums, int target) {
        //brute force : O(N)
        //binary search : O(logN)
        if(nums.empty()) return false;
        return bi(nums, target, 0, nums.size()-1);
    }
    bool bi(vector<int>& nums, int target, int start, int end) {
        //base cases
        if(start > end) return false;
        
        int mid = (start+end)/2;
        if(nums[mid] == target) return true;
        else if(nums[mid] > target){
            //check whether mid is in left or right part
            if(nums[mid] > nums[start]) {
                //mid is in left part
                if(nums[start] > target) {
                    //target is in right part
                    return bi(nums, target, mid+1, end);
                }else if(nums[start] == target) {
                    return true;
                }else {
                    //target is in left part
                    return bi(nums, target, start+1, mid-1);
                }
            }else if (nums[mid] == nums[start]){
                 //if in right part
                  return bi(nums, target, start+1, mid-1) || bi(nums, target, mid+1, end);
                
            }else{
                //mid is in right part
                return bi(nums, target, start+1, mid-1);
            }
        }else if(nums[mid] < target){
            if(nums[mid] > nums[start]) {
                //mid is in left part
                return bi(nums, target, mid+1,end);
            }else if(nums[mid] < nums[start]) {
                //mid is in right part
                if(target == nums[end]) return end;
                else if(target < nums[end]) return bi(nums,target, mid+1, end-1);
                else{
                    return bi(nums,target,start, mid-1);
                }
            }else {
                return bi(nums, target, start, mid-1) || bi(nums, target, mid+1, end);
            }
        }
        return false;
    }
};
