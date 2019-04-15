/*
Runtime: 16 ms, faster than 31.18% of C++ online submissions for Subsets II.
Memory Usage: 9.3 MB, less than 71.28% of C++ online submissions for Subsets II.

Complexity: O(2^N)

Algorithm 1:
We use a vector<vector<int>> adding to store vectors that added a new element in the last iteration.
A vector<vector<int>> ans for vectors that didn't add new element in last iteration
Case 1: current number is duplicate with previous number
if you choose not to add the element, copy and move the vector to ans because you stop adding any duplicate current number
else, add it into vectors in adding 
Case 2: current number is not duplicate
all those vectors in ans can be reconsidered again for whether to add new element. 
Thus, all vectors in ans are moved to adding

Syntax:
1. range-based for loop
for(vector<int> myvec:ans) creates a deep copy of vector in ans as it's passed by value.
Hence, modifying vector in loop doesn't change the original value.
Instead, we should use:
for(vector<int>& myvec:ans)

2.myvec.push_back()
creates a new copy of the element and then push the new element into the vector.

3. myvec.clear()
it doesn't call destructor of the objects in vector. It simply moves away the vector element pointers to NULL.
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;
        vector<vector<int>> adding;
        ans.push_back(vector<int>());
        int value;
      
        for(int i = 0; i < nums.size(); i++) {
            if(i == 0 || nums[i] != value) {
                //not duplicate
                value = nums[i];
                for(vector<int>& ansvec:ans) {
                    adding.push_back(ansvec);
                }
                ans.clear();        //the objects are not destructed, the vector element pointer are NULL now
            }
            for(vector<int>& vec:adding) {
                vector<int>& myvec = vec;
                ans.push_back(myvec);       //push_back() creates a deep copy of the object
                vec.push_back(nums[i]);
                //at this time, myvec and vec are the same    
            }      
        }
        for(vector<int>& vecs:adding) {
            ans.push_back(vecs);
        }
        return ans;
    }
};
