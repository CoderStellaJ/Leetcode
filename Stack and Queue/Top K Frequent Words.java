/*
Runtime: 8 ms, faster than 65.62% of Java online submissions for Top K Frequent Words.
Memory Usage: 38.3 MB, less than 87.46% of Java online submissions for Top K Frequent Words.

Syntax:
runtime: O(nlogk)
space: O(n)

Algorithm:priorityqueue with k elements
1. loop through the words and put them in a map
2. offer them into a self-defined priorityqueue

Syntax:
1. str1.compareTo(str2)
if s1 > s2, it returns positive number    e.g. "b" > "a" (same as ASCII)
if s1 < s2, it returns negative number  
if s1 == s2, it returns 0  

2. implement your own comparator in priority queue
those you want to keep: return 1

3. get the first element in map
Map.Entry<String, Integer> mapentry = peekmap.entrySet().iterator().next();
*/
//////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

//implement comparator
class queComparator implements Comparator<Map<String, Integer>> {
  public int compare(Map<String, Integer> map1, Map<String, Integer> map2) {
    Map.Entry<String, Integer> entry1 = map1.entrySet().iterator().next();
    Map.Entry<String, Integer> entry2 = map2.entrySet().iterator().next();
    String word1 = entry1.getKey();
    int f1 = entry1.getValue();
    String word2 = entry2.getKey();
    int f2 = entry2.getValue();
    if(f1 > f2) return 1;     //return 1 for those you want to keep
    if(f1 == f2 && word1.compareTo(word2) < 0) return 1;
    return -1;
  }
}

class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    PriorityQueue<Map<String, Integer>> que = new PriorityQueue<>(new queComparator());   //syntax for self-defined priority queue
    List<String> ans = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0; i < words.length; i++) {     //O(N)
      int count = map.getOrDefault(words[i],0);
      map.put(words[i], count+1);
    }
    int m = 0;
    for(Map.Entry<String, Integer> entry:map.entrySet()){   //O(N)
      if(m >= k) {
        Map<String, Integer> peekmap = que.peek();
        Map.Entry<String, Integer> mapentry = peekmap.entrySet().iterator().next();
        int freq = mapentry.getValue();
        String word = mapentry.getKey();
        if(entry.getValue() > freq){
          que.poll();
          Map<String, Integer> mymap = new HashMap<>();
          mymap.put(entry.getKey(), entry.getValue());
          que.offer(mymap);     //O(logK)
        }else if(entry.getValue() == freq) {
          if(entry.getKey().compareTo(word) < 0) {
            que.poll();
            Map<String, Integer> mymap = new HashMap<>();
            mymap.put(entry.getKey(), entry.getValue());
            que.offer(mymap);
          }
        }
      }else{
        Map<String, Integer> mymap = new HashMap<>();
        mymap.put(entry.getKey(), entry.getValue());
        que.offer(mymap);
        m++;
      }
    }
    while(que.size() > 0) {   //O(K)
      Map<String, Integer> mymap = que.poll();
      Map.Entry<String, Integer> entry = mymap.entrySet().iterator().next();
      String str = entry.getKey();
      ans.add(0,str);
    }
    return ans;
        
  }

  public static void main(String[] args) {
    Solution sol = new Solution();
    String[] words1 =  {"a","b"};
    int k = 1;
    List<String> ans1 = sol.topKFrequent(words1, k);
    System.out.println(ans1);
    
  }
}
