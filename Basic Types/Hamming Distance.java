/*
Algorithm 2: Built-in function
e.g.
Integer.bitCount(num);
a = 10(10) = 1010(2)  function will return 2;
*/
///////////////////////////////////////////////////////////////////////
public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
///////////////////////////////////////////////////////////////////////
/*
Runtime: 5 ms, faster than 10.99% of Java online submissions for Hamming Distance.
Memory Usage: 34 MB, less than 17.62% of Java online submissions for Hamming Distance.

Complexity:
runtime: O(N)
space:O(N)

Algorithm 1:
1. convert to binary
2. compare the bits and count
*/
////////////////////////////////////////////////////////////////////////
class Solution {
  public int hammingDistance(int x, int y) {
    List<Integer> bi1 = toBin(x);
    List<Integer> bi2 = toBin(y);
    System.out.println(bi1);
    System.out.println(bi2);
    int len1 = bi1.size(), index1 = 0;
    int len2 = bi2.size(), index2 = 0;
    int count = 0;
    
    if(len1 > len2) {
      for(index1 = 0; index1 < len1-len2; index1++) {
        if(bi1.get(index1) == 1) count++;
      }
    }else if(len2 > len1){
      for(index2 = 0; index2 < len2-len1; index2++) {
        if(bi2.get(index2) == 1) count++;
      }
    }
    while(index1 < len1) {
      if(bi1.get(index1) != bi2.get(index2)) {
        count++;
      }
      index1++;
      index2++;
    }
    return count;
    
  }
  
  private List<Integer> toBin(int number) {
    int num = number, rem = 0;
    List<Integer> res = new ArrayList<>();
    while(num > 0) {
      rem = num%2;
      res.add(0,rem);
      num = (num-rem)/2;
    }
    return res;
  }
}
