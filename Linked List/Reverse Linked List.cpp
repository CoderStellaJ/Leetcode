/*
Runtime: 8 ms, faster than 99.77% of C++ online submissions for Reverse Linked List.
Memory Usage: 9.4 MB, less than 5.07% of C++ online submissions for Reverse Linked List.

Algorithm:
Note:
prev == NULL case doesn't have to be seperated. The algorithm can work for all these cases.
*/
////////////////////////////////////////////////////////////
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
    ListNode* reverseList(ListNode* head) {
        ListNode* cur = head;
        ListNode* prev = NULL;
        ListNode* ne;
        while(cur!= NULL) {
            ne = cur->next;
            cur->next = prev;
            prev = cur;
            cur = ne;
        }
        return prev;    //return prev! not cur
    }
};
