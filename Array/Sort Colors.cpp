/*

Complexity:

Algorithm2: 1-pass algorithm:

Syntax:
std::swap(a,b) is a c++ built-in function for swapping.

*/
//////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////
/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Sort Colors.
Memory Usage: 8.6 MB, less than 55.43% of C++ online submissions for Sort Colors.

Complexity: O(N)

Algorithm1: 2-pass countign sort
count number of 0 and 1 and 2
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.size(); i++) {
          if(nums[i] == 0) count0++;
          else if(nums[i] == 1) count1++;
          else if(nums[i] == 2) count2++;
        }
        for(int i = 0; i < count0; i++) {
          nums[i] = 0;
        }
        for(int i = count0; i < count0 + count1; i++) {
          nums[i] = 1;
        }
        for(int i = count0+count1; i < count0+count1+count2; i++) {
          nums[i] = 2;
        }
    }
};
