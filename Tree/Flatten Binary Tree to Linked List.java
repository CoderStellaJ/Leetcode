/*
Runtime: 1 ms, faster than 43.81% of Java online submissions for Flatten Binary Tree to Linked List.
Memory Usage: 35.9 MB, less than 99.94% of Java online submissions for Flatten Binary Tree to Linked List.

Complexity: 
runtime: O(V)
space: O(V)

Algorithm: Recursion
*/
/////////////////////////////////////////////////////////////////////////////////////////////
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
  public void flatten(TreeNode root) {
    if(root == null) return;
    helper(root);   //Note the return type is void, so no need to return anything
  }
  
  public TreeNode helper(TreeNode root) {
    if(root.left == null && root.right == null) return root;
    if(root.left == null) {
      return helper(root.right);
    }else if(root.right == null) {
      TreeNode leftend = helper(root.left);
      root.right = root.left;
      root.left = null;
      return leftend;
    }else{
      TreeNode leftend = helper(root.left);
      TreeNode rightstart = root.right;
      root.right = root.left;
      root.left = null;
      TreeNode ans = helper(rightstart);
      leftend.right = rightstart;
      return ans;
    }
  }
  
}
