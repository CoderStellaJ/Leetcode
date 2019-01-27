class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int numlen = nums.size();
        map<int, int> mymap;    //syntax for creating a map
        int complement;
        map<int, int>::iterator iter;   //create an iterator over the map
        vector<int> result;
        
        for(int i = 0; i < numlen; i++) {
            complement = target - nums.at(i);
            //debug
            //cout<<complement<<endl;
            iter = mymap.find(complement);
            if(iter != mymap.end()) {   //determine whether the complement is in the map
		        result.push_back(mymap.at(complement));   
                //cout<<"push back "<<mymap.at(complement)<<endl;
                result.push_back(i);
                //debug
                //cout<<"push back "<<i<<endl;
                
                return result;
            }
	    mymap[nums.at(i)] = i;			
        }
        return result;
    }
};


/////////////////////////////////////////////////////
/*
Complexity: O(n)
Algorithm: 
use a hashmap to store the value as well as the index so you can keep track of both.
Every time, you search whether complement = target - num is in the hashmap. If exists, you can the pair.
  Remark:
  You must use one-pass hashing instead of two-pass for special case e.g. [2, 5, 5, 3] and the target is 10.
  Otherwise, you can't find the second element with the same value.
Syntax:
1. create a map: map<typeA, typeB> mymap
2. add elements into map: mymap[key] = value
3. iterator in map: map<typeA, typeB>::iterator iter
4. check whether the key is in map:
    iter = mymap.find(mykey);
    if(iter != mymap.end()) {//mykey is in mymap }
5. access the value in map: 
    mymap.at(mykey)
    iter->second  //iter is a pair of both key and value, second is the value.
    
6.add element into a vector<int>: myvec.push_back(myvalue)
*/
