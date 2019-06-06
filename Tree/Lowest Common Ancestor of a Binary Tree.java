/*
Runtime: 6 ms, faster than 51.16% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
Memory Usage: 35.1 MB, less than 5.61% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

Complexity: 
runtime: O(V)
space: O(V)

Algorithm 2: Recursion
The approach is pretty intuitive. Traverse the tree in a depth first manner. 
The moment you encounter either of the nodes p or q, return some boolean flag. 
The flag helps to determine if we found the required nodes in any of the paths. 
The least common ancestor would then be the node for which both the subtree recursions return a True flag. 
It can also be the node which itself is one of p or q and for which one of the subtree recursions returns a True flag.

Syntax:
1. Java variable by default is private
*/
///////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    private TreeNode ans;
    public Solution() {
      this.ans = null;
    }

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
      if (currentNode == null) return false;
      int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;
      int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;
      int mid = (currentNode == p || currentNode == q) ? 1 : 0;

      if (mid + left + right >= 2) {
          this.ans = currentNode;
      }
      return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      this.recurseTree(root, p, q);
      return this.ans;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 14 ms, faster than 11.57% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
Memory Usage: 35.2 MB, less than 5.13% of Java online submissions for Lowest Common Ancestor of a Binary Tree.

Complexity:
runtime: O(V)
space: O(V)

Algorithm 1: Path Finder
1. BFS to store each node and its parent into a hashmap
2. use a list torepresent the path from node p to root; another list for q
3. check whether there are same node in 2 lists
Note:
the list and hashmap should both use TreeNode type because you will need to return the node instead of the int value
*/
////////////////////////////////////////////////////////////////////////////////////////////
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      Map<TreeNode, TreeNode> mymap = new HashMap<TreeNode, TreeNode>();
      Queue<TreeNode> myque = new LinkedList<TreeNode>();
      if(root == null) return null;
      //BFS
      myque.offer(root);
      mymap.put(root,root);
      while(!myque.isEmpty()) {
        TreeNode cur = myque.poll();
        if(cur.left != null) {
          myque.offer(cur.left);
          mymap.put(cur.left, cur);
        }
        if(cur.right != null) {
          myque.offer(cur.right);       
          mymap.put(cur.right, cur);
        }
      }
      List<TreeNode> list1 = new ArrayList<TreeNode>();
      List<TreeNode> list2 = new ArrayList<TreeNode>();
      //records the path
      TreeNode cur1 = p, cur2 = q;
      list1.add(cur1);
      while(mymap.get(cur1) != cur1){
        list1.add(mymap.get(cur1));
        cur1 = mymap.get(cur1);
      }
      list2.add(cur2);
      if(list1.contains(cur2)) return cur2; 
      while(mymap.get(cur2) != cur2){
        list2.add(mymap.get(cur2));
        cur2 = mymap.get(cur2);
        if(list1.contains(cur2)) return cur2;
      }
      return null;
    }
}
