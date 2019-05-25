/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Integer to English Words.
Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Integer to English Words.

Algorithm 2:
Hashmap initialization takes lots of time. So just use a function to replace it to accelerate the program

Syntax:
1. 14: Fourteen; 40: Forty; 0: Zero (first letter uppercase)
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String numberToWords(int num) {
      if(num == 0) return "zero";
      if(num < 10) {
        return dict(num);
      }else if(num < 100) {
        if(num <= 20) return dict(num);
        else {
          if(num%10 == 0) return dict((num/10)*10);
          return dict((num/10)*10) + " " + dict(num%10);
        }
      }else if(num < 1000){
        if(num%100 == 0) return numberToWords(num/100) + " Hundred";
        return numberToWords(num/100) + " Hundred " + numberToWords(num%100);
      }else if(num < 1000000) {
        if(num % 1000 == 0) return numberToWords(num/1000) + " Thousand";
        return numberToWords(num/1000) + " Thousand " + numberToWords(num%1000);
      }else if(num < 1000000000) {
        if(num % 1000000 == 0) return numberToWords(num/1000000) + " Million"; 
        return numberToWords(num/1000000) + " Million " + numberToWords(num%1000000);
      }else {
        if(num % 1000000000 == 0) return numberToWords(num/1000000000) + " Billion";
        return numberToWords(num/1000000000) + " Billion " + numberToWords(num%1000000000);
      }
    }
  
    public String dict(int num) {
      switch(num) {
        case 0: return "Zero";
        case 1: return "One";
        case 2: return "Two"; 
        case 3: return "Three";
        case 4: return "Four";
        case 5: return "Five";
        case 6: return "Six";
        case 7: return "Seven";
        case 8: return "Eight";
        case 9: return "Nine";
        case 10: return "Ten";    
        case 11: return "Eleven";
        case 12: return "Twelve";
        case 13: return "Thirteen";
        case 14: return "Fourteen";
        case 15: return "Fifteen";    
        case 16: return "Sixteen";    
        case 17: return "Seventeen";    
        case 18: return "Eighteen";    
        case 19: return "Nineteen";    
        case 20: return "Twenty";    
        case 30: return "Thirty";    
        case 40: return "Forty";    
        case 50: return "Fifty";    
        case 60: return "Sixty";    
        case 70: return "Seventy";    
        case 80: return "Eighty";    
        case 90: return "Ninety";    
        default: return "";
      }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 5 ms, faster than 7.17% of Java online submissions for Integer to English Words.
Memory Usage: 35.2 MB, less than 99.98% of Java online submissions for Integer to English Words.

Algorithm 1: Recursion
Hashmap stores mapping for numbers <=20 and all x0
Use recursion to solve sub problems

Note:
1. cannot simply consider one digit at a time because number "12" has its own expression.
2. Call numberToWords() function instead of getting from hashmap for sub problem!

Syntax:
1. initialize a hashmap
Map<String,String> test = new HashMap<String, String>(){{put("test","test"); put("test","test");}};
2. get a value from key in a map
mymap.get(mykey);
3. string.trim() has return type String
*/
////////////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public String numberToWords(int num) {
      if(num == 0) return "Zero";
      Map<Integer, String> mymap = new HashMap<Integer, String>(){{
        put(0, "Zero");
        put(1, "One");
        put(2, "Two");
        put(3, "Three");
        put(4, "Four");
        put(5, "Five");
        put(6, "Six");
        put(7, "Seven");
        put(8, "Eight");
        put(9, "Nine");
        put(10, "Ten");
        put(11, "Eleven");
        put(12, "Twelve");
        put(13, "Thirteen");
        put(14, "Fourteen");
        put(15, "Fifteen");
        put(16, "Sixteen");
        put(17, "Seventeen");
        put(18, "Eighteen");
        put(19, "Nineteen");
        put(20, "Twenty");
        put(30, "Thirty");
        put(40, "Forty");
        put(50, "Fifty");
        put(60, "Sixty");
        put(70, "Seventy");
        put(80, "Eighty");
        put(90, "Ninety");
        //put(100, "Hundred");
        //put(1000, "Thousand");
        //put(1000000, "Million");
        //put(1000000000, "Billion");
      }};
      String res = "";
      if(num < 10) {
        return mymap.get(num);
      }else if(num < 100) {
        if(num <= 20) return mymap.get(num);
        else {
          if(num%10 == 0) return mymap.get((num/10)*10);
          return mymap.get((num/10)*10) + " " + mymap.get(num%10);
        }
      }else if(num < 1000){
        if(num%100 == 0) return numberToWords(num/100) + " Hundred";
        return numberToWords(num/100) + " Hundred " + numberToWords(num%100);
      }else if(num < 1000000) {
        if(num % 1000 == 0) return numberToWords(num/1000) + " Thousand";
        return numberToWords(num/1000) + " Thousand " + numberToWords(num%1000);
      }else if(num < 1000000000) {
        if(num % 1000000 == 0) return numberToWords(num/1000000) + " Million"; 
        return numberToWords(num/1000000) + " Million " + numberToWords(num%1000000);
      }else {
        if(num % 1000000000 == 0) return numberToWords(num/1000000000) + " Billion";
        return numberToWords(num/1000000000) + " Billion " + numberToWords(num%1000000000);
      }
    }
}
