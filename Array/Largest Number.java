/*
Complexity:
runtime: O(nlogn)
space: O(n)

Algorithm 2:
1. First, we convert each integer to a string. Then, we sort the array of strings.
2. While it might be tempting to simply sort the numbers in descending order, 
this causes problems for sets of numbers with the same leading digit. e.g. 3 and 30
3. Assume that (without loss of generality), for some pair of integers a and b, 
our comparator dictates that a should precede b in sorted order. This means that ab > ba. 
For the sort to produce an incorrect ordering, there must be some c for which b precedes c and c precedes aa. 
This is a contradiction because ab > ba and bc > cb implies ac > ca. 
In other words, our custom comparator preserves transitivity, so the sort is correct.
4. There is a minor edge case that comes up when the array consists of only zeroes, 
so if the most significant number is 0, we can simply return 0. 
Otherwise, we build a string out of the sorted array and return it.

*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
  public String largestNumber(int[] nums) {
    String[] arr = new String[nums.length];
    for(int i = 0; i < nums.length; i++){
      arr[i] = Integer.toString(nums[i]);
    }
    Arrays.sort(arr, new LargeNumberComparator());    //use a new comparator
    StringBuilder sb = new StringBuilder();
    if(arr[0].charAt(0) == '0') return "0";
    for(String str:arr){
      sb.append(str);
    }
    return sb.toString();
  }
  
  private class LargeNumberComparator implements Comparator<String> {
    @Override     //for readability
    public int compare(String a, String b) {    //the function is compare()
      String str1 = a+b;
      String str2 = b+a;
      if(str1.compareTo(str2) > 0) return -1;   //if return +, the first one will be placed at back
      return 1;
    }
  }
}
/////////////////////////////////////////////////////////////////////////////
/*
Problem:
NumberFormatException, long type is not enough for holding the value

Complexity:
runtime: O(N^2)
space: O(N*M)

Algorithm 1: Greedy
*/
//////////////////////////////////////////////////////////////////////////////////////
class Solution {
  public String largestNumber(int[] nums) {
    if(nums.length == 0) return "0";
    List<Integer> ans = helper(nums, nums.length-1);
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < ans.size(); i++) {
      sb.append(ans.get(i));
    }
    return sb.toString();
  }
  
  public List<Integer> helper(int[] nums, int start) {
    int num = nums[start];
    if(start == 0) {
      List<Integer> ans = new ArrayList<>();
      ans.add(num);
      return ans;
    }else {
      List<Integer> sub = helper(nums, start-1);
      sub.add(0, num);
      StringBuilder newnum = new StringBuilder();
      for(int number:sub){
        String numstr = Integer.toString(number);
        newnum.append(numstr);
      }
      long max = Long.parseLong(newnum.toString());
      int index = 0;
      sub.remove(0);
      
      for(int i = 1; i <= sub.size(); i++) {
        sub.add(i, num);
        newnum = new StringBuilder();
        for(int number:sub) {
          String numstr = Integer.toString(number);
          newnum.append(numstr);
        }
        long value = Long.parseLong(newnum.toString());
        if(value > max){
          max = value;
          index = i;
        }
        sub.remove(i);
      }
      sub.add(index,num);
      return sub;
    }
  }
}
