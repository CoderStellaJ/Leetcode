/*
Algorithm: O(n)

Runtime: 4 ms, faster than 100.00% of C++ online submissions for Remove Nth Node From End of List.
Memory Usage: 757.8 KB, less than 94.47% of C++ online submissions for Remove Nth Node From End of List.

Note: How to do it in one pass?
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

////////////////////////////////////////////////////////////
//One pass algorithm
/*
The above algorithm could be optimized to one pass. Instead of one pointer, we could use two pointers. 
The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list. 
Now, both pointers are exactly separated by nn nodes apart. We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. 
The second pointer will be pointing at the nnth node counting from the last. 
We relink the next pointer of the node referenced by the second pointer to point to the node's next next node.
*/


