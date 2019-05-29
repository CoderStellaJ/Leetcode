/*
Runtime: 1 ms, faster than 62.24% of Java online submissions for Reverse Nodes in k-Group.
Memory Usage: 35.8 MB, less than 99.90% of Java online submissions for Reverse Nodes in k-Group.

Complexity:
runtime: O(N)
space: O(1)

Algorithm:
For this Q, there are 3 types of variables:
1. within the k-element group: for reversing
cur, prev, nextnode;
2. within the k-element group: for linking
start, end;
2. between groups
prevend, nexthead(cur will be after the iterations)

The flow is:
1. check whether there is a group (another function returning boolean)
2. do reverse within the group
3. link the groups

Note:
1. In java, you pass the object by pointer. The pointer is copied then passed into a function. 
In the function, you can modify the object which is pointed by the pointer 
but the moving the pointer in the function cannot change the pointer in main()
2. for basic types like boolean, modification in function doesn't change in main()

Syntax:
1. public class
When a class is declared with the public keyword, 
it means this class is accessible and visible to all the classes in all the packages in Java.

2. instantiate a public class
ListNode cur;  

3. Pass Parameters
The statement that "java is always pass-by-value" is technically correct, but it can be very misleading, 
because as you have just witnessed, when you pass an object to a function, the function can modify the contents of the object, 
so it appears that the object has been passed by reference, and not by value. So, what is happening?
Pointers. That's what's happening.
So, the statement "java is always pass-by-value" is true from a strictly technical, 
but ultimately not very useful point of view, according to which objects are never really passed anywhere, 
only pointers to the objects are passed.

4. null in java not NULL
*/
///////////////////////////////////////////////////////////////////////////////////

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start=head, end; 	//for this group
        ListNode cur=head, prev=null, nextnode; 	//during reverse
        ListNode prevend=null;	//between groups
        int count=0;
        boolean group=checkgroup(cur,k);
        if(group == false) return head;
        //reverse the k nodes in the group
        while(group == true){
            //reverse the group
            for(count = 1;count <= k; count++){
                if(prev == null){
                    prev = cur;
                    cur = cur.next;
                }else{
                    nextnode = cur.next;
                    cur.next = prev;
                    prev = cur;
                    cur = nextnode;
                }
        	}
        	end = prev;
        	//link the groups
        	if(prevend == null){
        		head = end;
        	}else{
        		prevend.next = end;
        	}
            start.next = cur;
            //prepare for the next group
            prevend = start;
            prev = null;		//initialized to null for every group
            group = checkgroup(cur, k);
            start = cur;
        }
        return head;
    }
    
    public boolean checkgroup(ListNode cur, int k){
    	//inside, changes won't affect cur in caller
    	boolean group = false;
    	for(int i = 0; i < k; i++) {
        	if(cur == null) return false;
        	else {
        		if(i == k-1) group = true;
        		cur = cur.next;
        	}
        }
        return group;
    }
}
