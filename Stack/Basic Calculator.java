/*
Runtime: 73 ms, faster than 9.64% of Java online submissions for Basic Calculator.
Memory Usage: 47.5 MB, less than 9.24% of Java online submissions for Basic Calculator.
Algorithm 1: 2 Stacks
mystack is used to process ( and )
and inside ( and ) we pop out mystack into op stack to get the correct sequence and do the operation
Note: 
1. the problem is the same as in Basic Calculator II which is to extract numbers
note when s.charAt(i) is digit, initialize end to i+1 first
2. convert between int, string and char
*/
/////////////////////////////////////////////////////////////////////////////
class Solution {
    public int calculate(String s) {
      s = s.replaceAll(" ","");
      if(s.length() == 0) return 0;
      Stack<String> mystack = new Stack<String>();
      Stack<String> op = new Stack<String>();
      int start=0, end=0;  //for current value v
      int val1=0, val2=0;   //for operation
      String operator="";
      for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(Character.isDigit(c)){
          end = i+1;    //important
          while(end < s.length() && Character.isDigit(s.charAt(end))) end++;
            //System.out.println("i "+i+" end "+end);
          mystack.push(s.substring(i,end));
          i = end-1;
        }else{
          if(c == ')'){
            //do operation
            while(!mystack.peek().equals("(")) op.push(mystack.pop());
            mystack.pop();    //pop (
            //put this part into op
            while(op.size() > 1){
              val1 = Integer.parseInt(op.pop());
              operator = op.pop();
              val2 = Integer.parseInt(op.pop());
              if(operator.equals("+")) op.push(Integer.toString(val1+val2));
              else op.push(Integer.toString(val1-val2));
            }
            mystack.push(op.pop());   //push in the reault within the bracket
          }else{
            //for ( and + -
            mystack.push(Character.toString(c));
          }
        }
      }
      //At last do the operations
      while(!mystack.isEmpty()) op.push(mystack.pop());
      while(op.size() > 1){
        val1 = Integer.parseInt(op.pop());
        operator = op.pop();
        val2 = Integer.parseInt(op.pop());
        if(operator.equals("+")) op.push(Integer.toString(val1+val2));
        else op.push(Integer.toString(val1-val2));
      }
      return Integer.parseInt(op.pop());    //convert to int
    }
}
