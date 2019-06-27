/*
Runtime: 2 ms, faster than 11.84% of Java online submissions for Maximum Depth of Binary Tree.
Memory Usage: 38.6 MB, less than 97.53% of Java online submissions for Maximum Depth of Binary Tree.

Complexity:
runtime: O(logN)
space: O(N)

Syntax:
1. Pair
1) getKey(), getValue()
2) new Pair<x,y>();   //specify the type
3) Pair<x,y> mypair = ...   //on the left also needs type specification
*/
////////////////////////////////////////////////////////////////////////
import javafx.util.Pair;
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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        Queue<Pair<TreeNode, Integer>> que = new LinkedList<>();
        if(root == null) return 0;
        que.offer(new Pair<TreeNode, Integer>(root, 1));
        while(!que.isEmpty()) {
            Pair<TreeNode, Integer> curlevel = que.poll();
            TreeNode node = curlevel.getKey();
            int lvl = curlevel.getValue();
            depth = lvl;
            if(node.left!=null){
                que.offer(new Pair<TreeNode, Integer>(node.left, lvl+1));
            }
            if(node.right!=null){
                que.offer(new Pair<TreeNode, Integer>(node.right, lvl+1));
            }
        }
        return depth;
    }
}
