/*
Runtime: 1 ms, faster than 57.33% of Java online submissions for Binary Tree Preorder Traversal.
Memory Usage: 34.9 MB, less than 99.98% of Java online submissions for Binary Tree Preorder Traversal.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: Iterative + Stack
*/
///////////////////////////////////////////////////////////////////
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
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      Stack<TreeNode> mystack = new Stack<>();
      TreeNode cur = root;
      while(cur != null) {
        ans.add(cur.val);
        if(cur.right != null) mystack.push(cur.right);
        cur = cur.left;
        if(cur == null && !mystack.isEmpty()){
          cur = mystack.pop();
        }
      }
      return ans;
    }
}
/////////////////////////////////////////////////////////////////////////////
/*
Runtime: 1 ms, faster than 57.33% of Java online submissions for Binary Tree Preorder Traversal.
Memory Usage: 34.8 MB, less than 99.98% of Java online submissions for Binary Tree Preorder Traversal.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: Recursion
*/
//////////////////////////////////////////////////////////////////////////////////
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
    public List<Integer> preorderTraversal(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      List<Integer> leftans, rightans;
      if(root == null) return ans;
      leftans = preorderTraversal(root.left);
      rightans = preorderTraversal(root.right);
      ans.add(root.val);
      for(Integer a:leftans) ans.add(a);
      for(Integer b:rightans) ans.add(b);
      return ans;
    }
}
