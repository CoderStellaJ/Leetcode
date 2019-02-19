Complexity: O(N)

Runtime: 12 ms, faster than 100.00% of C++ online submissions for Merge Two Sorted Lists.
Memory Usage: 10.1 MB, less than 100.00% of C++ online submissions for Merge Two Sorted Lists.

Note:
1. pointers should be initialized to be NULL, otherwise there will be runtime error.
2. remember to move the pointers to next.
3. modify ishead when newhead is assigned.

Corner case:
At least one of the list is empty

Debug:
cout<<"mark X"<<endl; to know the flow in program

///////////////////////////////////////////////////////////////////////////
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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* cur1 = l1;
        ListNode* cur2 = l2;
        bool ishead = true;
        ListNode* newhead = NULL;   //initialized to be NULL
        ListNode* cur = NULL;
        //initialize newhead
        while(cur1 != NULL && cur2 != NULL) {
            if(ishead == true) {
                if(cur1->val < cur2->val) {
                    newhead = cur1;
                    cur1 = cur1->next;
                    //cout<<"mark 1"<<endl;
                }else {
                    newhead = cur2;
                    cur2 = cur2->next;
                    //cout<<"mark 2"<<endl;
                }
                cur = newhead;
                ishead = false;   //change it to false!
            }else {
                if(cur1 -> val < cur2 -> val) {
                    cur->next = cur1;
                    cur1 = cur1->next;
                    //cout<<"mark 3"<<endl;
                }else {
                    cur->next = cur2;
                    cur2 = cur2->next;
                    //cout<<"mark 4"<<endl;
                }
                cur = cur->next;
            }	
        }
        while(cur1 != NULL) {
            if(ishead == true){   //always consider the case when current pointer is head!
                newhead =cur1;
                cur = newhead;
                ishead = false;
            }else {
                cur->next = cur1;
                cur = cur->next;    //move cur after assign value to cur->next!!!
                //cout<<"mark 5"<<endl;
            }
            cur1 = cur1->next;
        }
        while(cur2 != NULL) {
             if(ishead == true){
                newhead =cur2;
                cur = newhead;
                ishead = false;
            }else {
                cur->next = cur2;
                cur = cur->next;
                //cout<<"mark 5"<<endl;
            }
            cur2 = cur2->next;
        }
        
        return newhead;
    }
};
