/*
Runtime: 3 ms, faster than 97.39% of Java online submissions for Sort List.
Memory Usage: 40.3 MB, less than 89.77% of Java online submissions for Sort List.

Complexity: 
runtime: O(nlogn)
space: O(1)

Algorithm: Linkedlist mergesort
Several elements to take note of during merge: cur1, cur2, prev1 and newhead 
*/
///////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    if(head == null) return null;
    if(head.next == null) return head;
    int count = 0;
    ListNode cur = head;
    while(cur != null){
      count++;
      cur = cur.next;
    }
    cur = head;
    for(int i = 0; i < count/2-1; i++) {
      cur = cur.next;
    }
    ListNode head2=cur.next, head1=head;
    cur.next = null;
    head1 = sortList(head1);
    head2 = sortList(head2);
    ListNode newhead=head1, cur1=head1, cur2=head2, prev1=null;
    while(cur1 != null && cur2 != null) {
      //merge
      if(cur1.val > cur2.val){
        if(prev1 == null){
          newhead = cur2;
          prev1 = cur2;     //assign to prev1 before changing cur2
          cur2 = cur2.next;
          newhead.next = cur1;
        }else{
          prev1.next = cur2;
          cur2 = cur2.next;
          prev1.next.next = cur1;
          prev1 = prev1.next;
        }
      }else{
        prev1 = cur1;
        cur1 = cur1.next;
      }
    }
    
    if(cur1 == null){
      prev1.next = cur2;
    }
    return newhead;
  }
}
