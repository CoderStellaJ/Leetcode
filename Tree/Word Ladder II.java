/*


Algorithm: BFS + DFS
The basic idea is:
1). Use BFS to find the shortest distance between start and end, tracing the distance of crossing nodes from start node to end node, 
and store node's next level neighbors to HashMap;
2). Use DFS to output paths with the same distance as the shortest distance from distance HashMap: 
compare if the distance of the next level node equals the distance of the current node + 1.

Syntax:
1. convert char array to string
String.valueOf(chararr);
*/
///////////////////////////////////////////////////////////////////////////////
