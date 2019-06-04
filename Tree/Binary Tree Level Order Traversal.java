/*
Runtime: 1 ms, faster than 75.57% of Java online submissions for Binary Tree Level Order Traversal.
Memory Usage: 35.3 MB, less than 99.98% of Java online submissions for Binary Tree Level Order Traversal.

Complexity:
runtime: O(V)
space: O(V)

Algorithm : BFS
use myque.size() as a reference to the current level of nodes
*/
////////////////////////////////////////////////////////////////
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
    public List<List<Integer>> levelOrder(TreeNode root) {
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
        ans.add(mylist);
      }
      return ans; 
    }
}
