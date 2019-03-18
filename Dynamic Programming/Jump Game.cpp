/////////////////////////////////////////////////////////////////////////
/*
Runtime: 640 ms, faster than 22.03% of C++ online submissions for Jump Game.
Memory Usage: 10.2 MB, less than 68.96% of C++ online submissions for Jump Game.

Complexity: O(N^2), where N is the length of the vector

Algorithm2:
Iterative method using DP.
use an array and start the iteration from the end of the vector

Syntax:
1. array vs vector
array is fixed size, in this case, it's better.
the size of the array is a variable, so we need to use dynamic variable.
For array, you must initialize it before accessing and using any element inside.

2. pass array by reference:
bool (&x)[100]
*/
/////////////////////////////////////////////////////////////////////////
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty() || nums.size() == 1) return true;
        bool* suc = new bool[nums.size()];
        for(int j = 0; j < nums.size(); j++) {
            suc[j] = false;
        }
        suc[nums.size()-1] = true;
        for(int i = nums.size()-2; i >= 0; i--) {
            //cout<<"iteration "<<i<<endl;
            if(nums[i] == 0) {
                suc[i] = false;
            }
            for(int j = 1; j <= nums[i]; j++) {
                //cout<<"step"<<j<<endl;
                if((i+j) > nums.size()-1) {
                    //cout<<"false"<<endl;
                    suc[i] = false;
                    break;
                }else if(suc[i+j] == true) {
                    suc[i] = true;
                    break;
                }	
            }
        }
        /*
        for(int j = 0; j < nums.size(); j++) {
            cout<<suc[j]<<endl;
        }*/
        if(suc[0] == true) return true;
        return false;
    }
};

////////////////////////////////////////////////////////////////
/*
Complexity: O(k^N), where k is the largest number in nums vector and N is the size of the vector
Time Limit exceeded

Algorithm 1:
Recursion, consider all the cases. Very time consuming
*/
///////////////////////////////////////////////////////////////
class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty()) return true;
        return jump(nums, 0, nums.size()-1);
    }
    bool jump(vector<int> nums,int position, int end) {
        if(position == end){return true;}
        for(int i = 1; i <= nums[position]; i++) {
            if(position + i > end) {
                break;
            }else if(position + i == end){
                return true;
            }else if(position + i < end) {
                if(jump(nums,position+i,end) == true){
                    return true;
                }
            }
        }
        return false;
    }
};
