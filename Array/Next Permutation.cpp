/*
Runtime: 16 ms, faster than 69.53% of C++ online submissions for Next Permutation.
Memory Usage: 10.1 MB, less than 59.24% of C++ online submissions for Next Permutation.

Complexity:O(N^2logN)

Algorithm:
1. Try to find the min element in [j...end] that is larger than the current element [j-1].
2. Swap [j-1] with min element [m]
3. Sort [j...end]
4. Otherwise, sort the whole vector without swapping when it's already the maximum permutation.

Syntax:
1. min element in vector: *(std::min_element(vec.begin(), vec.end())), min_element gives you a iterator.    //O(N)
2. vector is empty: myvec.empty()
3. sort the vector: std::sort (myvector.begin(), myvector.begin()+4); //O(NlogN)
4. maximum integer: INT_MAX

*/
///////////////////////////////////////////////////////////////////
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        if(nums.empty()) {return; }

        for(int j = nums.size()-1; j>=1; j--) {		//O(N)
            int k = j-1;
            if(*(std::max_element(nums.begin()+j, nums.end())) > nums.at(k)) {	//O(N)
                int small = INT_MAX;
                int ind;		
                //find the smallest number that is larger than nums.at(k)
                for(int m = j; m < nums.size(); m++) {
                    if(nums.at(m) > nums.at(k) && nums.at(m) < small) {
                        small = nums.at(m);
                        ind = m;
                    }
                }
                int tmp;
                tmp = nums.at(k);
                nums.at(k) = nums.at(ind);
                nums.at(ind) = tmp;
                //sort the rest of the numbers in the vector
                sort(nums.begin()+j,nums.end());        //O(NlogN)
                return;
            }
        }
        sort(nums.begin(), nums.end());  
    }

};
