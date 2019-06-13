/*
Runtime: 41 ms, faster than 32.94% of Java online submissions for First Unique Character in a String.
Memory Usage: 37.9 MB, less than 99.50% of Java online submissions for First Unique Character in a String.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2: 1 HashMap
the second iteration loop through the string and get from HashMap to see whether it occurs only once.
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int firstUniqChar(String s) {
    Map<Character, Integer> mymap = new HashMap<>();
    //store the chars and their index
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      mymap.put(c, mymap.getOrDefault(c,0)+1);
    }
    for(int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if(mymap.get(c) == 1) return i;
    }
    return -1;
  }
}
//////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 26 ms, faster than 53.31% of Java online submissions for First Unique Character in a String.
Memory Usage: 38.3 MB, less than 96.10% of Java online submissions for First Unique Character in a String.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1: 1 HashSet + 1 HashMap
Set to store all the characters we have seen
and map to store the char and its char
*/
////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public int firstUniqChar(String s) {
    Set<Character> chars = new HashSet<Character>();
    //store all the chars we have seen
    Map<Character, Integer> index = new HashMap<>();
    //store the chars and their index
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(chars.contains(c)){
        if(index.containsKey(c)) index.remove(c);
      }else{
        chars.add(c);
        index.put(c,i);
      }
    }
    int ans = s.length()-1;
    if(index.isEmpty()) return -1;
    for(Map.Entry<Character,Integer> entry:index.entrySet()){
      ans = Math.min(ans,entry.getValue());
    }
    return ans;
  }
}
