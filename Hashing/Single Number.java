/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
Memory Usage: 38.3 MB, less than 87.51% of Java online submissions for Single Number.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 3: Bit Manipulation
If we take XOR of zero and some bit, it will return that bit
a⊕0=a
If we take XOR of two same bits, it will return 0
a⊕a=0
a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
Proof: https://zhidao.baidu.com/question/486016726.html

Syntax:
^ in Java is the exclusive-or ("xor") operator.
^ is bitwise XOR
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res = res^nums[i];
        }
        return res;
    }
}
//////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 23.14% of Java online submissions for Single Number.
Memory Usage: 38.7 MB, less than 79.10% of Java online submissions for Single Number.

Complexity:
Hahmap Delete is O(1)
runtime: O(N)
space: O(N)

Algorithm 2:
meet once, push it into hashmap; meet twice, pop it out

Syntax:
1. remove an element in hashmap
mymap.remove(mykey);
2. get the first entry in a hashmap
mymap.entrySet().iterator().next()
*/
//////////////////////////////////////////////////////////////////////
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count = mymap.getOrDefault(nums[i],0);
            if(count == 0) mymap.put(nums[i], 1);
            else mymap.remove(nums[i]);
        }
        
        return mymap.entrySet().iterator().next().getKey();
    }
}
////////////////////////////////////////////////////////////////////
/*
Runtime: 9 ms, faster than 17.16% of Java online submissions for Single Number.
Memory Usage: 38.6 MB, less than 81.92% of Java online submissions for Single Number.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1: 
use a hashmap to store integer in array and its count

Syntax:
1. iterate through a hashmap
Map.Entry<Integer, String> entry : testMap.entrySet()
entry.getValue()

Habit:
specify something to return first
*/
////////////////////////////////////////////////////////////////
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            count = mymap.getOrDefault(nums[i],0);
            mymap.put(nums[i], count+1);
        }
        for(Map.Entry<Integer, Integer> entry: mymap.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return 0;
    }
}
