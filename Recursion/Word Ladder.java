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
