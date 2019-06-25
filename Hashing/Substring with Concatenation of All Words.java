/*
Runtime: 127 ms, faster than 20.84% of Java online submissions for Substring with Concatenation of All Words.
Memory Usage: 40.7 MB, less than 58.41% of Java online submissions for Substring with Concatenation of All Words.

Complexity:
runtime: O(MNP)  M is length of s, N is length of words, P is length of each word in words
space: O(N)  N is the length of words[]

Algorithm: sliding window
note the condition that all strings in the list are of the same length
1. count all the words and put them into the hashmap
2. slides a window and check whether all the words occur in the window

Syntax:
1. deep copy a map
Map<String, Integer> copymap = new HashMap<>(mymap);
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> ans = new ArrayList<>();
    if(words.length == 0) return ans;
    int len = words[0].length();
    int windowsize = len * words.length;
    //store the counts of the strings
    Map<String, Integer> mymap = new HashMap<>();
    for(String word:words){
      int count = mymap.getOrDefault(word, 0);
      mymap.put(word, count+1);
    }
    //sliding window
    for(int i = 0; i <= s.length()-windowsize; i++) {
      String str = s.substring(i, i+windowsize);
      //check whether it contains all the words
      Map<String, Integer> copymap = new HashMap<>(mymap);
      int counter = copymap.size();   
      for(int j = 0; j < str.length(); j+=len) {
        String substr = str.substring(j,j+len);
        if(copymap.containsKey(substr)) {
          if(copymap.get(substr) == 1) counter--;   //check whether all words appear in the window
          copymap.put(substr, copymap.get(substr)-1);
        }else{
          break;
        }
      }
      if(counter == 0) ans.add(i);
    }
    return ans;
  }
}
//////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm:
1. generate all the possible combinations
2. find all the indecies of the combined string

Syntax:
1. remove an element from a list
mylist.remove(obj)

Corner case:
1. "aaa", ["a", "a"]  -> [0, 1]
*/
//////////////////////////////////////////////////////////////////////////////////
class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    //generate all possible combinations
    List<String> wordlist = new ArrayList<>();
    for(String word:words) {
      wordlist.add(word);
    }
    List<String> mylist = comb(wordlist);
    //System.out.println("comb "+mylist);
    List<Integer> ans = new ArrayList<>();
    for(String str:mylist) {
      //find indecies of this str
      //algo for finding all indecies of a string in another string
      int index = s.indexOf(str);
      if(index != -1) {
        if(!ans.contains(index)) ans.add(index);
        while(index >= 0) {
          index = s.indexOf(str, index+1);    //index+1
          if(index!=-1 && !ans.contains(index)) ans.add(index);
        }
      }
    }
    return ans;
  }
  
  public List<String> comb(List<String> words) {
    List<String> ans = new ArrayList<>();
    if(words.size() == 1) {
      ans.add(words.get(0));
      return ans;
    }
    for(int i = 0; i < words.size(); i++) {
      String str = words.get(i);
      words.remove(str);
      List<String> sub = comb(words);
      for(int j = 0; j < sub.size(); j++) {
        String newstr = sub.get(j)+str;
        ans.add(newstr);
      }
      words.add(i,str);
    }
    return ans;
  }
}
