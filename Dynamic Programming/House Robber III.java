/*
recursion
note: when canRob is true, you can still choose whether to rob or not

time: O(2^level)
space: O(1)

Runtime: 686 ms, faster than 19.69% of Java online submissions for House Robber III.
Memory Usage: 39.1 MB, less than 69.44% of Java online submissions for House Robber III.
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        //rob level 0
        if(root == null) {
            return 0;
        }
        int rob1 = auxFunc(root, true);
        int rob2 = auxFunc(root, false);
        return Math.max(rob1, rob2);
    }
    
    public int auxFunc(TreeNode cur, boolean canRob) {
        if(canRob == true) {
            //you can choose to either rob or not
            int resLeft1 = 0, resRight1 = 0;
            int resLeft2 = 0, resRight2 = 0;
            if(cur.left != null) {
                resLeft1 = auxFunc(cur.left, false);
                resLeft2 = auxFunc(cur.left, true);
            }
            if(cur.right != null) {
                resRight1 = auxFunc(cur.right, false);
                resRight2 = auxFunc(cur.right, true);
            }
            int resRob = resLeft1+resRight1+cur.val;
            int resNoRob = resLeft2+resRight2;
            return Math.max(resRob, resNoRob);
            
        }else {
            //rob the next level
            int resLeft = 0, resRight = 0;
            if(cur.left != null) {
                resLeft = auxFunc(cur.left, true);
            }
            if(cur.right != null) {
                resRight = auxFunc(cur.right, true);
            }
            return resLeft+resRight;
        }
    }
    
} 