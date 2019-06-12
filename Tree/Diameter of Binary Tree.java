/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
Memory Usage: 39.3 MB, less than 38.38% of Java online submissions for Diameter of Binary Tree.

Algorithm : Recursion
Similar to `Binary Tree Maximum Path Sum`

Note:
helper function is used to return the number of nodes on the path instead of #edges
because to form an edge we need to make sure both ends are nodes 
but in recursion the next node is passed to the next call to judge whether it's null

Corner case:
root = null. max = 0 instead of max-1
*/
////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
  int max = 0;
  public int diameterOfBinaryTree(TreeNode root) {
    helper(root);
    return max==0?0:max-1;    //the edge case that max = 0
  }
  
  public int helper(TreeNode root){
    //return the maximum numebr of nodes on the path
    if(root == null) return 0;
    int maxleft = helper(root.left);
    int maxright = helper(root.right);
    max = Math.max(max, maxleft+maxright+1);
    return Math.max(maxleft+1, maxright+1);
  }
  
  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    root1.left = node2;
    root1.right=node3;
    node2.left=node4;
    node2.right=node5;
    Solution sol = new Solution();
    int ans1 = sol.diameterOfBinaryTree(root1);
    System.out.println("ans1 "+ans1);

  }
}
