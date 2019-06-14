/*
Runtime: 1 ms, faster than 98.12% of Java online submissions for String Compression.
Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for String Compression.

Complexity: 
runtime: O(N)
space: O(1)

Algorithm:
1. move the pointer fill
2. a helper function helps to fill in the array
Note: 
1. At the end, the last part is not delt with because we are comparing with the previous elements.
2. Single char sohuld also be filled in!

Syntax:
1. convert int to char
(char)(myint+'0');

Corner case:
1. ["a","a","a","a","a","b"]  -> ["a","5","b"]
*/
///////////////////////////////////////////////////////////////////////////
class Solution {
  public int compress(char[] chars) {
    if(chars.length == 0) return 0;
    int fill = 0, count=1;
    for(int i = 1; i < chars.length; i++) {
      if(chars[i] == chars[i-1]) {
        count++;
      }else{
        if(count != 1) {
          fill = helper(chars, fill, chars[i-1], count);
        }else {
          chars[fill] = chars[i-1];   //filling in the single char!
          fill++;
        }
        count = 1;
      }
    }
    //At the end, deal with the last part because it is not included in the for loop
    if(count != 1) {
          fill = helper(chars, fill, chars[chars.length-1], count);
    }else {
          chars[fill] = chars[chars.length-1];
          fill++;
    }
    count = 1;
    
    return fill;
  }
  
  public int helper(char[] chars, int fill, char c, int count) {
    chars[fill] = c;
    fill++;
    int newfill;
    int num = count, numdigit = 0;
    while(num > 0) {
      numdigit++;
      num/=10;
    }
    newfill = fill + numdigit;
    //reverse the sequence, fill in the latter part is easier
    while(count > 0) {
      chars[fill+numdigit-1] = (char)(count%10+'0');
      count/=10;
      numdigit--;
    }
    return newfill;
  }

}
