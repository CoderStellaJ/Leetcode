//////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 16 ms, faster than 28.79% of Java online submissions for Serialize and Deserialize Binary Tree.
Memory Usage: 39 MB, less than 86.72% of Java online submissions for Serialize and Deserialize Binary Tree.

Complexity:
runtime: O(V + E) = O(V) (E = 2*V)
space: O(V)

Algorithm: BFS
Use a queue to implement BFS

Syntax:
1. StringBuilder doesn't have .split
sb.toString().split(somestr);

*/
/////////////////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	Queue<TreeNode> myque = new LinkedList<TreeNode>();
    	StringBuilder ans = new StringBuilder();
    	if(root != null){   
        //add this condition because for root = null, string should be "[]" without null, inside
        //null only denotes the leaf of a branch
	    	myque.offer(root);
	    	while(!myque.isEmpty()){
	    		TreeNode cur = myque.poll();
	    		if(cur == null){
	    			ans.append("null,");
	    		}else{
	    			ans.append(Integer.toString(cur.val)+",");
	    			myque.offer(cur.left);
	    			myque.offer(cur.right);
	    		}
	    	}
        if(ans.charAt(ans.length()-1) == ',') ans.delete(ans.length()-1, ans.length());
      }
      ans.insert(0,"[");
      ans.append("]");
      return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	//remove the first and the last one
    	Queue<TreeNode> myque = new LinkedList<TreeNode>();
    	StringBuilder sb = new StringBuilder(data);
    	sb.delete(0,1);
    	sb.delete(sb.length()-1,sb.length());
    	if(sb.length() == 0) return null;
    	String[] nodes = sb.toString().split(",");
    	if(nodes[0] == null) return null;
    	TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));
    	myque.offer(head);
    	int i = 0;
    	while(!myque.isEmpty()){
    		TreeNode cur = myque.poll();
    		if(cur != null){
    			i++;
	    		TreeNode leftnode = (nodes[i].equals("null"))?null:new TreeNode(Integer.parseInt(nodes[i]));
	    		i++;
	    		TreeNode rightnode = (nodes[i].equals("null"))?null:new TreeNode(Integer.parseInt(nodes[i]));
	    		cur.left = leftnode;
	    		cur.right = rightnode;
	    		myque.offer(leftnode);
	    		myque.offer(rightnode);
    		}
    	}
      return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
