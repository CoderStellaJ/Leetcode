/*
Complexity:
Runtime: O(Nlogk)
Space: O(N)

Algorithm 3:
Simplify based on Algorithm 2
use unordered_map to store number and their counts
use priority_queue to keep k numbers 

Syntax:
1. priority_queue size
myqueue.size()

2. create a pair
pair<T1,T2> make_pair (T1 x, T2 y);
make_pair(val.first, val.second)

3.priority_queue 
by default, keep a max_heap regarding the first element in pair
by default, is a max heap!

4. std::unordered_map
you don't need to check whether the key exists when you want to change value

*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::unordered_map<int, int> mymap;
        std::priority_queue<pair<int, int>, vector<pair<int, int>>, Comp> myqueue;
        for(int i = 0; i < nums.size(); i++) {
            mymap[nums[i]]++;
        }
        std::vector<int> res = {};
        std::unordered_map<int, int>::iterator it;
        for(it = mymap.begin(); it != mymap.end(); it++) {
          myqueue.push(make_pair(it->first, it->second));
          if(myqueue.size() > k) {
            myqueue.pop();
          }
        }
        
        while(!myqueue.empty()){
          res.insert(res.begin(), myqueue.top().first);
          myqueue.pop();
        }
        return res;
    }  
  struct Comp{
    bool operator()(const pair<int,int>& p1, const pair<int, int>& p2){
      return p1.second > p2.second;
    }
  };
};

////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 28 ms, faster than 30.73% of C++ online submissions for Top K Frequent Elements.
Memory Usage: 11.5 MB, less than 27.63% of C++ online submissions for Top K Frequent Elements.

Complexity:
Runtime: O(Nlogk)
Space: O(N)
push or pop an element in priority_queue take O(logN)

Algorithm 2:
use a map to count 
then use priority queue which only keeps k items

Syntax:
1. priority queue
min_heap
in operator() function: [true: first element deeper]
2. priority_queue with self-defined type
<A, vector<A>, Comp>
Comp is a struct with ; at the end !!!
*/
////////////////////////////////////////////////////////////////////////////////
typedef std::pair<int, int> mypair;
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::map<int, int> mymap;
        std::priority_queue<mypair, vector<mypair>, Comp> myqueue;
        for(int i = 0; i < nums.size(); i++) {
          if(mymap.find(nums[i]) == mymap.end()) {    //O(N)
            //not found
            mymap[nums[i]] = 1;
          }else {
            mymap[nums[i]]++;
          }
        }
        std::map<int, int>::iterator it;
        int count = 0;
        for(it = mymap.begin(); it != mymap.end()&& count<k; it++) {    //count < k, from 0 to <k is k elements
          count++;
          myqueue.push(mypair(it->first, it->second));    //O(klogk)
        }
        for(; it != mymap.end(); it++){   //O(Nlogk)
          if(it->second > myqueue.top().second) {
            myqueue.pop();
            myqueue.push(mypair(it->first, it->second));    
          }
        }
        std::vector<int> res = {};
        while(!myqueue.empty()){    //O(klogk)
          res.insert(res.begin(), myqueue.top().first);
          myqueue.pop();
        }
        return res;
    }
    struct Comp{
      bool operator()(const mypair& p1, const mypair& p2) {
        return p1.second > p2.second;
      }
    };
};

/////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 32 ms, faster than 22.15% of C++ online submissions for Top K Frequent Elements.
Memory Usage: 11.5 MB, less than 22.65% of C++ online submissions for Top K Frequent Elements.

Complexity:
Runtime: O(NlogN)
Space: O(N)
Note: std::map.find() complexity is O(logN) based on red black tree

Algorithm 1:
store each value and its count into a map and then sort the map based on count
Note:
the numbers are not sorted

Syntax:
1. sort a map based on value
Method 1:
convert it to a vector and then sort

2. std::pair<A, B> 
typedef std::pair<int, int> pair;
pair.first
pair.second

3. sort a vector
std::sort(myvec.begin(), myvec.end(), comp);
write comp as a static bool function
static bool comp(...){
  return [true, first element first]
}

4.copy a map into a vector
std::back_insert_iterator<Container> back_inserter( Container& c );
std::copy(mymap.begin(), mymap.end(), std::back_inserter<std::vector<pair>>(myvec))

*/
////////////////////////////////////////////////////////////////////////////
typedef std::pair<int, int> mypair;
class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        std::map<int, int> mymap;
        std::vector<mypair> myvec;
        for(int i = 0; i < nums.size(); i++) {    //O(N)
          if(mymap.find(nums[i]) == mymap.end()) {    //O(logN)
            //not found
            mymap[nums[i]] = 1;
          }else {
            mymap[nums[i]]++;
          }
        }
        //copy the map into the vector
        std::copy(mymap.begin(), mymap.end(), std::back_inserter<vector<mypair>>(myvec));   //O(N)
        std::sort(myvec.begin(), myvec.end(), comp);    //O(NlogN)
        std::vector<int> res;
        for(int i = 0; i < k; i++) {    //O(k)
          res.push_back(myvec[i].first);
        }
        return res;
    }
    static  bool comp(const mypair& p1, const mypair& p2){
        return p1.second > p2.second;
    }

};
