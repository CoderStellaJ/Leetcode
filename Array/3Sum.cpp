//////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 88 ms, faster than 100.00% of C++ online submissions for 3Sum.
Memory Usage: 14.8 MB, less than 98.90% of C++ online submissions for 3Sum.

Complexity:
O(N^2)

Algorithm 2:
improvement from Algorithm 1:
the way to avoid 3 types of duplications

Note:
1.push nums[k] instead of k into vector
2. remember to return at the end of the function

Syntax:
1. push a vector into another vector without creating an extra vector
res.push_back({nums[i],nums[front],nums[back]})
*/
///////////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> res;
        int len = nums.size();
        int front, back, target, sum;
        sort(nums.begin(), nums.end());
        for(int i = 0; i < len; i++) {
            front = i+1;
            back = len-1;
            target = -nums[i];
            if(target < 0) break;       //the latter numbers are all positive
            while(front < back) {
                sum = nums[front] + nums[back];
                if(sum > target){       //use if instead of while, using while means there is a sequence, but actually it's not
                    back--;
                    continue;
                }
                if(sum < target) {
                    front++;
                    continue;
                }
                //sum == target
                res.push_back({nums[i],nums[front],nums[back]});
                //check duplicate[1]
                while(front+1 < len && nums[front+1] == nums[front]) front++;	//better way to avoid duplication 
                //check duplicate[2]
                while(back-1>=0 && nums[back-1] == nums[back]) back--;		//saves lots of time
                front++;
            }
            //check diplicate [0]
            while(i+1 < len && nums[i+1]==nums[i]) i++;		//3 kinds of duplications to avoid
        }
        return res;
    }
};

/////////////////////////////////////////////////////////////////////
/*
Complexity: O(n^2)

Speed: 1024 ms, faster than 12.55% of C++ online submissions for 3Sum.

Algorithm 1:
For every i, there isn't only one solution, there may be other solutions after you find one solution.
Thus, you need to keep moving right and left when left < right
Misunderstanding about the question:
    when there are duplicate numbers, you just treat the solutions they involved in as one solution.
    You shouldn't add duplicate solutions into result.

Syntax:
1. sort a vector: sort(v.begin(), v.end());
2. check whether a vector contains the element: 
    if(std::find(v.begin(), v.end(), x) != v.end()) {
      //v contains x 
    } else {
      //v does not contain x 
    }


Test case:
1. [0,0,0,0]
2. when there are duplicate numbers in the vector

*/

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int i;
        int len = nums.size();
        int left, right;
        int sum;
        vector<vector<int>> result;

        sort(nums.begin(), nums.end());
        //debug
        /*for(int i = 0; i < len; i++) {
            cout<<nums.at(i)<<" ";
        }
        cout<<endl;
        */
        
        for(int i = 0; i < len; i++) {
            left = i+1;
            right = len-1;
            if(left >= len || right < 0) {
                continue;
            }
            sum = 0;
            sum = nums.at(i) + nums.at(left);
            sum += nums.at(right);
            while(left < right){    
            //very important ! moving left and moving right can't be sequential, both sides should keep moving as long as left < right
                while(sum > 0 && right > left) {
                    right--;
                    sum -=nums.at(right+1);
                    sum += nums.at(right);
                    //debug
                    /*    cout<<"right ";
                        cout<<nums.at(i)<<" "<<nums.at(left)<<" "<<nums.at(right)<<endl;
                        cout<<sum<<endl;
                    */
                }

                while(sum < 0 && left < right) {
                    left++;
                    sum -=nums.at(left-1);
                    sum += nums.at(left);   
                    //debug
                    /*    cout<<"left ";
                        cout<<nums.at(i)<<" "<<nums.at(left)<<" "<<nums.at(right)<<endl;
                        cout<<sum<<endl;
                    */
                }
                if(right > left && sum == 0) {      
                    //put this part before you make any change to left or right. Otherwise, the first case is ignored.
                        vector<int> solution;
                        solution.push_back(nums.at(i));
                        solution.push_back(nums.at(left));
                        solution.push_back(nums.at(right));
                        if(find(result.begin(), result.end(), solution) == result.end()) {
                            result.push_back(solution);
                        }
                        right--;
                        left++;
                        sum = nums.at(i)+nums.at(left);
                        sum += nums.at(right);
                }
            }
        }
        
	return result;  
    }

};

