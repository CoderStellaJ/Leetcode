/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Swap Nodes in Pairs.
Memory Usage: 9 MB, less than 100.00% of C++ online submissions for Swap Nodes in Pairs.

Complexity: O(N)

Corner case:
the linkedlist is empty, size is 1, size is 2 etc.

*/
////////////////////////////////////////////////
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
    ListNode* swapPairs(ListNode* head) {
        ListNode* cur = head;
        ListNode* prev;
        ListNode* first;
        ListNode* second;
        ListNode* after;
        int count = 0;
        if(head == NULL) {return head;}
        else if(head->next == NULL) {return head;}
        //length of linkedlist is >= 2
        
        while(cur != NULL) {
            count++;
            if(count == 1) {
                first = cur;
                cur = cur->next;
                continue;
            }else if(count == 2) {
                second = cur;
                cur = cur->next;    //should move cur at this place, otherwise, cur->next becomes first because you changed the sequence
                after = second->next;
                head = second;
                head->next = first;
                first->next = after;
                prev = first;
                
                continue;
            }
            if(count%2==0) {    //the second node
                second = cur;
                cur = cur->next;
                after = second->next;
                prev->next = second;
                second->next = first;
                first->next = after;
                prev = first;
                
            }else {     //the first node
                first = cur;
                cur = cur->next;
            }
            
        }
        return head;
    }
};
