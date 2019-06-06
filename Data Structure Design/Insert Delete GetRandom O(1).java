/*
Runtime: 55 ms, faster than 68.30% of Java online submissions for Insert Delete GetRandom O(1).
Memory Usage: 46.8 MB, less than 57.13% of Java online submissions for Insert Delete GetRandom O(1).

Algorithm: HashMap + ArrayList
we need HashMap to get element in O(1)
To get elements randomly, index is needed so ArrayList is used.
The problem is about removing element part.
We can choose to swap the removed element to the end of the arraylist and then remove it O(1)

Syntax:
1. hashset: 
.add(myobj)
.remove(myobj)
2. HashMap
.remove(mykey)
3. ArrayList
.set(ind, element)
4. Generate random number
java.util.Random.nextInt(n): generate random number [0,n)
Random random = new Random();
random.nextInt(x);
*/
///////////////////////////////////////////////////////////////////////////////////////
class RandomizedSet {
    Map<Integer, Integer> map;
    ArrayList<Integer> list;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)) {
            map.put(val,list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)) {
            int position = map.get(val);
            int last = list.size()-1;
            if(position!=last) {
                int value = list.get(last);
                list.set(position , value);
                map.put(value,position);
            }
            list.remove(last);
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int at = random.nextInt(list.size());
        return list.get(at);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
