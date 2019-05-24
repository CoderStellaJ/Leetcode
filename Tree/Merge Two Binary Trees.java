/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Binary Trees.
Memory Usage: 39 MB, less than 99.60% of Java online submissions for Merge Two Binary Trees.

Algorithm: Recursion
*/
////////////////////////////////////////////////////////////////////////////
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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
      if(t1 == null && t2 == null) return t1;
      if(t1 == null){
        //t2 is not null
        return t2;    //return t2!
      }else if(t2 == null) {
        return t1;
      }else {
        //both are not null
        t1.val = t1.val + t2.val;
        t1.left = mergeTrees(t1.left,t2.left);    
        //you not just need to change val in t1.left, but also return the node to make sure the connection is correct
        //especially when t1.left was originally null
        t1.right = mergeTrees(t1.right,t2.right);
        return t1;
      }
    }
}
