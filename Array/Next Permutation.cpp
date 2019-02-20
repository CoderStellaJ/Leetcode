/*
Runtime: 12 ms, faster than 100.00% of C++ online submissions for Next Permutation.
Memory Usage: 10.2 MB, less than 33.76% of C++ online submissions for Next Permutation.

Complexity:O(N)

Improvement: 
Algorithm 2:
The trick is you don't have to sort [j...end]. It's garanteed that [j...end] is in decreasing order. 
All you need to do is:
1. Compare [j] and [j-1]
2. Go back to find the element that is minimally larger than [j-1] and swap
3. Reverse [j...end]

Note:
For swapping, there are 2 cases:
1. you find an element smaller than [k] and you swap [k] with [i-1]
2. until the end of the vector, you can't find any element smaller than than [k], you swap [k] with [end]
3. a return will slow down your program

Syntax:
1. reverse a vector: reverse(v.begin(), v.end()); 

*/

///////////////////////////////////////////////////////////////////
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int tmp;
        if(nums.empty()) {return; }

        for(int j = nums.size()-1; j>=1; j--) {		//O(N)
            int k = j-1;
            if(nums.at(j) > nums.at(k)) {
                for(int i = j; i < nums.size(); i++) {
                    if(nums.at(i) <= nums.at(k)) {
                        tmp = nums.at(k);
                        nums.at(k) = nums.at(i-1);
                        nums.at(i-1) = tmp;
                        reverse(nums.begin()+j,nums.end());        //O(N)
                        return;
                    }else if(i == nums.size()-1 && nums.at(i) > nums.at(k)) {
                        tmp = nums.at(k);
                        nums.at(k) = nums.at(i);
                        nums.at(i) = tmp;
                        reverse(nums.begin()+j,nums.end());
                        return;
                    }
                }
            }
        }
        reverse(nums.begin(), nums.end());  
    }

};

///////////////////////////////////////////////////////////////////////////
/*
Runtime: 16 ms, faster than 69.53% of C++ online submissions for Next Permutation.
Memory Usage: 10.1 MB, less than 59.24% of C++ online submissions for Next Permutation.

Complexity: O(NlogN), not O(N^2logN) !! It's a fake loop, once you enter if(), you will end the loop.

Algorithm 1:
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
