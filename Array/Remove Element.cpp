/*
syntax:
1. erase and clear for vector:
    vec.erase(vec.begin() + 1, vec.begin() + 3);    //remove elements by index, and the vector is changed
    remove(vec.begin(), vec.end(), 20);   //the vector itself is not changed but you can remove by value
    vec.erase(remove(vec.begin(), vec.end(), int_to_remove), vec.end());
    
 remove() doesn't actually delete elements from the container 
 -- it only shunts non-deleted elements forwards on top of deleted elements. 
 And then return the position that separates deleted and non-deleted items.
 The key is to realize that remove() is designed to work on not just a container but on any arbitrary forward iterator pair: 
 that means it can't actually delete the elements, 
 because an arbitrary iterator pair doesn't necessarily have the ability to delete elements.
*/
///////////////////////////////////////////////////////////////////

class Solution {
public:
    int removeElement(vector<int>& nums, int val) {
        nums.erase(remove(nums.begin(),nums.end(),val),nums.end());
        return nums.size();  
    }
};
