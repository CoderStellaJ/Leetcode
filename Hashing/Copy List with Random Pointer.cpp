/*
Runtime: 24 ms, faster than 100.00% of C++ online submissions for Copy List with Random Pointer.
Memory Usage: 22.3 MB, less than 5.21% of C++ online submissions for Copy List with Random Pointer.

Algorithm:
First loop: create all the nodes
Second loop: link all the nodes(next and random)
The best way to "find" a node is using hashmap

Note:
You always forget to update cur to cur->next when looping thru a linkedlist

Corner case:
Always check whether key is NULL
cur->next = NULL

Syntax:
std::map<A, B> mymap;
*/
//////////////////////////////////////////////////////////////////////////
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node() {}

    Node(int _val, Node* _next, Node* _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
public:
    Node* copyRandomList(Node* head) {
        std::map<Node*, Node*> mymap;
        Node* cur = head;
        while(cur != NULL) {
            //the first loop, declare all the nodes first
            Node* newnode = new Node(cur->val, NULL, NULL);
            mymap[cur] = newnode;
            cur = cur->next;
        }
        cur = head;
        while(cur != NULL) {
            //the second loop, add all next and random information
            if(cur->next != NULL)   // check whether it's NULL before using it as key
              mymap[cur]->next = mymap[cur->next];
            else 
              mymap[cur]->next = NULL;
            if(cur->random != NULL)
              mymap[cur]->random = mymap[cur->random];
            else
              mymap[cur]->random = NULL;
            cur = cur->next;    //update cur!!!!
        }
        return mymap[head];
        
    }
};
