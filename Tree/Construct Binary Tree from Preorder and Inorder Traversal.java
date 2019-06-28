/*
Runtime: 13 ms, faster than 18.01% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
Memory Usage: 43.2 MB, less than 8.53% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.

Complexity:
runtime: O(N)
space: O(N)

Algorithm: 
1. Preorder traversing implies that PRE[0] is the root node.
2. Then we can find this PRE[0] in IN, say it's IN[5].
3. Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
4. Recursively doing this on subarrays, we can build a tree out of it :)

Preorder: CLR
Inorder: LCR
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
  public TreeNode buildTree(int[] preorder, int[] inorder) {
      return helper(0, 0, inorder.length-1, preorder, inorder);
  }
  
  public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
    if(preStart > preorder.length-1 || inStart > inEnd) {   //2 base cases
      return null;
    }
    TreeNode root = new TreeNode(preorder[preStart]);
    int inIndex = 0;
    for(int i = inStart; i <= inEnd; i++) {
      if(inorder[i] == root.val) {
        inIndex = i;
      }
    }
    root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
    root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);
    //here, preStart is incremented by the number of nodes on the left
    return root;
  }
}
