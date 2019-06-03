/*
Runtime: 1 ms, faster than 96.68% of Java online submissions for Palindrome Linked List.
Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Palindrome Linked List.

Complexity:
runtime: O(N)
space: O(1)

Algorithm:
reverse the first half of the linked list 
and then loop through both halves
Note:
count the length of the linkedlist: len initialized to 0

Corner case:
1. len = 0 and len = 1 because you have left and right which is not applicable to single node
*/
/////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
      ListNode cur = head, prev=null, nextnode, right, left;
      int len=0;
      while(cur != null) {
        cur = cur.next;
        len++;
      }
      if(len == 1 || len == 0) return true;
      cur = head;
      for(int i = 0; i <len/2 ; i++) {
        if(prev==null) {
          prev = cur;
          cur = cur.next;
        }else{
          nextnode = cur.next;
          cur.next = prev;
          prev = cur;
          cur = nextnode;
        }
      }
      if(len%2 == 0) {
        //even number of nodes
        left = prev;
        right = cur;
      }else {
        //odd number of nodes
        left = prev;
        right = cur.next;
      }
      while(right!=null) {
        if(left.val != right.val) return false;
        left = left.next;
        right = right.next;
      }
      return true;
    }
}
