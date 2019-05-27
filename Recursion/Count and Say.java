/*
Runtime: 1 ms, faster than 99.22% of Java online submissions for Count and Say.
Memory Usage: 33.3 MB, less than 100.00% of Java online submissions for Count and Say.

Algorithm 2:
you keep changing string in the function, so it's better to use StringBuilder

Syntax:
1. stringbuilder
.append(mychar);
mystrbuilder.toString();
*/
//////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String prevStr = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int count = 1;
        for(int i = 0; i < prevStr.length(); i++){
            char c = prevStr.charAt(i);
            if(i!=prevStr.length()-1 && prevStr.charAt(i) == prevStr.charAt(i+1)) count++;
            else{
                ans.append(count).append(prevStr.charAt(i));
                count = 1;
            }
        }
        return ans.toString();
    }
}
/////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 7 ms, faster than 26.12% of Java online submissions for Count and Say.
Memory Usage: 35.3 MB, less than 99.95% of Java online submissions for Count and Say.

Algorithm 1: Recursion
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        else if(n == 2) return "11";
        else if(n == 3) return "21";
        else if(n == 4) return "1211";
        else if(n == 5) return "111221";
        String prevStr = countAndSay(n-1);
        String ans = "";
        int count = 0;
        for(int i = 0; i < prevStr.length(); i++){
            char c = prevStr.charAt(i);
            if(i == 0) count = 1;
            else{
                if(prevStr.charAt(i) == prevStr.charAt(i-1)) count++;
                else{
                    ans = ans + Integer.toString(count) + prevStr.charAt(i-1);
                    count = 1;
                }
            }
        }
        ans = ans + Integer.toString(count) + prevStr.charAt(prevStr.length()-1);
        return ans;
    }
}
