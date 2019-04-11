/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Partition List.
Memory Usage: 8.6 MB, less than 74.59% of C++ online submissions for Partition List.

Complexity: O(N)

Algorithm:
1. node1: lst node of left part
2. node2: 1st element of right part
3. node3: last node of right part

Corner cases:
1. no right part
2. no left part
3. has both parts
*/
////////////////////////////////////////////////////////////////////////////////////////////
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
    ListNode* partition(ListNode* head, int x) {
        ListNode* node1 = NULL;  //last node of left part
        ListNode* node2 = NULL;  //first element of right part
        ListNode* node3 = NULL;  //last element of right part
        ListNode* cur = head;
        while(cur != NULL) {
            if(cur->val < x) {
                //left part
                if(node2 == NULL)  {
                    node1 = cur;  //no right part
                    cur = cur->next;
                }
                else if(node1 == NULL){
                    //no left part, change head
                    node3->next = cur->next;
                    cur->next = node2;
                    head = cur;
                    node1 = cur;
                    cur = node3->next;
                }else {
                    //has left part and right part
                    node1->next = cur;
                    node3->next = cur->next;
                    cur->next = node2;
                    node1 = cur;
                    cur = node3->next;
                }
            }else {
                //right part
                if(node2 == NULL) {
                    node2 = cur;
                    node3 = cur;
                }else {
                    node3 = cur;
                }
                cur = cur->next;
            }
        }
        return head;
    }
};
