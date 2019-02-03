/*
Complexity: O(n^2)

Runtime: 4 ms, faster than 100.00% of C++ online submissions for 3Sum Closest.
Memory Usage: 766 KB, less than 87.03% of C++ online submissions for 3Sum Closest.

Note
Remember to return at the end of the function!

Syntax:
1. maximum int in C++: INT_MAX
2. you can add more than 2 terms in a statement
3. absolute value: abs()

Test case:
vector size < 3

*/
/////////////////////////////////////////////////////////////////////////////////

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
          int left, right;
          int minDiff, diff;
          int sum, result;
          //address the corner case
          if(nums.size() < 3) return 0;
          sort(nums.begin(), nums.end());
          minDiff = INT_MAX;    //syntax
          for(int i = 0; i < nums.size(); i++) {
              left = i+1;
              right = nums.size()-1;
              while(right > left) {
                  sum = nums.at(i) + nums.at(left) + nums.at(right);    //can add more than 2 terms!
                  diff = sum - target;
                  if(abs(diff) < minDiff){
                      minDiff = abs(diff);
                      result = sum;
                  }
                  if(diff < 0) {
                      left++;
                  }else if(diff > 0){
                      right--;
                  }else {
                      return target;
                  }

              }
          }
    return result;
    }
};
