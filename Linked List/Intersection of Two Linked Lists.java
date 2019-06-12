/*
Runtime: 1 ms, faster than 97.23% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 39 MB, less than 31.94% of Java online submissions for Intersection of Two Linked Lists.

Complexity:
runtime: O(N)
space: O(1)

Algorithm: 2 pointers
1. When pA reaches the end of a list, then redirect it to the head of B; 
similarly when pB reaches the end of a list, redirect it the head of A.
2. If at any point pA meets pB, then pA/pB is the intersection node.
3. To see why the above trick would work, consider the following two lists: A = {1,3,5,7,9,11} and B = {2,4,9,11}, 
which are intersected at node '9'. Since B.length (=4) < A.length (=6), pB would reach the end of the merged list first, 
because pB traverses exactly 2 nodes less than pA does. 
By redirecting pB to head A, and pA to head B, we now ask pB to travel exactly 2 more nodes than pA would. 
So in the second iteration, they are guaranteed to reach the intersection node at the same time.

*/
///////////////////////////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA, curB = headB;
    while(true){
      if(curA == curB) return curA;
      if(curA == null) {
        curA = headB;
        curB = curB.next;
      }else if(curB == null) {
        curB = headA;
        curA = curA.next;
      }else{
        curA = curA.next;
        curB = curB.next;
      }
    }
  }
}
//////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 15.91% of Java online submissions for Intersection of Two Linked Lists.
Memory Usage: 39.9 MB, less than 12.00% of Java online submissions for Intersection of Two Linked Lists.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 2: HashSet
*/
///////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
      val = x;
      next = null;
  }
}

public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    Set<ListNode> myset = new HashSet<ListNode>();
    if(headA == null || headB == null) return null;
    ListNode curA = headA, curB = headB;
    //iterate through the list A
    while(curA != null){
      myset.add(curA);
      curA= curA.next;
    }
    while(curB != null) {
      if(myset.contains(curB)) return curB;
      curB = curB.next;
      
    }
    return null;
  }
}
////////////////////////////////////////////////////////////////////////////////////
/*
This algorithm is WRONG!
because at the intersection, there are 2 nodes whose next is the same node
You can't reverse the 2 lists!

Complexity:
runtime: O(N)
space: O(1)

Algorithm: Reverse 2 lists and iterate from the end
Note:
when reversing a linkedlist
the head.next should be set to null
so prev == null case doesn't have be delt seperately.
*/
///////////////////////////////////////////////////////////////////////////////////////
