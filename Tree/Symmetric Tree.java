/*
Complexity:
runtime: O(V)
space: O(V)

Algorithm 2: iterative method + Queue
We normally can transform recursion to iterations by using queue or stack
Note: 
Here, it's better to use a queue.
Using a stack makes it bottom-up and takes lots of time
*/
///////////////////////////////////////////////////////////////////////////////////////
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
  public boolean isSymmetric(TreeNode root) {
    //recursion
    if(root == null) return true;
    Queue<TreeNode> que = new LinkedList<>();
    que.offer(root.left);
    que.offer(root.right);
    while(!que.isEmpty()) {
      TreeNode cur1 = que.poll();
      TreeNode cur2 = que.poll();
      if(cur1 == null && cur2 == null) continue;
      if(cur1 == null || cur2 == null) return false;
      if(cur1.val != cur2.val) return false;
      que.offer(cur1.left);
      que.offer(cur2.right);
      que.offer(cur1.right);
      que.offer(cur2.left);
    }
    return true;
  }
}
////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1 ms, faster than 43.32% of Java online submissions for Symmetric Tree.
Memory Usage: 38.8 MB, less than 71.19% of Java online submissions for Symmetric Tree.

Complexity:
runtime: O(V)
space: O(V)   //for recursion

Algorithm 1: Recursion
*/
////////////////////////////////////////////////////////////////////////////////////////
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
  public boolean isSymmetric(TreeNode root) {
    //recursion
    if(root == null) return true;
    return helper(root.left, root.right);
  }
  
  public boolean helper(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) return true;
    if(root1 == null) return false;
    if(root2 == null) return false;
    if(root1.val == root2.val && helper(root1.left, root2.right) && helper(root1.right, root2.left)) return true;
    return false;
  }
}
