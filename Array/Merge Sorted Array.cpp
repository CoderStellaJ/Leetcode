/*
Runtime: 8 ms, faster than 75.23% of C++ online submissions for Merge Sorted Array.
Memory Usage: 8.8 MB, less than 100.00% of C++ online submissions for Merge Sorted Array.

Complexity:O(N^2)

Algorithm:
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
