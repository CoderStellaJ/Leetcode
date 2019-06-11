/*
Runtime: 1 ms, faster than 99.81% of Java online submissions for Binary Tree Maximum Path Sum.
Memory Usage: 40 MB, less than 99.26% of Java online submissions for Binary Tree Maximum Path Sum.

Complexity:
runtime: O(V)

Algorithm: Recursion
1. an attribute called max to record the answer(max value)
2. helper function helps to return max among (root, rootleftpath, rootrightpath) and update max


It's common to search/iterate through a tree using recursion
*/
//////////////////////////////////////////////////////////////////
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
  int max = Integer.MIN_VALUE;
  public int maxPathSum(TreeNode root) {
    helper(root);
    return max;
    
  }
  public int helper(TreeNode root) {
    if(root == null) return 0;
    int leftSum = helper(root.left);
    int rightSum = helper(root.right);
    int rootMax = Math.max(root.val, Math.max(leftSum + root.val, rightSum + root.val));
    max = Math.max(max, Math.max(rootMax, leftSum + rightSum + root.val));
    return rootMax;   //here, not returning max but rootMax
  }
}
