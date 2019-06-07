/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
Memory Usage: 35 MB, less than 99.98% of Java online submissions for Binary Tree Inorder Traversal.

Algorithm: Recursion
Use Recursion to do traversal
*/
///////////////////////////////////////////////////////////////////////////////////
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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<Integer>();
    helper(root, ans);
    return ans;
  }
  
  public void helper(TreeNode root, List<Integer> mylist) {   //pass answer list into the helper function as parameter
    if(root == null) return;
    helper(root.left, mylist);
    mylist.add(root.val);
    helper(root.right, mylist);
  }
}
