/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
Memory Usage: 37.3 MB, less than 99.07% of Java online submissions for Validate Binary Search Tree.

Algorithm: Recursion
with 2 auxiliary functions to get the min and max values of root.right.left and root.left.right

Note: cannot simply use recursion and compare the child withits direct parent.
Because all the right nodes should be larger than root and all left nodes should be smaller
Thus, root.right.left.min > root

Syntax:
1. In the function, it's in the structure of if-else
can't add return at the end of the function because the statemenet can never be reached and causes error
*/
////////////////////////////////////////////////////////////////////////
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
    public boolean isValidBST(TreeNode root) {
      if(root == null) return true;
      if(root.left == null && root.right == null) return true;
      if(root.left == null){
        //root.right != null
        if(nodesmin(root.right) > root.val && isValidBST(root.right)) return true;
        return false;
      }else if(root.right == null) {
        if(nodesmax(root.left) < root.val && isValidBST(root.left)) return true;
        return false;
      }else {
        return (nodesmin(root.right) > root.val && isValidBST(root.right) && nodesmax(root.left) < root.val && isValidBST(root.left))? true:false;
      }
    }
    
    public int nodesmin(TreeNode root){
      //get the min value of the left part
      if(root.left == null) return root.val;
      else return Math.min(root.left.val, nodesmin(root.left));
    }
  
    public int nodesmax(TreeNode root){
      //get the max value of the right part
      if(root.right == null) return root.val;
      else return Math.max(root.right.val, nodesmax(root.right));
    }
}
