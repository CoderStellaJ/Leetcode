/*
Comparison with Basic Calculator II.java
Basic Calculator: 
1. use recursion to adjust the sequence to calculate the part in () first
2. consider the operator after the number and use sign to record it.
Basic Calculator II:
1. use pre variable to adjust the sequence to calculate * and / first
    num-pre; pre*v; num+pre;
    We can't use this method in Basic Calculator because with bracket, the whole previous part need to be remembered
2. consider the operator before the value so that yo can get 2 values at a time and do the operation
*/
//////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 5 ms, faster than 94.72% of Java online submissions for Basic Calculator.
Memory Usage: 38.7 MB, less than 93.27% of Java online submissions for Basic Calculator.

Complexity:
runtime: O(N)
space: O(1)

Algorithm 2: Recursion without Stack
1. a helper function returning an array whose first value is the result and the second value is the next start index
2. The logic is that it always considers the number and the operator after it which is different from stack
+ and - are recorded using sign
num is expanded to multiple digits using *10 + digit
( recursion; ) stop recursion;

Syntax:
1. return multiple elements: return an array
public int[] helper(String s, int start){}
return new int[]{result+num*sign, index};
2. convert char to int: c-'0'
*/
///////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int calculate(String s) {
        s = s.replaceAll(" ","");
        return helper(s,0)[0];
    }
    //first index is the int reault and the second result is the next start
    public int[] helper(String s, int start){
    	int num=0, sign=1, result=0, index=start;
    	while(index < s.length()){
    		char c = s.charAt(index++);
    		if(Character.isDigit(c)){
    			num = num*10+(c-'0');       //with bracket directly convert char to int
    		}
    		if(c == '('){
    			int[] tmp = helper(s,index);
    			index = tmp[1];
    			result += tmp[0]*sign;
    		}else if(c == ')'){
    			break;
    		}else if(c == '+'){
    			result += sign*num;     //important
    			sign = 1;
    			num = 0;
    		}else if(c == '-'){
    			result += sign*num;
    			sign = -1;
    			num = 0;
    		}

    	}
    	return new int[]{result+num*sign, index};       //plus the last num
    }
}

// int main(){
// 	Solution mysol = new Solution();
// 	System.out.println(mysol.calculate(" 3"));
// }

///////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 73 ms, faster than 9.64% of Java online submissions for Basic Calculator.
Memory Usage: 47.5 MB, less than 9.24% of Java online submissions for Basic Calculator.

Complexity:
runtime: O(N)
space: O(N)

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
