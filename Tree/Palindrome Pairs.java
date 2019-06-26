/*
Algorithm 3:
1. Suppose we have A and B, AB is palindrome. Which means
case 1, A is longer than B, then reverse B must be prefix of A
e.g. A:sll, B:ls
case 2, B is longer than A, then reverse B must be A + a palindromic suffix
e.g. A:ls, B:qqsl

2. We store all the words into Trie, and traverse each reversed word, say it, B.
If next char in B is not in trie, we return
If we find TrieNode that hasWord in it, we fall into case 2, and we only need to check the suffix of B is palindromic
If we loop through B and we get to a TrieNode, we know it stores all words whose suffix are palindromic, 
we add each pair of index (idx, B)

Note: 
1. special case such as empty string, we need add one extra pair. ( "" + palindrome = palindrome + "")
2. palindrome itself could find itself in our method, so we definitely need to check if indexes are unique.

Knowledge: 
1. Trie
Each node is a letter and each path forms a word
2. Default access modifier
Default access modifier is package-private - visible only from the same package
*/
//////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////
/*
Problem:
"s" and "lls", most part of the palindrome is in another string

Algorithm 2: Hashset
Matching/ Pairing questions can use hashing to quickly retrieve elements

Syntax:
1. stringbuilder.reverse() doesn't change the stringbuilder itself but return a new one
*/
////////////////////////////////////////////////////////////////////////////////
/*
Algorithm 1 + small trick : 
This palindrome check accepts both words as input parameters 
and thanks to that there is no need to concatenate two words before the call. 
Since concatenation is not cheap (means creating new object), 
this optimisation gives around 5x speedup on test data and was enough to stay within time limits.
*/
/////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Complexity:
runtime: O(N^2)
space: O(N^2)

Trying to write test cases by myself

Algorithm 1: brute force
consider every pair in the array of string
and note that it can have both 0,1 and 1,0  

Syntax:
1. main function in java:
inside the class:
public static void main(String[] args) { }
2. helper function print: declared as static!
public static void print(...) {}
3. static function cannot access non-static variable inside the class
4. import the library
import java.util.*;
*/
//////////////////////////////////////////////////////////////////////////////////
import java.util.*;

class Solution {
    static int i=0;
    public List<List<Integer>> palindromePairs(String[] words) {
        //brute force
      List<List<Integer>> ans = new ArrayList<List<Integer>> ();
      for(int i = 0; i < words.length; i++) {
        for(int j = 0; j < words.length; j++) {    //the sequence matters also
          if(j == i) continue;
          if(ispalin(words[i]+words[j])){
            System.out.println("palin is "+ (words[i]+words[j]));
            List<Integer> mylist = new ArrayList<Integer>();
            mylist.add(i);
            mylist.add(j);
            ans.add(mylist);
          }
        }
      }
      return ans;
    }
  
    public boolean ispalin(String str) {
      for(int i = 0; i < str.length()/2; i++) {
        if(str.charAt(i) != str.charAt(str.length()-1-i)) return false;
      }
      return true;
    }
  
    public static void main(String[] args) {
      Solution mysol = new Solution();
      String[] words1 = {"abcd","dcba","lls","s","sssll"};
      String[] words2 = {"bat","tab","cat"};
      String[] words3 = {"bat"};
      List<List<Integer>> ans1 = mysol.palindromePairs(words1);
      print(ans1);
      List<List<Integer>> ans2 = mysol.palindromePairs(words2);
      print(ans2);
      List<List<Integer>> ans3 = mysol.palindromePairs(words3);
      print(ans3);
    }
  
    public static void print(List<List<Integer>> ans) {
      i++;
      System.out.println("ans "+i);
      for(int i=0; i<ans.size(); i++) {
        for(int j=0; j<ans.get(i).size(); j++) {
          System.out.print(" "+ans.get(i).get(j));
        }
        System.out.print("\n");
      }
      System.out.print("\n");
    }
}



