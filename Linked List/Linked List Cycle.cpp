////////////////////////////////////////////////////////////////////
/*
Complexity:
Runtime: O(N)
Space: O(1)

Algorithm 2:
Two Pointers
Checking whether there is a loop:
use a fast pointer and a slow pointer. If there is a loop, fast pointer will chase up to slow pointer in the cycle
*/
//////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////
/*
Complexity:
Tuntime: O(N)
Space: O(N)

Algorithm 1:
loop thru the list for once and put each node into hash table.
Every time check whether the node already exists as a key
if no, keep adding current node into table
if yes, there is a loop
until reaching NULL
*/
//////////////////////////////////////////////////////////////////////////
