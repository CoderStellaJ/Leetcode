/*
Hard

Complexity:O(log (m+n))
Runtime: 48 ms, faster than 44.61% of C++ online submissions for Median of Two Sorted Arrays.
Memory Usage: 21.5 MB, less than 100.00% of C++ online submissions for Median of Two Sorted Arrays.

Algorithm:
From the complexity requirement, the clue is to keep partitioning the 2 arrays into half(similar to binary search).
The keypoint of finding the median is to find the index that partitions the arrays into equal-size parts.
And make sure max(left) <= min(right)
https://leetcode.com/problems/median-of-two-sorted-arrays/solution/

Note:
You may assume nums1 and nums2 cannot be both empty.

Syntax:
1. length of a vector: myvec.size()
2. average value and sum variables may be double instead of int

Corner case:
//1. both are empty arrays
2. one of them is empty
3. the mid index is not an int

*/
///////////////////////////////////////////////////////////////////

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        vector<int> temp;
        int tmp;
        
        if(m > n) {	
        //make sure length of B is larger then length of A to keep j positive
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m+n)/2;
        //iMin and iMax are used to restrict the value of i and the formula for j ensures left and right have the same size
        while(iMin <= iMax) {
            //cout<<"iMin "<<iMin<<" iMax "<<iMax<<endl;
            int i = (iMin + iMax)/2;
            int j = halfLen - i;
            //cout<<"i "<<i<<" j "<<j<<endl;
            if(i < iMax && nums2.at(j-1) > nums1.at(i)) {
                iMin = i+1;     //i is too small
            }else if(i > iMin && nums1.at(i-1) > nums2.at(j)) {
                iMax = i-1;     //i is too big
            }else {
            //have found the position of median
            // i==iMax all elements of nums1 are smaller 
            // i==iMin all elements of nums1 are larger
            //nums1[i-1] <= nums2[j] && nums2[j-1] <= nums1[i]
            //compare maxLeft and minRight to decide which one is median
                
                int minRight = 0;
                if(i == m){minRight = nums2.at(j);}
                else if(j == n){minRight = nums1.at(i);}
                else {minRight = std::min(nums1.at(i), nums2.at(j));}
                if((m+n)%2==1) {return minRight;}   //odd number, directly output the median
              
                int maxLeft = 0;
                //make sure i-1 and j-1 are valid
                if(i == 0) {maxLeft = nums2.at(j-1);}
                else if(j == 0) {maxLeft = nums1.at(i-1);}	//only happens when m = n;
                else{maxLeft = std::max(nums1.at(i-1), nums2.at(j-1));}
                return (maxLeft+minRight)*1.0/2;
            }

        }
        
        return 0.0;
    }


};
