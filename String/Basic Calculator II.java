/*
Complexity: 
runtime: O(N)
space: O(N)

Algorithm 2: 1 Stack
Instead of using 2 stacks to reverse the sequence, we can loop through the string from the end to start and use 1 stack only.
But this algorithm has 1 problem: 5/2*6, it cannot start * first

*/
//////////////////////////////////////////////////////////////////////////////////////////////
/*
Runtime: 84 ms, faster than 5.01% of Java online submissions for Basic Calculator II.
Memory Usage: 56.2 MB, less than 5.02% of Java online submissions for Basic Calculator II.

Complexity:
runtime: O(N)
space: O(N)

Algorithm 1: 2 Stacks
use 1 stack to deal with * or / from the beginning
for each operand, check the top operator in stack. If it's * or /, do the operation.
Otherwise, just push it inside
Then use another stack to reverse the sequence to make sure the precedence is correct.

For this algorithm: Some details are marked in the code 

Note:
for taking string as int questions, please check whether the type is correct, whether you've converted all the types

Syntax:
1. convert character to int
Character.getNumericValue()
2. for number >= 10, need to use String instead of Character
3. remove all white spaces in a string
mysre = mystr.replaceAll(" ","");
remember to assign the replaced result back to mystr!
4. compare 2 strings
cannot use ==, because it compares whether the 2 strings are the same object
we can only use str1.equals(str2) actually compares the content of the string
This method returns true if the String are equal; false otherwise.
5. stack.pop()
This method returns the element present at the top of the stack and then removes it.
6. Character.isDigit(mychar)
7. split a string based on multiple delimiters
String[] operands = s.split("[+|-|*|/]");
8. queue
offer/poll/peek
9. arraylist
ArrayList<String> cars = new ArrayList<String>(); // Create an ArrayList object
10. convert an array to arraylist
ArrayList<Element> arrayList = new ArrayList<Element>(Arrays.asList(array));
*/
//////////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public int calculate(String s) {
        int res = 0;
        String opt="";
        //remove all empty spaces in a string
        s = s.replaceAll(" ","");
        if(s.length() == 0) return 0;
        Stack<String> mystack = new Stack<String>();
        Stack<String> simple = new Stack<String>();
        StringBuilder operand = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if(Character.isDigit(c)) operand.append(c);
          if(!Character.isDigit(c) || i == s.length()-1){   //also need to take care of the last operand
            int val = Integer.parseInt(operand.toString());
            operand = new StringBuilder();
            if(!mystack.isEmpty() && (mystack.peek().equals("*") || mystack.peek().equals("/"))){
              opt = mystack.pop();
              int value1 = Integer.parseInt(mystack.pop());
              if(opt.equals("*")){
                mystack.push(Integer.toString(val*value1));
              }else{
                mystack.push(Integer.toString(value1/val));
              }
            }else{
              mystack.push(Integer.toString(val));
            }
            if(i != s.length()-1) mystack.push(Character.toString(c));      //push when it's not operator
          }
        }
        //the last digit
        //simple.push(operand.toString()); //cannot do this because you consider the operator before it e.g. 3+2*2
        while(!mystack.isEmpty()){
          simple.push(mystack.pop());
        }
        while(simple.size() > 1){
          int value1 = Integer.parseInt(simple.pop());
          opt = simple.pop();
          int value2 = Integer.parseInt(simple.pop());
          if(opt.equals("+")){
            simple.push(Integer.toString(value1+value2));
          }else{
            simple.push(Integer.toString(value1-value2));
          }
        }
        res = (simple.size() == 1) ? Integer.parseInt(simple.pop()):0;
        return res;
    }
}
