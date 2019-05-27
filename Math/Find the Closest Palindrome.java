/*
https://leetcode.com/problems/find-the-closest-palindrome/solution/
Algorithm:
1. directly replicate the left aprt to the left part to form a new palindrome
2. When center is 0 or 9, -1 or +1 to left part then replicate the left part
3. compare the 3 differences

Note: 
1. here we need to use long for diff
2. left part includes center; for even length, left part includes the one o nthe right of center
3. cannot convert left part to int then +/-, parse the string one by one. Otherwise: case "11" fails

Syntax:
1. convert long to int
Long.parseLong(mylong)
2. LONG.MAX_VALUE

Corner case:
"11" -> "9"
*/
/////////////////////////////////////////////////////////////////////////////
