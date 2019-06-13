/*
Runtime: 4 ms, faster than 76.73% of Java online submissions for Valid Anagram.
Memory Usage: 37.4 MB, less than 67.96% of Java online submissions for Valid Anagram.

Complexity:
runtime: O(M+N)
space: O(1)

Algorithm 2: Use Array to replace the HashMap 
HashMap initialization may take some time, and it's fixed size
*/
/////////////////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isAnagram(String s, String t) {
    int[] count = new int[26];
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      count[c-'a']++;
    }
    for(int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      count[c-'a']--;
      if(count[c-'a'] < 0) return false;
    }
    for(int i = 0; i < 26; i++){
      if(count[i] != 0) return false;
    }
    return true;
  }
}
////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 21 ms, faster than 16.01% of Java online submissions for Valid Anagram.
Memory Usage: 38.2 MB, less than 48.13% of Java online submissions for Valid Anagram.

Complexity:
runtime: O(M+N)
space: O(1)   //there in total 26 letters, so it's fixed size

Algorithm 1: HashMap
*/
//////////////////////////////////////////////////////////////////////////////
class Solution {
  public boolean isAnagram(String s, String t) {
    Map<Character, Integer> map1 = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      map1.put(c, map1.getOrDefault(c,0)+1);
    }
    for(int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      if(!map1.containsKey(c)) return false;
      else{
        int value = map1.get(c);
        if(value > 1) map1.put(c,value-1);
        else map1.remove(c);
      }
    }
    if(!map1.isEmpty()) return false;
    return true;
  }
}
