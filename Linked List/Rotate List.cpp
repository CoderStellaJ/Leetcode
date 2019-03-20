/*
Runtime: 12 ms, faster than 99.50% of C++ online submissions for Rotate List.
Memory Usage: 10.2 MB, less than 51.67% of C++ online submissions for Rotate List.

Complexity: O(N)

Algorithm:
scan though the list to know the size. And then calculate which node is the newhead
Note:
During the first scan, you can record down the end of the list to avoid duplicate iterations.

Corner case:
1. head is NULL, the list is empty
2. The initial head is still head(indexStart = 0)
*/
/////////////////////////////////////////////////////////////////////////////////
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
    ListNode* rotateRight(ListNode* head, int k) {
        //size of linkedlist
        if(head == NULL) return head;
        int len = 0;	
        ListNode* cur = head;
        ListNode* end;
        while(cur != NULL) {		//O(N)
            len++;
            if(cur->next == NULL) {
                end = cur;    //Nice way to increase speed
            }
            cur = cur->next;
        }
        //actual number of rotations
        k = k%len;

        //current indexStart-th node will be the new head
        int indexStart = (len - k)%len;
        if(indexStart == 0) return head;
        cur = head;
        for(int i = 0; i < indexStart-1; i++) {
            cur = cur->next;
        }
        ListNode* node = cur->next;
        cur->next = NULL;
        ListNode* newhead = node;
        end->next = head;
        return newhead;
    }
};
