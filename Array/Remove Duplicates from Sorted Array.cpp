/*
Algorithm:
IN-PLACE algorithm: 
insert the values to the front and then return the final length

Note:
After inserting the element, the index i of the number changes, so you have to modify i to i+1 to keep track of the original item.

Syntax:
1. insert the element to the front of the array: nums.insert(nums.begin(), value);
*/
////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int value = INT_MAX;
        int len = 0;
        for(int i = nums.size()-1; i >= 0; i--) {
            if(nums.at(i) < value) {
                value = nums.at(i);
                //cout<<"insert "<<nums.at(i)<<" "<<value<<endl;
                nums.insert(nums.begin(), nums.at(i));
                //value = nums.at(i);   //Now, i changes, and value is wrong
                len++;
                i++;
            }
        }

     	return len;
    }
};
