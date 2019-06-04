/*
Runtime: 1 ms, faster than 88.66% of Java online submissions for Binary Tree Level Order Traversal II.
Memory Usage: 35.7 MB, less than 99.96% of Java online submissions for Binary Tree Level Order Traversal II.

Algorithm 3: Without HashMap
To remove HashMap, we need to find another way to keep track of the level of a node in the queue
A better way is to use myque.size() because after poll() the previous level's nodes, the rest are all of this level
Trick: add the list to the beginning of the ans so you don't need to reverse at the end

Syntax:
1. add into a list
ans.add(0, mylist);   //add to the beginning of the list
*/
////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      Queue<TreeNode> myque = new LinkedList<TreeNode>();
      
      if(root == null) return ans;
      
      TreeNode cur = root;
      myque.offer(root);
      
      while(!myque.isEmpty()){
        List<Integer> mylist = new ArrayList<Integer>();
        int s = myque.size();
        for(int i = 0; i < s; i++) {
          cur = myque.poll();
          mylist.add(cur.val);
          if(cur.left != null){
            myque.offer(cur.left);
          }
          if(cur.right != null) {
            myque.offer(cur.right);
          }
        }
        ans.add(0,mylist);
      }
      return ans;
    }
}

////////////////////////////////////////////////////////////////////////////////
/*
Algorithm 2: Avoid using hashmap as this is very slow in actual runtime

Syntax:
1. create a pair in java
import javafx.util.Pair;    //However, this is not supported in coderpad
Pair <String, Integer> ans =  new Pair <String, Integer> ("", 0); 
*/
////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 2 ms, faster than 6.24% of Java online submissions for Binary Tree Level Order Traversal II.
Memory Usage: 35.7 MB, less than 99.94% of Java online submissions for Binary Tree Level Order Traversal II.

Complexity:
runtime: O(V)
space: O(V)

Algorithm 1: BFS + Queue + Hashmap

Syntax:
1. remove some element in a list: mylist.remove(ind)
2. reverse a list: Collections.reverse(mylist);
*/
///////////////////////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
      List<List<Integer>> ans = new ArrayList<List<Integer>>();
      Queue<TreeNode> myque = new LinkedList<TreeNode>();
      Map<TreeNode, Integer> mymap = new HashMap<TreeNode, Integer>();
      //store the treenode and its level
      int level = 1;
      TreeNode cur = root;
      if(root == null) return ans;
      mymap.put(root,level);
      myque.offer(root);
      List<Integer> mylist = new ArrayList<Integer>();
      mylist.add(root.val);
      ans.add(mylist);
      while(!myque.isEmpty()){
        cur = myque.poll();
        level = mymap.get(cur);
        if(ans.size() == level) {
          ans.add(new ArrayList<Integer>());
        }
        if(cur.left != null){
          mymap.put(cur.left,level+1);
          myque.offer(cur.left);
          ans.get(level).add(cur.left.val);
        }
        if(cur.right != null) {
          mymap.put(cur.right,level+1);
          myque.offer(cur.right);
          ans.get(level).add(cur.right.val);
        }
      }
      //remove the last extra list if it's empty
      if(ans.get(ans.size()-1).size() == 0) ans.remove(ans.size()-1);
      Collections.reverse(ans);
      return ans;
        
    }
}
