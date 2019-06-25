/*
Runtime: 38 ms, faster than 87.42% of Java online submissions for Word Ladder.
Memory Usage: 45.4 MB, less than 20.90% of Java online submissions for Word Ladder.

Complexity:
runtime: O(M*N)
where M is the length of words and N is the total number of words in the input word list. 
Finding out all the transformations takes M iterations for each of the N words. 
Also, breadth first search in the worst case might go to each of the N words.
space: O(M*N)
 to store all M transformations for each of the N words

Algorithm: Breadth-first Search
1. Do the pre-processing on the given wordList and find all the possible generic/intermediate states. 
Save these intermediate states in a dictionary with key as the intermediate word 
and value as the list of words which have the same intermediate word.
2. Push a tuple containing the beginWord and 1 in a queue. The 1 represents the level number of a node. 
We have to return the level of the endNode as that would represent the shortest sequence/distance from the beginWord.
3. To prevent cycles, use a visited dictionary.
4. While the queue has elements, get the front element of the queue. Let's call this word as current_word.
5. Find all the generic transformations of the current_word 
and find out if any of these transformations is also a transformation of other words in the word list. 
This is achieved by checking the all_combo_dict.
6. The list of words we get from all_combo_dict are all the words which have a common intermediate state with the current_word. 
These new set of words will be the adjacent nodes/words to current_word and hence added to the queue.
7. Hence, for each word in this list of intermediate words, 
append (word, level + 1) into the queue where level is the level for the current_word.
8. Eventually if you reach the desired word, its level would represent the shortest transformation sequence length.

Syntax:
1. java pair
import javafx.util.Pair;

*/
/////////////////////////////////////////////////////////////////
import javafx.util.Pair;

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int len = beginWord.length();
    Map<String, List<String>> allComboDict = new HashMap<>();
    for(String word:wordList){
      for(int i = 0; i < len; i++) {
        String newword = word.substring(0,i)+"*"+word.substring(i+1,len);
        List<String> transformations = allComboDict.getOrDefault(newword, new ArrayList<String>());
        transformations.add(word);
        allComboDict.put(newword, transformations);
      }
    }
    Queue<Pair<String, Integer>> que = new LinkedList<>();
    que.add(new Pair(beginWord, 1));
    
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);
    
    while(!que.isEmpty()){
      Pair<String, Integer> node = que.poll();
      String word = node.getKey();
      int level = node.getValue();
      for(int i = 0; i < len; i++) {
        String newword = word.substring(0, i)+"*"+word.substring(i+1);
        for(String adj:allComboDict.getOrDefault(newword, new ArrayList<String>())){
          if(adj.equals(endWord)) return level+1;
          if(!visited.containsKey(adj)){
            visited.put(adj, true);
            que.add(new Pair(adj, level+1));
          }
        }
      }
    }
    return 0;
          
  }
}

//////////////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

About the question:
1. endWord should also be in the wordlist
2. return the path length not the times of transformation. So the base case returns 2 instead of 1
Algorithm 1: Recursion
Note: 
1. minlen initialization
2. Base case: success(within the loop) and fail(at the start and after the loop)
Syntax:
1. length of a list: mylist.size()
2. public StringBuilder delete(int start, int end); .insert(index, c);
3. get the ith element in a list
get(index)
4. remove ith element in a list
list.remove(0);
5. add an element in a list
public void add(int index, E element)
*/
////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
      int minlen = wordList.size()+1, sub=0;  //sub for sub results
      boolean fail = true;
      //base cases
      if(wordList.size() == 0 || (wordList.size() >= 1 && !wordList.contains(endWord))) return 0; // base case that it fails

      StringBuilder sb = new StringBuilder(beginWord);
      for(int i = 0; i < beginWord.length(); i++){
        //check whether there is word that I can change to in the list
        char c = sb.charAt(i);
        sb.delete(i,i+1);
        for(int j = 0; j < wordList.size(); j++){
          String str = wordList.get(j);
          String newstr = str.substring(0,i)+str.substring(i+1);
          if(sb.toString().equals(newstr)){
            //beginword can be changed to newstr in the list
            if(str.equals(endWord)) return 2; //base case when it successes
            wordList.remove(j);
            sub = ladderLength(str,endWord,wordList);
            if(sub != 0){
                // System.out.println("sb "+sb.toString());
                // System.out.println("newstr "+newstr);
                // System.out.println("str "+str);
                // System.out.println("minlen "+minlen);
              fail = false;
              if(sub + 1 < minlen) minlen = sub+1;
            } 
            wordList.add(j,str);
          }
        }
        sb.insert(i,c);
      }
      return (fail == true)? 0: minlen;   
    }
}
