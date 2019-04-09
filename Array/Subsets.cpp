/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Subsets.
Memory Usage: 9.5 MB, less than 27.84% of C++ online submissions for Subsets.

Complexity: O(2^N)

Algorithm:
Loop through digits in nums. For each digit, loop through current vectors in ans and push digit into an independent copy of the vector.
Note:
1. can't directly push into vector in ans. Must deep copy and then push
2. When looping the vectors in ans, don't push new vectors into ans because they change the stop condition.
Otherwise, runtime error!

Syntax:
1. Copy a vector
std::vector<Foo> f;
std::vector<Foo> cp = f; //deep copy. All Foo copied

std::vector<Foo*> f;
std::vector<Foo*> cp = f; //deep copy (of pointers), or shallow copy (of objects).
//All pointers to Foo are copied, but not Foo themselves

vector<int> newvec = vec; //is deep copy
*/
////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        //for each digit, you can choose to take or not take.
        vector<vector<int>> ans;
        ans.push_back(vector<int>());
        for(int digit:nums) {
            //choose
            vector<vector<int>> tmp;    //use a tmp to store new vectors and push at last
            for(vector<int> vec:ans) {
                vector<int> newvec = vec;
                newvec.push_back(digit);
                tmp.push_back(newvec);
            }
            for(vector<int> vecs:tmp) {
                ans.push_back(vecs);
            }
            //not choose		
        }
        return ans;
    }
};

