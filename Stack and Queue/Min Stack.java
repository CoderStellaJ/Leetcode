/*
This question is a data structure design question.

instaed keeping a 2 structures for stack and min, we can design our own linked list
each node contains: val of this node and min value of the rest remaining nodes

time: O(N)
space: O(N)

Runtime: 4 ms, faster than 88.54% of Java online submissions for Min Stack.
Memory Usage: 40.9 MB, less than 25.37% of Java online submissions for Min Stack.
*/


class MinStack {

    /** initialize your data structure here. */
    Node head;
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if(head == null) {
            head = new Node(x, x, null);
        }else {
            int newMin = Math.min(x, head.min);
            Node cur = new Node(newMin, x, head);
            head = cur;
        }
    }
    
    public void pop() {
        if(head != null) {
            head = head.next;
        }
        
    }
    
    public int top() {
        return head.val;
        
    }
    
    public int getMin() {
        return head.min;
        
    }
}

class Node {
    public int min;
    public int val;
    public Node next;
    public Node(int min, int value, Node next) {
        this.min = min;
        this.val = value;
        this.next = next;
    }
}

/*
use a priority queue for min value and a stack for all the elements
time: O(nlogn) (for priority queue)
space: O(N)

Runtime: 9 ms, faster than 20.29% of Java online submissions for Min Stack.
Memory Usage: 40.8 MB, less than 27.54% of Java online submissions for Min Stack.

syntax:
1. priority queue: PriorityQueue<Integer> myqueue = new PriorityQueue<Integer>();
2. customized lambda comparator for priority queue: 
PriorityQueue<String> pq = new PriorityQueue<String>(5,(a,b) -> a.length() - b.length());
3. stack: peek() pop() push()
4. priority queue: add() peek() remove() poll()

*/

class MinStack {

    /** initialize your data structure here. */
    PriorityQueue<Integer> myqueue;
    Stack<Integer> mystack;
    
    public MinStack() {
        myqueue = new PriorityQueue<Integer>();
        mystack = new Stack<Integer>();
    }
    
    public void push(int x) {
        myqueue.add(x);
        mystack.push(x);
        
    }
    
    public void pop() {
        int element = mystack.pop();
        myqueue.remove(element);
    }
    
    public int top() {
        return mystack.peek();
    }
    
    public int getMin() {
        return myqueue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */