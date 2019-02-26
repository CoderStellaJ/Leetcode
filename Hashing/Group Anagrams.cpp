/*
What are the differences between Map, Hash and Dictionary?
1. According to Map vs dictionary:
The map and the dictionary are different names of the same data structures, C++ use the term map, and C# uses the term dictionary.
2. According to Map or dictionary vs hash:
A dictionary is a general concept that maps keys to values. There are many ways to implement such a mapping.
A hashtable is a specific way to implement a dictionary.
Besides hashtables, another common way to implement dictionaries is red-black trees.
A red-black tree can always perform a lookup in O(log N). 
A hashtable can perform a lookup in O(1) time although that can degrade to O(N) depending on the input. 
*/
/////////////////////////////////////////////////////////////////////////
/*
Map:
These are implemented using a red-black tree, a type of balanced binary search tree.
Insertion: O(log n)
Lookup: O(log n)
Deletion: O(log n)

Hashmap:
Insertion: O(1) expected, O(n) worst case
Lookup: O(1) expected, O(n) worst case
Deletion: O(1) expected, O(n) worst case
*/
/////////////////////////////////////////////////////////////////////////
/*
Runtime: 52 ms, faster than 86.65% of C++ online submissions for Group Anagrams.
Memory Usage: 20.5 MB, less than 45.34% of C++ online submissions for Group Anagrams.

Complexity:
Time Complexity:O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.

Algorithm:
use a map whose keys are sorted string, values are vectors of strings

Syntax: 
1. Check whether a map contains a key
map<int,Bar>::iterator it = m.find('2');
Bar b3;
if(it != m.end())
{
   //element found;
   b3 = it->second;
}
2. hashmap in c++: unordered_map
*/
//////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> ans;
        unordered_map<string, vector<string>> mymap;
        unordered_map<string,vector<string>>::iterator it;
        string mykey;
        for(int i = 0; i < strs.size(); i++) {     //O(N)
            mykey = strs[i];
            sort(mykey.begin(), mykey.end());      //O(KlogK)
            it = mymap.find(mykey);                //O(1)
            if(it == mymap.end()) {
            //the map doesn't contain the key
                vector<string> myvalue;
                myvalue.push_back(strs[i]);
                mymap[mykey] = myvalue;
            }else {
            //the map alr has the key	
                (it->second).push_back(strs[i]);
            }  	
        }
        for(it = mymap.begin(); it != mymap.end(); it++) {
            ans.push_back(it->second);
        }
        return ans;
    }
};

