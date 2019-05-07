/*
Runtime: 4 ms, faster than 100.00% of C++ online submissions for Reverse Linked List II.
Memory Usage: 8.8 MB, less than 74.16% of C++ online submissions for Reverse Linked List II.

Complexity: O(N)

Algorithm:
1. several positions need ListNode* to denote:
the start of the reversed list
the end of the unreversed list
2. conisder the case that m==n, no actual reverse in this case
3. when count is not in range [m,n], just normal iteration
4. when count is in range [m,n], reverse list foundamental algorithm! 

Corner cases:
1. one element in linkedlist
2. two elements in the linkedlist
2. m == n
3. m = 1
4. n = end
*/
////////////////////////////////////////////////////////////////////////////////////
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
        ListNode* previous = NULL;  //for unreversed last node
        ListNode* prev = NULL;      //for prev node when looping thru
        ListNode* cur = head;      
        ListNode* ne;               //for next node
        ListNode* revstart;          //the first node of the reversed list
        int count = 0;
        while(cur != NULL) {
            count++;
            if(count == m) {
                previous = prev;
                revstart = cur;
            }
            if(count > m && count <= n) {
                //reverse this part of the linkedlist
                ne = cur->next;
                cur->next = prev;
                prev = cur;
                cur = ne;
            }else {
                //normally iterate thru the linkedlist
                prev = cur;
                cur = cur->next;
            }
            if(count == n && m!=n) {        //condition: m != n, otherwise, there is no reverse
                revstart->next = ne;
                if(previous == NULL) {
                    return prev;        //here, return prev not cur!!!!
                }else {
                    previous->next = prev;
                    break;      //can break now
                }
            }
        }
        return head;
    }
};
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
