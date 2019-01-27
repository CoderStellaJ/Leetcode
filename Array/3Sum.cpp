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
                while(sum >= 0 && right > left) {
                    if(right > left && sum == 0) {      
                    //put this part before you make any change to left or right. Otherwise, the first case is ignored.
                        vector<int> solution;
                        solution.push_back(nums.at(i));
                        solution.push_back(nums.at(left));
                        solution.push_back(nums.at(right));
                        if(find(result.begin(), result.end(), solution) == result.end()) {
                                result.push_back(solution);
                        }
                    }
                    right--;
                    sum = nums.at(i)+nums.at(left);
                    sum += nums.at(right);
                    //debug
                    /*    cout<<"right ";
                        cout<<nums.at(i)<<" "<<nums.at(left)<<" "<<nums.at(right)<<endl;
                        cout<<sum<<endl;
                    */
                }

                while(sum <= 0 && left < right) {
                    if(right > left && sum == 0) {  
                        vector<int> solution;
                        solution.push_back(nums.at(i));
                        solution.push_back(nums.at(left));
                        solution.push_back(nums.at(right));
                        if(find(result.begin(), result.end(), solution) == result.end()) {
                                result.push_back(solution);
                        }
                    }
                    left++;
                    sum = nums.at(i)+nums.at(left);
                    sum += nums.at(right);   
                    //debug
                    /*    cout<<"left ";
                        cout<<nums.at(i)<<" "<<nums.at(left)<<" "<<nums.at(right)<<endl;
                        cout<<sum<<endl;
                    */
                }
            }
        }
        
	return result;  
    }

};
/////////////////////////////////////////////////////////////////////
/*
Complexity: O()

Algorithm:
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
