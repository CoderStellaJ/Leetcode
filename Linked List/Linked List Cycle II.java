/*
linkedlist: pointers are common tricks to use

assume:
before circle start length: x
they meet at the distance y of the start of the circle: y
the circle length is y+z
fast: 2t, slow t
we can conclude that t = x+y, 2t = x+y+z+y => z = x
so we move slow pointer to the head and then move both pointers one by one to meet at the start of the circle.

time: O(N)
spcae: O(1)

Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle II.
Memory Usage: 39.4 MB, less than 6.32% of Java online submissions for Linked List Cycle II.
*/


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast != null && slow != null) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(slow == fast) {
                    break;
                }
            } else {
                return null;
            }
        }
        
        slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
        
    }
}