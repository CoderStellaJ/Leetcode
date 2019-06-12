/*
Runtime: 58 ms, faster than 95.65% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 50.5 MB, less than 94.09% of Java online submissions for Binary Search Tree Iterator.

Complexity:
runtime: O(1) on average, O(N) is the worst for nodes that have right child
space: O(h)
The space complexity is O(h) which is occupied by our custom stack for simulating the inorder traversal. 

Algorithm 2: Stack
actually Algorithm 1 already gets the point of optimal solution
You don't have to use a priority queue because it's already a BST which has some sort of sequence inside.
All you need is just a stack

Syntax:
To avoid duplicate code, create a function called leftnodes to put all nodes on the left into the stack
*/
////////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class BSTIterator {
  Stack<TreeNode> mystack;
  
  public BSTIterator(TreeNode root) {
    mystack = new Stack<TreeNode>();
    if(root != null) {
      mystack.push(root);
      leftnodes(root);
    }
  }
  
  private void leftnodes(TreeNode root){
    while(root.left != null) {
      mystack.push(root.left);
      root = root.left;
    }
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode ans = mystack.pop();
    if(ans.right != null){
      mystack.push(ans.right);
      leftnodes(ans.right);
    }
    return ans.val;
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !mystack.isEmpty();
  }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 63 ms, faster than 32.99% of Java online submissions for Binary Search Tree Iterator.
Memory Usage: 49.9 MB, less than 95.63% of Java online submissions for Binary Search Tree Iterator.

Complexity:
runtime: next() O(logh); hasNext() O(1)
space: O(h)

Algorithm 1: Priority Queue
1. Initialization
put root.left.left... into the queue
2. next()
poll() from the priority queue: ans   //O(h)
and put all the left nodes of ans.right into the queue    //Because they are the next smallest nodes 

Syntax:
1. Create a priority queue of self-defined types
need to write our own comparator class and function
See the code below

*/
/////////////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
class newComparator implements Comparator<TreeNode>{
  public int compare(TreeNode node1, TreeNode node2){   //return type is int!
    return (node1.val < node2.val)?-1:1;    //minHeap: smaller: return -1;
  }
}

class BSTIterator {
    PriorityQueue<TreeNode> que;

    public BSTIterator(TreeNode root) {
        que = new PriorityQueue<TreeNode>(new newComparator());
        if(root != null) {
          que.offer(root);
          TreeNode cur = root;
          while(cur.left != null){
            que.offer(cur.left);
            cur = cur.left;
          }
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode ans = que.poll();
        if(ans.right != null){
          que.offer(ans.right);
          TreeNode cur = ans.right;
          while(cur.left != null) {
            que.offer(cur.left);
            cur = cur.left;
          }
        }
        return ans.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !que.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
