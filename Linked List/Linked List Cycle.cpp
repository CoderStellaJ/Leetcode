////////////////////////////////////////////////////////////////////
/*
Runtime: 12 ms, faster than 98.76% of C++ online submissions for Linked List Cycle.
Memory Usage: 9.9 MB, less than 15.09% of C++ online submissions for Linked List Cycle.

Complexity:
Runtime: O(N)
Space: O(1)

Algorithm 2:
Two Pointers
Checking whether there is a loop:
use a fast pointer and a slow pointer. If there is a loop, fast pointer will chase up to slow pointer in the cycle

Syntax:
cur->next->next without () can work properly
*/
//////////////////////////////////////////////////////////////////
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        ListNode* fast = head;
        ListNode* slow = head;
        //the slow pointer moves 1 step 
        //the fast pointer moves 2 steps
        bool iscycle = false;
        while(fast != NULL) { 
            if(fast->next == NULL)    //check whether it's NULL before calling its next
                break;
            else{
                fast = fast->next->next;
            }
            if(fast == slow) {
                iscycle = true;
                break;
            }
            slow = slow->next;
        }
        return iscycle;
    }
};
//////////////////////////////////////////////////////////////////////
/*
Complexity:
Tuntime: O(N)
Space: O(N)

Algorithm 1:
loop thru the list for once and put each node into hash table.
Every time check whether the node already exists as a key
if no, keep adding current node into table
if yes, there is a loop
until reaching NULL
*/
//////////////////////////////////////////////////////////////////////////
