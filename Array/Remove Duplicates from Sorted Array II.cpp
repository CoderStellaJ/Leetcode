/*
Runtime: 16 ms, faster than 85.31% of C++ online submissions for Remove Duplicates from Sorted Array II.
Memory Usage: 8.8 MB, less than 100.00% of C++ online submissions for Remove Duplicates from Sorted Array II.

Complexity: O(N)

Algorithm: 
use vector iterator to iterate through the vector. And count and vector help to keep record.

Syntax:
1. myvec.erase()
returns a new iterator that points to the same position. 
So, during iterations, if there is erase(), it shouldn't move forward. Otherwise, it++;
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.empty()) return 0;
        int count = 0;
        int value = nums[0];
        vector<int>::iterator it = nums.begin();
        while(it != nums.end()) {
            if(*it == value){
                count++;
                if(count > 2) {
                    it = nums.erase(it);
                    count--;
                }else{
                    it++;   //don't forget it++ here
                }
            }else {
                count = 1;
                value = *it;
                it++;
            }
        }
      return nums.size();
    }
};
