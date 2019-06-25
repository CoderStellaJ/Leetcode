/*
Runtime: 2 ms, faster than 62.48% of Java online submissions for Fraction to Recurring Decimal.
Memory Usage: 34 MB, less than 100.00% of Java online submissions for Fraction to Recurring Decimal.

Algorithm:
1. determine the sign because there are negative numbers
2. get the int part
3. record down the remainder and quotient:
Note that here the remainder should be the one on the top instead of at the bottom. 
Otherwise, for same remainder, the quotients are not the same 
4. 

Note:
1. calculation type of question: use long type instead of int !

Corner case:
1. 2/1 -> 2 instead of 2.   //take care of the . at the end
2. 1/6 -> 0.1(6)    //rem and div relationship
3. -50/8 -> -6.25   //sign
4. overflow     //use long type
-1/-2147483648
5. 
2147483647/37  -> "58040098.(567)" instead of "58(040098.567)"
*/
/////////////////////////////////////////////////////////////////////
class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    Map<Long, Integer> mymap = new HashMap<>();   //use long type
    StringBuilder ans = new StringBuilder();
    
    //take care of the sign
    int sign = -1;
    if((denominator>0 && numerator >=0) || (denominator<0 && numerator <= 0)) sign = 1;   //determine the sign
    long num = numerator, den = denominator;
    num = Math.abs(num);
    den = Math.abs(den);
    
    long div = num/den;
    ans.append(Long.toString(div)+".");    //can't add remainder here
    long rem = num - div*den;   //remainder should be the one before division
    div = rem*10/den;
    int i = 1;    //record the index after decimal point .
    
    while(rem != 0 && !mymap.containsKey(rem)) {
      ans.append(Long.toString(div));
      mymap.put(rem, i);
      rem = rem*10 - div*den;
      div = rem*10/den;
      i++;
    }
    
    if(rem != 0) {    //recurring case
      int index = mymap.get(rem);
      int dotind = ans.lastIndexOf(".");
      ans.insert(index+dotind,"(");
      ans.append(")");
    }   //for remainder = 0 case, now the div must be 0 because rem is before div, so we just ignore div here
    if(ans.charAt(ans.length()-1) == '.') ans.delete(ans.length()-1, ans.length());   //corner case: no fraction part
    if(sign == -1) ans.insert(0,"-");   //deal with the sign
    return ans.toString();
  }
}
