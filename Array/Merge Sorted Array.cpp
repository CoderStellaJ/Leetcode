/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Merge Sorted Array.
Memory Usage: 8.5 MB, less than 100.00% of C++ online submissions for Merge Sorted Array.

Complexity: O(N)

Algorithm 2:
In algorithm 1, the time-consuming part is vector.insert().
Thus, in order to avoid moving element one by one or insert(), I first move all elements of nums1 to the end of nums1. O(m)
Then the process is the same as normal merge array problem.

Corner case:
1. nums1 elements are larger than nums2
2. nums2 elements are larger than nums1
*/
/////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int len = nums1.size()-1;
        int numssize = len;
        int i = len-m+1;
        int j = 0;
        int p = 0;
        for(int k = m-1; k >= 0; k--) {
            //move back elements in num1, O(m)
            nums1[len] = nums1[k];
            len--;
        }
      
        while(i<= numssize  && j < n) {
            if(nums2[j] <= nums1[i]) {
                nums1[p] = nums2[j];
                j++;
                p++;
            }else {
                nums1[p] = nums1[i];
                i++;
                p++;
            }
        }
        while(j < n) {
            nums1[p] = nums2[j];
            j++;
            p++;
        }
        while(i <= len) {
            nums1[p] = nums1[i];
            i++;
            p++;
        }
    }
};
/////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 75.23% of C++ online submissions for Merge Sorted Array.
Memory Usage: 8.8 MB, less than 100.00% of C++ online submissions for Merge Sorted Array.

Complexity:O(N^2)

Algorithm 1:
1. compare and insert nums2 elements into nums1
2. remove extra spaces in nums1

Syntax:
myvec.insert(myvec.begin(), 3);
insert to the position
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i = 0;
        int j = 0;
        int len = nums1.size();
        while(i< m && j < n) {
            if(nums2[j] <= nums1[i]) {
                nums1.insert(nums1.begin()+i, nums2[j]);
                i++;
                j++;
                m++;
            }else {
                i++;
            }
        }
        while(j < n) {
            nums1.insert(nums1.begin()+i, nums2[j]);
            i++;
            j++;
        }
        nums1.erase(nums1.begin()+len, nums1.end());
    }
};
