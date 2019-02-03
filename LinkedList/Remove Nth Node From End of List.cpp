/*
Algorithm: O(n)

Runtime: 4 ms, faster than 100.00% of C++ online submissions for Remove Nth Node From End of List.
Memory Usage: 757.8 KB, less than 94.47% of C++ online submissions for Remove Nth Node From End of List.
*/
///////////////////////////////////////////////////////////////
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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* prev = NULL; 
        ListNode* cur = head;
        int length = 0;
        int ind;
        while(cur != NULL) {
	        length++;
	        cur = cur->next;
        }
        int count = 1;
        ind = length-n+1;
        //debug
        cout<<ind<<" "<<n<<" "<<length;
        if(head == NULL) return head;
        cur = head;
        while(cur != NULL) {
            if(count == ind) {
                if(prev == NULL) {
                    head = cur->next;
                }else {
                    prev->next = cur->next;
                }
            }
            prev = cur;
            cur = cur->next;
            count++;	
        }
        return head;
    }
};
