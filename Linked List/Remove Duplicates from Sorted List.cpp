/*
Runtime: 12 ms, faster than 100.00% of C++ online submissions for Remove Duplicates from Sorted List.
Memory Usage: 9.1 MB, less than 77.81% of C++ online submissions for Remove Duplicates from Sorted List.

Complexity: O(N)

Algorithm:
iterate through the list.
1. compare current value with previous value to determine whether it's duplicate.
2. consider the case that cur is head
Note:
when you remove an element, prev doesn't move forward.

Compare with Remove Duplicates from Sorted List II:
1. while loop conditions are different. 
For this question, while(cur != NULL) because you just need to compare it with previous value
But for II question, while(cur->next != NULL) because it has to remove all duplicate values and is compared with the next element
2. After the while loop
II question needs to deal with the last element for special consideration as it's not covered in while loop
3. In the loop
For this question, we just need to consider whether prev exists
But for II question, both prev and value may not refer to the same node(when the last duplicate node is being processed)

Summary:
In each case, the following variables are possibly updated
1. head
2. cur
3. prev
4. value

*/
//////////////////////////////////////////////////////////////////////////////////////////////////
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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode* cur = head;
        ListNode* prev = NULL;
        int value;
        while(cur!=NULL) {
            if(prev == NULL) {
                //first iteration
                value = cur->val;
                prev = cur;
                cur = cur->next;
            }else {
                if(cur->val == value) {
                    //duplicate number
                    if(cur == head) {
                        prev = cur;
                        head = cur->next;
                    }else {
                        //remove current element
                        prev->next = cur->next;
                    }
                }else {
                    //not duplicate
                    value = cur->val;
                    prev = cur;
                }
                cur = cur->next;
            }
        }
        return head;
    }
};
