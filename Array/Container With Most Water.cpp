class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size()-1;
        int maxarea = 0;
        int area = 0;
        //debug
        //cout<<i <<" "<<j<<endl;
        while(i < j) {
            area = (j-i)*min(height.at(i), height.at(j));
            
            if(area > maxarea) {
                maxarea = area;
            }
            if(height.at(i) < height.at(j)) {
                i++;
            }else if(height.at(i) > height.at(j)) {
                j--;
            }else {
                if(height.at(i+1) > height.at(j-1)) {
                    i++;
                }else {
                    j--;
                }
            }		
        }
        return maxarea;
    }
};

////////////////////////////////////////////////////////////////////
/*
Complexity: O(n)

Algorithm:
Initially we consider the area constituting the exterior most lines. Now, to maximize the area, we need to consider the area between the lines of larger lengths. 
If we try to move the pointer at the longer line inwards, we won't gain any increase in area, since it is limited by the shorter line. 
But moving the shorter line's pointer could turn out to be beneficial, as per the same argument, despite the reduction in the width. 
This is done since a relatively longer line obtained by moving the shorter line's pointer might overcome the reduction in area caused by the width reduction.

Insight:
It's not necessary to use only one index starting from the beginning of the array.
Sometimes, 2 pointers can be used, one from the start, one from the end.

Syntax:
1. access vector element via index: v.at(i)
2. vector length: v.size()
3. min(a, b)

*/
