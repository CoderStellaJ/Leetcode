/*
Runtime: 4 ms, faster than 97.90% of C++ online submissions for First Missing Positive.
Memory Usage: 8.8 MB, less than 99.71% of C++ online submissions for First Missing Positive.

Complexity:
Runtime: O(N)
Space: O(1)

Algorithm:
makes sure nums[i] stores (i+1) so that the first missing number is the min positive.
Note:
after swapping, you need to check again the current number as it's swapped from latter part
i-- after swapping.
And to prevent infinite loop, son't swap if nums[i] is alr (i+1)

Syntax:
Always remember to return sth at the end of the function !!
The first thing to do is write down the thing it returns

*/
//////////////////////////////////////////////////////////////
class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int tmp;
        int n = nums.size();
        int j = 0;
        for(int i = 0; i < n; i++) {
          if(nums[i] > 0 && nums[i] < n && nums[i] != nums[nums[i]-1]){   //to prevent infinite loop
            swap(nums[i],nums[nums[i]-1]);
            i--;    //important to check current number after swapping
          }
        }
        for(j = 0; j < n; j++) {
          if(nums[j] != j+1){
            return (j+1);
          }
        }
        return (j+1);
    }
};
