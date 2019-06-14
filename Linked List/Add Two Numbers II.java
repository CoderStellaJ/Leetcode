/*
Complexity:
runtime : O(N)
space: O(N)

Algorithm 2: Stack without reversing the linkedlist
Under the condition that the original linkedlist cannot be modified,
we can use stack to help reverse the sequence
*/
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 2 ms, faster than 99.96% of Java online submissions for Add Two Numbers II.
Memory Usage: 44.9 MB, less than 73.96% of Java online submissions for Add Two Numbers II.

Complexity: 
runtime: O(N)
space: O(N)   can be optimized to O(1) by directly changing value to the longer linkedlist

Algorithm 1:
1. Reverse the 2 lists
2. add one by one and then create a new linkedlist
*/
//////////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    //reverse 2 lists
    ListNode cur1 = l1, cur2 = l2, prev1 = null, prev2 = null, nextnode1, nextnode2;
    while(cur1!=null){
      nextnode1 = cur1.next;
      cur1.next = prev1;
      prev1 = cur1;   //rememebr to update the prev node
      cur1 = nextnode1;
    }
    while(cur2!=null){
      nextnode2 = cur2.next;
      cur2.next = prev2;
      prev2 = cur2;
      cur2 = nextnode2;
    }
    //addition
    ListNode head = null, node=null, prev=null;
    cur1 = prev1; cur2 = prev2;
    int add = 0, result = 0;
    
    while(cur1 != null && cur2 != null){
      result = cur1.val + cur2.val + add;
      if(result >= 10) {
        result -= 10;
        add = 1;
      }else {
        add = 0;
      }
      node = new ListNode(result);
      node.next = prev;
      prev = node;
      cur1 = cur1.next;
      cur2 = cur2.next;
    }
    
    while(cur1 != null) {
      result = cur1.val + add;
      if(result >= 10) {
        result -= 10;
        add = 1;
      }else {
        add = 0;
      }
      node = new ListNode(result);
      node.next = prev;
      prev = node;
      cur1 = cur1.next;
    }
    
    while(cur2 != null) {
      result = cur2.val + add;
      if(result >= 10) {
        result -= 10;
        add = 1;
      }else {
        add = 0;
      }
      node = new ListNode(result);
      node.next = prev;
      prev = node;
      cur2 = cur2.next;
    }
    
    if(add == 1) {    //rememebr to add a new node
      node = new ListNode(1);
      node.next = prev;
    }
    
    head = node;
    return head;
  }

}
