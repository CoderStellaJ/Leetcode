/*

*/
////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////
/*
Memory Limit Exceeded

Complexity: O(N), iterate through 3 times

Algorithm 1:
Tranform linkedlist to vector so that elements can be accessed by index
*/
////////////////////////////////////////////////////////////////////////
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
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        vector<int> myvec;
        ListNode* cur = head;
        int count = 0;
        while(cur!=NULL) {
            myvec.push_back(cur->val);
            count++;
        }
        int tmp;
        int k = 0;
        while(m+k<n-k){
            tmp = myvec[m+k];
            myvec[m+k] = myvec[n-k];
            myvec[n-k] = tmp;
            k++;
        }
        cur = head;
        k = 0;
        while(cur!=NULL) {
            cur->val = myvec[k];
            k++;
            cur = cur->next;
        }
        return head;
    }
};
