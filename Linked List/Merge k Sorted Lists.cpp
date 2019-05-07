/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 28 ms, faster than 92.03% of C++ online submissions for Merge k Sorted Lists.
Memory Usage: 11.2 MB, less than 98.90% of C++ online submissions for Merge k Sorted Lists.

https://leetcode.com/problems/merge-k-sorted-lists/solution/
Algorithm 4:
Priority Queue: O(Nlogk)
1. compare the first element in each list O(logk)
2. for all N nodes

Space:
O(N) for new list
O(k) for priority queue

Syntax:
1. priority queue:
std::priority_queue<int> q;
q.push(n)
q.pop()   //pop out the largest element, the return type is void
q.top()   //return the value of the largest

2. if you want it to be Min-priority queue/ Max-priority queue:
std::priority_queue<int, std::vector<int>, std::greater<int> > min_que;
std::priority_queue<int, std::vector<int>, std::less<int> > max_que;
std::priority_queue<ListNode*, vector<ListNode*>, Comp> min_que;
Note:
Comp is a struct/class with operator() 
struct Comp{
        bool operator()(ListNode* node1, ListNode* node2){
            return (node1->val) > (node2->val);
        }
    }; 
    
Corner case:
1. lists is NULL
2. any one of the ListNode* is NULL
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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if (lists.empty()) return NULL;
        std::priority_queue<ListNode*, vector<ListNode*>, Comp> min_que;
        ListNode* head = NULL;
        ListNode* prev;
        ListNode* smallest;
        for(ListNode* node : lists){
            if(node != NULL)
                min_que.push(node);
        }
        while(!min_que.empty()) {
            smallest = min_que.top();
            min_que.pop();
            if(smallest -> next != NULL) {
                min_que.push(smallest->next);
            }
            if(head == NULL) {
                head = smallest;
                prev = head;
            }else{
                prev->next = smallest;
                prev = prev->next;
            }
        }
        return head;
    }
  
    struct Comp{
        bool operator()(ListNode* node1, ListNode* node2){
            return (node1->val) > (node2->val);
        }
    };  
};

///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 108 ms, faster than 30.65% of C++ online submissions for Merge k Sorted Lists.
Memory Usage: 10.9 MB, less than 99.75% of C++ online submissions for Merge k Sorted Lists.

Algorithm 3:
Merge with Divide And Conquer O(Nlogk)
Choose 2 lists to merge, then left with k/2 lists
...

Space: O(1)

Syntax:
1. pass pointer by reference
You would want to pass a pointer by reference 
if you have a need to modify the pointer rather than the object that the pointer is pointing to.

So it's not recommended. A better way is to return the modified node and resign it.

Special Notes:
1. prev is NULL or not
everytime you use prev->nect, consider whether prev is NULL
2. every time check whether cur and prev are moved to next
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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.empty()) return NULL;
        while(lists.size() > 1) {
            for(int i = 0; i < lists.size()/2; i++) {
                lists[i] = mergelists(lists[i], lists[i+1]);
                lists.erase(lists.begin()+(i+1));
            }
        }
        return lists[0];
    }
    ListNode* mergelists(ListNode* node1, ListNode* node2) {
        ListNode* prev = NULL;
        ListNode* cur1 = node1;
        ListNode* cur2 = node2;
        while(cur1 != NULL && cur2 != NULL) {
            if(cur1->val <= cur2->val) {
                prev = cur1;
                cur1 = cur1->next;
            }else {
                if(prev == NULL) {
                    //it's the start of list 1
                    node1 = cur2;
                    cur2 = cur2->next;
                    node1->next = cur1;
                    prev = node1;
                }else {
                    prev->next = cur2;
                    cur2 = cur2->next;
                    (prev->next)->next = cur1;
                    prev = prev->next;
                }
            }
        }
        while(cur2 != NULL) {
            if(prev != NULL) {
                prev->next = cur2;
                prev = cur2;
                cur2 = cur2->next;    
            }else {
                return node2;
            }
            
        }
        return node1;
    }
    
};

///////////////////////////////////////////////////////////////////////////////////////
/*
Algorithm 2:
Compare one by one: O(kN)
1. compare the first element of each list: O(k)
2. choose the smallest element and add it into a new list, replace it with its next element O(1)
3. iterate thru all nodes O(N) 

Algorithm 1:
Brute-force: O(NlogN)
1. collect all nodes O(N)
2. sort all nodes O(NlogN)
*/
/////////////////////////////////////////////////////////////////////////////////
