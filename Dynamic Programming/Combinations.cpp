/*
Runtime: 192 ms, faster than 18.96% of C++ online submissions for Combinations.
Memory Usage: 68 MB, less than 13.63% of C++ online submissions for Combinations.

Complexity: O(2^N)

Algorithm 1:
Recursion without auxiliary function
Base Cases: k > n || k == n || k == 0 || n == 0. Here, not just compare k and n, but need to avoid negative value of k and n
More base cases, less recursions, faster!
When k < n
Recursive relatioship: (n,k) = (n-1, k) + ((n-1, k-1)+[n])

Note:
When you push subanswer into ans, you need to loop through subanswers instead of directly pushing subanswer into ans.
(Both of them are vector<vector<int>>)

Corner case:
if you directly return empty vector<vector<int>> ans, it will be [] instead of [[]].
So, an empty vector<int> needs to be pushed into ans

Habit:
For recursion, think about:
base case + recursive relationship
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        //pick k numbers from 1 to n
        vector<vector<int>> ans;
        if(k > n || k==0 || n==0) {
            vector<int> em;
            ans.push_back(em);
            return ans;
        }
        if(k == n){
          vector<int> re;
          for(int i = 1; i <= n; i++) {
            re.push_back(i);
          }
          ans.push_back(re);
          return ans;
        }else if(k < n) {
          vector<vector<int>> ans1;
          vector<vector<int>> ans2;
          ans1 = combine(n-1,k);
          for(vector<int> vec:ans1) {
            ans.push_back(vec);
          }
          ans2 = combine(n-1,k-1);
          for(vector<int> vec:ans2) {
            vec.push_back(n);
            ans.push_back(vec);
          }
          
          return ans;
        }
        return ans;
    }
};
