/*
Runtime: 2 ms, faster than 99.44% of Java online submissions for Find the Closest Palindrome.
Memory Usage: 35.2 MB, less than 99.85% of Java online submissions for Find the Closest Palindrome.

Complexity:
runtime: O(N)
space: O(N)

https://leetcode.com/problems/find-the-closest-palindrome/solution/
Algorithm:
1. directly replicate the left aprt to the left part to form a new palindrome
2. When center is 0 or 9, -1 or +1 to left part then replicate the left part
3. compare the 3 differences
Note: 
1. here we need to use long for diff
2. left part includes center; 
3. cannot convert left part to int then +/-, parse the string one by one. Otherwise: case "11" fails

Syntax:
1. convert long to int
Long.parseLong(mylong)
2. LONG.MAX_VALUE
3. convert string to long
Long.parseLong(mystr)
Integer.parseInt(mystr) has NumberFormatException when it exceeds value of max int.
4. Math.abs() can accept long type
5. change a char in stringbuilder
sb.setCharAt(0, 'J');
str.insert(8, 's');
public StringBuilder delete(int start, int end)
6. cast int to char
(char)(mychar-1)

Corner case:
"11" -> "9"
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
    public String nearestPalindromic(String n) {
    	if(n.length() == 0) return "";
        if (n.length() == 1) return Integer.toString(Integer.parseInt(n)-1);		
        //corner case: need to be addressed seperately
        //Because in -1, you set mid to '9'
        String res1,res2,res3;
        long diff1,diff2,diff3;
        int index = (n.length()-1)/2;	//(start,mid]
        //reverse the original value
        res1 = mirror(n);
        diff1 = Math.abs(Long.parseLong(res1) - Long.parseLong(n));
        diff1 = (diff1 == 0)?Long.MAX_VALUE:diff1;
        // + 1
        StringBuilder sb = new StringBuilder(n);
        int i = index;
        while(i>=0 && sb.charAt(i)=='9'){
        	sb.setCharAt(i,'0');
        	i--;
        }
        if(i < 0) sb.insert(0,'1');
        else sb.setCharAt(i,(char)(sb.charAt(i)+1));
        res2 = mirror(sb.toString());
        diff2 = Math.abs(Long.parseLong(res2) - Long.parseLong(n));
        diff2 = (diff2 == 0)?Long.MAX_VALUE:diff2;
        // - 1
        StringBuilder sb2 = new StringBuilder(n);
        i = index;
        while(i>=0 && sb2.charAt(i)=='0'){
        	sb2.setCharAt(i,'9');
        	i--;
        }
        if(i == 0 && sb2.charAt(0) == '1') {
    		sb2.delete(0,1);		//remove the first '0'
    		int mid = (sb2.length() - 1) / 2;
    		sb2.setCharAt(mid,'9');
        	//e.g. 1000 -> 0900 -> 900 -> 990(set new mid to 9)! -> 999
        	
        }else sb2.setCharAt(i,(char)(sb2.charAt(i)-1));
        res3 = mirror(sb2.toString());
        diff3 = Math.abs(Long.parseLong(res3) - Long.parseLong(n));
        diff3 = (diff3 == 0)?Long.MAX_VALUE:diff3;
        //comparison
        if(diff3 <= diff2 && diff3 <= diff1) return res3;
        else if(diff1 <= diff2 && diff1 <= diff3) return res1;
        else return res2;
    }
    public String mirror(String n){
    	int index = n.length()/2;
    	StringBuilder mybuild = new StringBuilder(n.substring(0,index));
    	if(n.length()%2 == 0){
    		return mybuild.toString()+mybuild.reverse().toString();
    	}else {
    		return mybuild.toString()+n.charAt(index)+mybuild.reverse().toString();
    	}
    }
}

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
