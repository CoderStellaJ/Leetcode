/*
Runtime: 36 ms, faster than 8.16% of Java online submissions for Multiply Strings.
Memory Usage: 41.8 MB, less than 5.01% of Java online submissions for Multiply Strings.

Complexity:
runtime: O(MN)
space: O(N)

Algorithm: Brute force
1. create an array to store the results of multiplications by each digit
2. add those numbers

Corner case:
num1 = "123", num2 = "0" -> "0"
we need to remove extra "0"s in the ans
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
  public String multiply(String num1, String num2) {
    int len1 = num1.length(), len2 = num2.length();
    String[] results = new String[len2];    //stores all the sub results
    for(int i = len2-1; i >= 0; i--) {
      StringBuilder newres = new StringBuilder();
      int multiadd = 0;
      //get the digit in num2
      int digit = num2.charAt(i) - '0';
      for(int j = len1-1; j >= 0; j--) {
        //multiply with num1
        int num1digit = num1.charAt(j) - '0';
        int mul = digit*num1digit + multiadd;
        multiadd = mul/10;
        mul -= multiadd*10;
        newres.insert(0,Integer.toString(mul));
      }
      if(multiadd != 0) newres.insert(0,multiadd);
      //append 0 at the end
      for(int m = i; m < len2-1; m++) {
        newres.append("0");
      }
      results[i] = newres.toString();
    }
    return add(results);
  }
  
  public String add(String[] results) {
    StringBuilder ans = new StringBuilder("0");
    int add = 0;
    for(int i = 0; i < results.length; i++) {
      String str1 = ans.toString();
      String str2 = results[i];
      ans = new StringBuilder();
      add = 0;
      //add str1 and str2
      int len1 = str1.length(), len2 = str2.length();
      int m = len1-1, n = len2-1;
      while(m >= 0 && n >= 0) {
        int num1 = str1.charAt(m)-'0';
        int num2 = str2.charAt(n)-'0';
        int res = num1+num2+add;
        if(res >= 10) {
          add = 1;
          res -= 10;
        }else add = 0;
        ans.insert(0,res);
        m--;
        n--;
      }
      while(m >= 0){
        int num1 = str1.charAt(m)-'0';
        int res = num1+add;
        if(res >= 10) {
          add = 1;
          res -= 10;
        }else add = 0;
        ans.insert(0,res);
        m--;
        n--;
      }
      while(n >= 0) {
        int num2 = str2.charAt(n)-'0';
        int res = num2+add;
        if(res >= 10) {
          add = 1;
          res -= 10;
        }else add = 0;
        ans.insert(0,res);
        m--;
        n--;
      }
      if(add == 1) ans.insert(0,"1");
    }
    int index = 0;
    while(index < ans.length() && ans.charAt(index) == '0') index++;
    if(index == ans.length()) return "0";     //remove extra 0s
    else return ans.substring(index).toString();
  }
}
