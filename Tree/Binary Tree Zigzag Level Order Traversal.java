/*
Runtime: 2 ms, faster than 75.90% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
Memory Usage: 35.5 MB, less than 99.35% of Java online submissions for Binary Tree Zigzag Level Order Traversal.

Complexity:
runtime: O(V)
space: O(V)

Algorithm:
1. hashmap: store treenode and its level
2. queue: record sequence for BFS searching (This sequence is the answer list sequence)
3. stack: reverse the sequence of current level to make sure the sequence of the next level is correct.

syntax:
1. create a list in java
List myList = new ArrayList();
2. create a list of list
List<List<String>> csvList = new ArrayList<List<String>>();
*/
//////////////////////////////////////////////////////////////
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	//use queue for BFS
    	int level = 1;	//its children: even:from left to right; odd: from right to left
    	TreeNode cur=root;
    	//for the returned answer
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	List<Integer> lelist = new ArrayList<Integer>();
    	if(root == null) return ans;
    	//for BFS search
    	Queue<TreeNode> myque = new LinkedList<TreeNode>();		//for BFS sequence
    	Map<TreeNode, Integer> mymap = new HashMap<TreeNode, Integer>();	//record the level
    	Stack<TreeNode> mystack = new Stack<TreeNode>();
    	//initialization
    	mymap.put(root, 1);
    	myque.offer(root);
    	lelist.add(root.val);
    	ans.add(lelist);
    	//store the node and its level
    	while(!myque.isEmpty() || !mystack.isEmpty()){
    		if(!mystack.isEmpty()) cur = mystack.pop();
    		else cur = myque.peek();
    		level = mymap.get(cur);		//current level of the node
    		if(ans.size() == level) {
    			//add list for its children
    			lelist = new ArrayList<Integer>();
    			ans.add(lelist);
    			while(!myque.isEmpty()) {
    				mystack.push(myque.poll());
    			}
    			cur = mystack.pop();
    		}
    		if(level%2 == 0){
    			//from left to right
    			if(cur.left != null){
    				mymap.put(cur.left, level+1);
    				myque.offer(cur.left);
    				ans.get(ans.size()-1).add(cur.left.val);
    			}
    			if(cur.right != null){
    				mymap.put(cur.right, level+1);
    				myque.offer(cur.right);
    				ans.get(ans.size()-1).add(cur.right.val);
    			}
    		}else{
    			//from right to left
    			if(cur.right != null){
    				mymap.put(cur.right, level+1);
    				myque.offer(cur.right);
    				ans.get(ans.size()-1).add(cur.right.val);
    			}
    			if(cur.left != null){
    				mymap.put(cur.left, level+1);
    				myque.offer(cur.left);
    				ans.get(ans.size()-1).add(cur.left.val);
    			}
    		}
    	}

    	if(ans.get(ans.size()-1).isEmpty()) ans.remove(ans.size()-1);
        return ans;
    }
}
