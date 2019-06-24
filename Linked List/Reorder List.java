/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Reorder List.
Memory Usage: 38.7 MB, less than 99.96% of Java online submissions for Reorder List.

Complexity:
runtime: O(N)
space: O(1)

Algorithm:
1. seperate the linkedlist into 2 lists
2. reverse the second list
3. merge the 2 lists
*/
///////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public void reorderList(ListNode head) {
    //seperate into 2 lists
    int count = 0;
    ListNode cur = head;
    while(cur!= null) {
      count++;
      cur = cur.next;
    }
    if(count <= 2) return;
    
    int newstart = (count+1)/2;
    ListNode head2 = head, prev = null;
    for(int index = 1; index <= newstart; index++){
      prev = head2;
      head2 = head2.next;
    }
    prev.next = null;
    //reverse the second list
    cur = head2;
    prev = null;
    ListNode nextnode = null;
    while(cur != null) {
      nextnode = cur.next;
      cur.next = prev;
      prev = cur;
      cur = nextnode;
    }
    head2 = prev;
    //merge the 2 linkedlists
    ListNode cur2 = head2, nextnode2 = cur2;
    cur = head;
    while(cur2 != null) {
      nextnode = cur.next;
      cur.next = cur2;
      nextnode2 = cur2.next;
      cur2.next = nextnode;
      cur2 = nextnode2;
      cur = nextnode;
    }
  }
}
