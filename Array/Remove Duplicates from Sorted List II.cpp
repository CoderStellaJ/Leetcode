/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Remove Duplicates from Sorted List II.
Memory Usage: 8.9 MB, less than 95.15% of C++ online submissions for Remove Duplicates from Sorted List II.

Complexity: O(N)

Algorithm 2: Less corner cases compared with algorithm 1
1. use prev to record the starting location of duplications
2. iterate until no duplicate, then modify prev->next = cur->next
3. Always consider the case when prev = NULL when head is changed.

*/
//////////////////////////////////////////////////////////////////////////////////////////////////////
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
        if(head == NULL || head->next == NULL) return head;
        ListNode* cur = head;
        ListNode* prev = NULL;
        bool rem = false;
        while(cur->next != NULL){
            //if it's duplicate
            if(cur->val == (cur->next)->val) {
                rem = true;
                cur = cur->next;
            }else if(rem == true) {
                rem = false;
                if(prev == NULL) {
                    head = cur->next;
                    cur = cur->next;
                }else {
                    prev->next = cur->next;
                    cur = cur->next;
                }
            }else{
                //no duplicate
                prev = cur;
                cur = cur->next;
            }
        }
        //last element
        if(rem == true) {
            if(prev == NULL)
                return NULL;
            else {
                prev->next = NULL;
            }
        }
        return head;
    }
};
/////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 8 ms, faster than 100.00% of C++ online submissions for Remove Duplicates from Sorted List II.
Memory Usage: 9.2 MB, less than 32.04% of C++ online submissions for Remove Duplicates from Sorted List II.

Complexity: O(N)

Algorithm 1:
1. compare current with its next element to check whether cur is duplicate
2. compare cur with previous element value to check whether it's duplicate
3. Take care of the case that cur is head
*/
////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        if(head == NULL || head->next == NULL) return head;
        ListNode* cur = head;
        ListNode* prev = NULL;
        int value = cur->val;
        while(cur->next != NULL){
            //if it's duplicate
            if(cur->val == (cur->next)->val) {                
                value = cur->val;
                if(cur == head) {
                    head = cur->next;
                    prev = cur;
                    cur = cur->next;
                }else {
                    prev->next = cur->next;
                    cur = cur->next;
                }
            }else if(prev != NULL && cur->val == value) {
                if(cur == head) {   //need to consider whether it's head
                    prev = cur;
                    head = cur->next;
                }else {
                    prev->next = cur->next;
                    cur = cur->next;
                }
            }else {
                //not duplicate
                prev = cur;
                cur = cur->next;
            }
        }
        //last element
        if(cur->val == value) {
            if(cur == head)
            return NULL;
            else {
                prev->next = NULL;
            }
        }
        return head;
    }
};


