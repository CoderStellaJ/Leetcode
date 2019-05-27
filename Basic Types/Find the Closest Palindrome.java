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
3. convert string to long
Long.parseLong(mystr)
Integer.parseInt(mystr) has NumberFormatException when it exceeds value of max int.
4. Math.abs() can accept long type

Corner case:
"11" -> "9"
*/
/////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Time Limit Exceeded

Algorithm 1:
The simplest solution is to consider every possible number smaller than the given number nn, 
starting by decrementing 1 from the given number and go on in descending order. 
Similarly, we can consider every possible number greater than nn starting by incrementing 1 from the given number 
and going in ascending order. We can continue doing so in an alternate manner till we find a number which is a palindrome.
*/
//////////////////////////////////////////////////////////////////////////////////////////////////////////
