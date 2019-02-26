/*
Runtime: 12 ms, faster than 98.45% of C++ online submissions for Maximum Subarray.
Memory Usage: 10.2 MB, less than 94.36% of C++ online submissions for Maximum Subarray.

Algorithm 2:
To save memory, we calculate allsum in each iteration without calculating the whole array previously.
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int maxSubArray(vector<int>& nums) { 
        int minSum = 0;
        int sum = 0;
        int allsum = 0;
	int ans = nums[0];
        for(int i = 0; i < nums.size(); i++) {
            allsum += nums[i];
            sum = allsum - minSum;
            if(allsum < minSum) {
                minSum = allsum;
            }
            if(sum > ans){ans = sum;}
        }
        return ans;
    }
};

////////////////////////////////////////////////////////////////////////////
/*
Runtime: 12 ms, faster than 98.45% of C++ online submissions for Maximum Subarray.
Memory Usage: 10.8 MB, less than 5.15% of C++ online submissions for Maximum Subarray.

Complexity:O(N)

Algorithm 1:
use sumarr to record the sums of the elements seen so far.
find the maximum and minimum of the sumarr and subtract them.

Note:
initialization of ans and minSum because there may be negative numbers in the array.
*/
////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sumNum = 0;
        int minSum;
        int sum;
        int ans;
        vector<int> sumarr;
        //generate an array whose elements are sums of the elements
        for(int i = 0; i < nums.size(); i++) {
            sumNum += nums[i];
            sumarr.push_back(sumNum);
        }
        minSum = 0;   //denote no element has bee added
        ans = sumarr[0];    //maximum sum should not be initialized to 0 for the case the array only has negative numbers
        for(int i = 0; i < sumarr.size(); i++) {
            //cout<<"iteration "<<i<<endl;
            sum = sumarr[i] - minSum;   //every iteration caculates sum and compare with ans
            //cout<<"sum "<<sum<<endl;
            if(sum > ans){ans = sum;}
            if(sumarr[i] < minSum) {    //every iteration see whether we need to update minSum
            //cout<<"mark 1"<<endl;
            	minSum = sumarr[i];
            }
        }
        return ans;
    }
};
