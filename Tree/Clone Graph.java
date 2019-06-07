/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Clone Graph.
Memory Usage: 32.5 MB, less than 98.86% of Java online submissions for Clone Graph.

Algorithm 2: DFS
optimize to 1 iteration for each node
Note:
push node into the map before going into the next level, other wise, it's dead loop
*/
/////////////////////////////////////////////////////////////////////////
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
  public Node cloneGraph(Node node) {
    Map<Node, Node> map = new HashMap<Node, Node>();
    return helper(node, map);
    
  }
  public Node helper(Node n, Map<Node, Node> map) {
    if(map.containsKey(n)) return map.get(n);
    Node newnode = new Node(n.val,new ArrayList<Node>());
    map.put(n,newnode);    //put it into the map before going into the loop
    List<Node> mylist = n.neighbors;
    for(Node mynode:mylist){
      newnode.neighbors.add(helper(mynode,map));
    }
    return map.get(n);
  }
}
//////////////////////////////////////////////////////////////////////
/*
Runtime: 2 ms, faster than 56.80% of Java online submissions for Clone Graph.
Memory Usage: 32.6 MB, less than 98.84% of Java online submissions for Clone Graph.

Algorithm 1: HashMap + 2 iterations
1. use a hashmap to store original node as key and new node as value
2. iterate through the hashmap to assign value and neighbors

Syntax:
1. iterate through a hashmap
Map.Entry<String, String> entry : map.entrySet()
*/
///////////////////////////////////////////////////////////////////
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        Queue<Node> que = new LinkedList<Node>();
        if(node == null) return node;
        //set up the map
        que.offer(node);
        map.put(node, new Node());
        while(!que.isEmpty()){
          Node cur = que.poll();
          List<Node> mylist = cur.neighbors;
          for(Node mynode:mylist){
            if(!map.containsKey(mynode)) {
              que.offer(mynode);
              map.put(mynode, new Node());
            }
          }
        }
        //iterate through hashmap
        for(Map.Entry<Node, Node> entry:map.entrySet()){
          Node ori = entry.getKey();
          Node newnode = entry.getValue();
          newnode.val = ori.val;
          List<Node> mylist = ori.neighbors;
          List<Node> newlist = new ArrayList<Node>();
          for(Node mynode:mylist){
            newlist.add(map.get(mynode));
          }
          newnode.neighbors = newlist;
        }
        return map.get(node);
  }
}
